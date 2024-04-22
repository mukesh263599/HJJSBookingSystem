
package hjjsbookingsystem;

import static hjjsbookingsystem.HJJSBookingInterface.isNumeric;
import static hjjsbookingsystem.LessonSchedules.updateClass;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class ScheduledBookings {
    
    private int bookingCode;
    private int lRollNo;
    private int scheduleNo;
    private String status;
    private String bookingOn;
    
    public static ArrayList <ScheduledBookings> bData = new ArrayList<>();
    
    
    public static final String BOOKED = "Booked";
    public static final String CANCEL = "Cancelled";
    public static final String ATTEND = "Attended";
    public static final String CHANGE = "Changed";

    public static int tempBookingCodeToChange = 0;
    

    public ScheduledBookings(int bookingCode, int lRollNo, int scheduleNo, String status, String bookingOn) {
        this.bookingCode = bookingCode;
        this.lRollNo = lRollNo;
        this.scheduleNo = scheduleNo;
        this.status = status;
        this.bookingOn = bookingOn;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public int getlRollNo() {
        return lRollNo;
    }

    public int getScheduleNo() {
        return scheduleNo;
    }

    public String getStatus() {
        return status;
    }

    public String getBookingOn() {
        return bookingOn;
    }

    public static ArrayList<ScheduledBookings> getbData() {
        return bData;
    }

    public void setScheduleNo(int scheduleNo) {
        this.scheduleNo = scheduleNo;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    //Book class Info
    public static void bookClassInfo(){
        Scanner sc = new Scanner(System.in);

        System.out.print("\nPress y to book a class : ");
        String choice = sc.nextLine();

        if(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("Yes")){
            LessonSchedules.bookClass = 1;
            
            System.out.println("\nSelect any Learner from below list : ");
            Learners.displayLearners();

            System.out.print("\nEnter RollNo to book class :");
            String rollNo = sc.nextLine();

            //Validations
            if(rollNo.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(rollNo)){
                do{
                    System.out.print("\nPlease enter valid RollNo : ");
                    rollNo = sc.nextLine();
                }while(rollNo.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(rollNo));
            }

            boolean isValidated = ValidateClass.isValidatedLearner(Integer.parseInt(rollNo));

            if(!isValidated || !HJJSBookingInterface.isNumeric(rollNo)){
                do{
                    System.out.print("\nPlease Enter Valid RollNo : ");
                    rollNo = sc.nextLine();
                     isValidated = ValidateClass.isValidatedLearner(Integer.parseInt(rollNo));
                }while(!isValidated || !HJJSBookingInterface.isNumeric(rollNo));
            }

            System.out.print("\nEnter Secret Code : ");
            String secretCode = sc.nextLine();

             //Validations
            if(secretCode.equalsIgnoreCase("")){
                do{
                    System.out.print("\nPlease enter valid Secret Code : ");
                    secretCode = sc.nextLine();
                }while(secretCode.equalsIgnoreCase(""));
            }

            boolean isValidatedCode = ValidateClass.isValidatedLearnerCode(Integer.parseInt(rollNo),secretCode);

            if(!isValidatedCode){
                System.out.println("\nSecret Code not valid");
                return;
            }

            System.out.print("\nEnter Schedule No to book :");
            String scheduleNo = sc.nextLine();

            //Validations
            if(scheduleNo.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(scheduleNo)){
                do{
                    System.out.print("\nPlease enter valid Schedule No : ");
                    scheduleNo = sc.nextLine();
                }while(scheduleNo.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(scheduleNo));
            }

            boolean isValidatedSchedule = ValidateClass.isValidatedSchedule(Integer.parseInt(scheduleNo));

            if(!isValidatedSchedule || !HJJSBookingInterface.isNumeric(scheduleNo)){
                do{
                    System.out.print("\nPlease Enter Valid Schedule No : ");
                    scheduleNo = sc.nextLine();
                     isValidatedSchedule = ValidateClass.isValidatedLearner(Integer.parseInt(scheduleNo));
                }while(!isValidatedSchedule || !HJJSBookingInterface.isNumeric(scheduleNo));
            }

            ScheduledBookings.bookNewClass(Integer.parseInt(rollNo),Integer.parseInt(scheduleNo));
            return;

        }else{
            return;
        }
    }
    
    

    //Book new Class
    public static void bookNewClass(int rollNo, int scheduleNo){
        
        Random random = new Random();
        int bookingNo = random.nextInt(1000);

        //Current datetime
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY 'at' h:mm:ss a");
        String formattedDateTime = now.format(formatter);
        
            
        //Seat Available
        int numOfSeats = ValidateClass.seatsAvailableOrNot(scheduleNo);
        if(numOfSeats <= 0){
            System.out.println("\nNo Seat Available.");
            return;
        }

        //Is Booking Same Lesson
        boolean isTwiceBookingClass = ValidateClass.isTwiceBookingClass(scheduleNo,rollNo);
        if(isTwiceBookingClass){
            System.out.println("\nNot Allowed to book same class twice.");
            return;
        }

        //Is Booking Higher / Lower Grade Level
        boolean matchCurrentGradeWithClassGrade = ValidateClass.matchCurrentGradeWithClassGrade(scheduleNo,rollNo);
        int currentGrade = ValidateClass.getLearnerCurrentGrade(rollNo);
        if(matchCurrentGradeWithClassGrade){
            if((currentGrade) < 5){
                System.out.println("\nYou are required to book schedule with grade "+currentGrade+" or "+(currentGrade+1));
            }else{
                System.out.println("\nYou are required to book schedule with grade "+currentGrade);
            }
            return;
        }

        ScheduledBookings obj = new ScheduledBookings(bookingNo, rollNo,scheduleNo,BOOKED, formattedDateTime);
        ScheduledBookings.bData.add(obj);
        
        //Update seats by subtracting by 1
        ValidateClass.updateNumOfSeats(scheduleNo,0,1);
        LessonSchedules.bookClass = 0;
        LessonSchedules.applyFilter = bookingNo;
        System.out.println("\nBooking Successful with Booking Code "+bookingNo);

    }
    
    

    //Update class Info
    public static void updateClassInfo(){
             
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Schedule No to change :");
        String scheduleNo = sc.nextLine();

        //Validations
        if(scheduleNo.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(scheduleNo)){
            do{
                System.out.print("\nPlease enter valid Schedule No : ");
                scheduleNo = sc.nextLine();
            }while(scheduleNo.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(scheduleNo));
        }

        boolean isValidatedSchedule = ValidateClass.isValidatedSchedule(Integer.parseInt(scheduleNo));

        if(!isValidatedSchedule || !HJJSBookingInterface.isNumeric(scheduleNo)){
            do{
                System.out.print("\nPlease Enter Valid Schedule No : ");
                scheduleNo = sc.nextLine();
                 isValidatedSchedule = ValidateClass.isValidatedLearner(Integer.parseInt(scheduleNo));
            }while(!isValidatedSchedule || !HJJSBookingInterface.isNumeric(scheduleNo));
        }
        
        ScheduledBookings.updateBooking(Integer.parseInt(scheduleNo));
        updateClass = 0;
        System.out.println("\nUpdate Class Successful");
        return;
    }
    
    //Update a Booking
    public static void updateBooking(int scheduleNo){
        
        int rollNo = ValidateClass.getLearnerRollNo(ScheduledBookings.tempBookingCodeToChange);
         
        //Seat Available
        int numOfSeats = ValidateClass.seatsAvailableOrNot(scheduleNo);
        if(numOfSeats <= 0){
            System.out.println("\nNo Seat Available.");
            return;
        }

        //Is Booking Same Lesson
        boolean isTwiceBookingClass = ValidateClass.isTwiceBookingClass(scheduleNo,rollNo);
        if(isTwiceBookingClass){
            System.out.println("\nNot Allowed to book same class twice.");
            return;
        }

        //Is Booking Higher / Lower Grade Level
        boolean matchCurrentGradeWithClassGrade = ValidateClass.matchCurrentGradeWithClassGrade(scheduleNo,rollNo);
        int currentGrade = ValidateClass.getLearnerCurrentGrade(rollNo);
        if(matchCurrentGradeWithClassGrade){
            if((currentGrade) < 5){
                System.out.println("\nYou are required to book schedule with grade "+currentGrade+" or "+(currentGrade+1));
                return;
            }else{
                System.out.println("\nYou are required to book schedule with grade "+currentGrade);
                return;
            }
        }

        List<ScheduledBookings> bData = ScheduledBookings.getbData();
        
        int prevScheduleNo = 0;
        for(ScheduledBookings obj : bData){
            if(obj.getBookingCode() == tempBookingCodeToChange){
                prevScheduleNo = obj.getScheduleNo();
                obj.setStatus(ScheduledBookings.CHANGE);
                obj.setScheduleNo(scheduleNo);
            }
        }
        
        //Update seats by adding by 1
        ValidateClass.updateNumOfSeats(prevScheduleNo,1,0);
        
        //Update seats by subtracting by 1
        ValidateClass.updateNumOfSeats(scheduleNo,0,1);
        
        tempBookingCodeToChange = 0;
    }
    
    
    
    //Cancel a Booking
    public static void cancelBooking(int bookingCode){
        List<ScheduledBookings> bData = ScheduledBookings.getbData();
        int scheduleNo = 0;
        for(ScheduledBookings obj : bData){
            if(obj.getBookingCode() == bookingCode){
                scheduleNo = obj.getScheduleNo();
                obj.setStatus(ScheduledBookings.CANCEL);
            }
        }
            
        //Update seats by subtracting by 1
        ValidateClass.updateNumOfSeats(scheduleNo,1,0);
    }
    

    //Display Booking Info
    public static void displayBookingsInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPress 1 to view Booking for Staff");
        System.out.println("\nPress 2 to view Booking for Learner");
        System.out.print("\nPlease Select your Role: ");

        String role = sc.nextLine();
        
        if(role.isEmpty() || !HJJSBookingInterface.isNumeric(role) || 
                !(role.equals("1") || role.equals("2"))){
            do{
                System.out.print("\nPlease Select your Role: ");
                role = sc.nextLine();
            }while(role.isEmpty() || !HJJSBookingInterface.isNumeric(role) || 
                !(role.equals("1") || role.equals("2")));
        }
         
        
         boolean isStaff = false;
         boolean isLearner = false;
         String rollNo = "";
         
         if(role.equalsIgnoreCase("2")){
               
            System.out.println("\nSelect any Learner from below list : ");
            Learners.displayLearners();
            
            isLearner = true;
            System.out.print("\nEnter RollNo to book class :");
            rollNo = sc.nextLine();

            //Validations
            if(rollNo.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(rollNo)){
                do{
                    System.out.print("\nPlease enter valid RollNo : ");
                    rollNo = sc.nextLine();
                }while(rollNo.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(rollNo));
            }

            boolean isValidated = ValidateClass.isValidatedLearner(Integer.parseInt(rollNo));

            if(!isValidated || !HJJSBookingInterface.isNumeric(rollNo)){
                do{
                    System.out.print("\nPlease Enter Valid RollNo : ");
                    rollNo = sc.nextLine();
                     isValidated = ValidateClass.isValidatedLearner(Integer.parseInt(rollNo));
                }while(!isValidated || !HJJSBookingInterface.isNumeric(rollNo));
            }

            System.out.print("\nEnter Secret Code : ");
            String secretCode = sc.nextLine();

             //Validations
            if(secretCode.equalsIgnoreCase("")){
                do{
                    System.out.print("\nPlease enter valid Secret Code : ");
                    secretCode = sc.nextLine();
                }while(secretCode.equalsIgnoreCase(""));
            }

            boolean isValidatedCode = ValidateClass.isValidatedLearnerCode(Integer.parseInt(rollNo),secretCode);

            if(!isValidatedCode){
                System.out.println("\nSecret Code not valid");
                return;
            }
            displayBookings(Integer.parseInt(rollNo));

         }else{
            isStaff = true;
            System.out.print("\nEnter Secret Code : ");
            String secretCode = sc.nextLine();

             //Validations
            if(secretCode.equalsIgnoreCase("")){
                do{
                    System.out.print("\nPlease enter valid Secret Code : ");
                    secretCode = sc.nextLine();
                }while(secretCode.equalsIgnoreCase(""));
            }

            boolean isValidatedCode = ValidateClass.isValidatedStaffCode(secretCode);

            if(!isValidatedCode){
                System.out.println("\nSecret Code not valid");
                return;
            }
            displayBookings(0);
         }
         
    }
    
    

    //Display Booking
    public static void displayBookings(int rollNo){
        
        List<LessonSchedules> ldata = LessonSchedules.getsData();
        List<Learners> lrdata = Learners.getlData();
        List<Coaches> cdata = Coaches.getcData();
        List<ScheduledBookings> bData = ScheduledBookings.getbData();
        List<Coaches> chData = Coaches.getcData();
         
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-12s | %-15s | %-12s | %-30s | %-10s | %-8s | %-17s | %-18s | %-17s |  %-17s | %-25s |\n",
                "Booking Code",  "Booking Status",   "ScheduleNo", 
                "Scheduled Lesson", "Timings","Day","Class Grade Level","Instructed By","Booking By","Learner Level","Booking Date");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        Set<Integer> unique = new HashSet<>(); 
        for (ScheduledBookings obj : bData) {
            if (!unique.contains(obj.getBookingCode())){
                unique.add(obj.getBookingCode());
                
                //Booking By
                String fullname ="";
                int currentGrade = 0;
                for (Learners lObj : lrdata) {
                    if(lObj.getlRollNo() == obj.getlRollNo()){
                        fullname = lObj.getlFullname();
                        currentGrade = lObj.getlCurrentGradeLevel();
                        break;
                    }
                }
                
                //Lesson Grade Level
                int scheduledLessonGrade = 0;
                String lessonName = "";
                String instructedBy = "";
                String timings = "";
                String weekday = "";
                for (LessonSchedules lObj : ldata) {
                    if(lObj.getScheduleNo() == obj.getScheduleNo()){
                        
                        for(Coaches coachObj : chData){
                            if(coachObj.getCoachNo() == lObj.getCoachNo()){
                                instructedBy = coachObj.getFirstName()+" "+coachObj.getLastName();
                                break;
                            }
                        }
                        scheduledLessonGrade = lObj.getScheduledLesssonGrade();
                        lessonName = lObj.getScheduledLessonName();
                        weekday = lObj.getScheduleWeekDay();
                        timings = lObj.getStartTime()+"-"+lObj.getEndTime();
                        break;
                    }
                }
                //if learner      
                 if(rollNo != 0 && obj.getlRollNo() == rollNo){
                    System.out.printf("| %-12s | %-15s | %-12s | %-30s | %-10s | %-8s | %-17s | %-18s | %-17s |  %-17s | %-25s |\n",
                   obj.getBookingCode(),  obj.getStatus(),   obj.getScheduleNo(), 
                   lessonName, timings,weekday,scheduledLessonGrade,instructedBy,fullname,currentGrade,obj.getBookingOn());
                    
                // if staff
                }else if (rollNo == 0){
                    System.out.printf("| %-12s | %-15s | %-12s | %-30s | %-10s | %-8s | %-17s | %-18s | %-17s |  %-17s | %-25s |\n",
                   obj.getBookingCode(),  obj.getStatus(),   obj.getScheduleNo(), 
                   lessonName, timings,weekday,scheduledLessonGrade,instructedBy,fullname,currentGrade,obj.getBookingOn());
                }
            }
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    //Take Booking Info
    public static int takeBookingInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Booking Code to Update Class : ");
        String bookingCode = sc.nextLine();
                            
        if(bookingCode.equalsIgnoreCase("") || !isNumeric(bookingCode)){
            do{
                System.out.print("\nPlease enter valid Booking Code : ");
                bookingCode = sc.nextLine();
            }while(bookingCode.equalsIgnoreCase("") || !isNumeric(bookingCode));
        }

        boolean isBookingCodeFound = ValidateClass.getBookingCode(Integer.parseInt(bookingCode));
        if(!isBookingCodeFound){
             System.out.println("\nBooking Code was invalid");
             return 0;
        }
     
        //Is Booking Same Lesson
        boolean isAttendedOrCancelled = ValidateClass.isCancelledOrAttended(Integer.parseInt(bookingCode));
        if(isAttendedOrCancelled){
             System.out.println("\nBooking already cancelled or attended");
             return 0;
        }
       return Integer.parseInt(bookingCode);
    }
    
}
