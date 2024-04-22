
package hjjsbookingsystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class LessonSchedules {
    
    
    private int scheduleNo;
    private String scheduleWeekDay;
    private String scheduledLessonName;
    private int scheduledLesssonGrade;
    private String duration;
    private String startTime;
    private String endTime;
    private String scheduledDate;
    private int numOfSeats;
    private int coachNo;
    
    public static int bookClass = 0;
    public static int updateClass = 0;
    public static int applyFilter = 0;

    public static ArrayList <LessonSchedules> sData = new ArrayList<>();

    public LessonSchedules(int scheduleNo, String scheduleWeekDay, String scheduledLessonName, int scheduledLesssonGrade, String duration, String startTime,
            String endTime, String scheduledDate, int numOfSeats, int coachNo) {
        this.scheduleNo = scheduleNo;
        this.scheduleWeekDay = scheduleWeekDay;
        this.scheduledLessonName = scheduledLessonName;
        this.scheduledLesssonGrade = scheduledLesssonGrade;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.scheduledDate = scheduledDate;
        this.numOfSeats = numOfSeats;
        this.coachNo = coachNo;
    }

    public int getScheduleNo() {
        return scheduleNo;
    }

    public String getScheduleWeekDay() {
        return scheduleWeekDay;
    }

    public String getScheduledLessonName() {
        return scheduledLessonName;
    }

    public int getScheduledLesssonGrade() {
        return scheduledLesssonGrade;
    }

    public String getDuration() {
        return duration;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public int getCoachNo() {
        return coachNo;
    }

    public static ArrayList<LessonSchedules> getsData() {
        saveData();
        return sData;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }
    
    //Save Data
    private static void saveData(){
        LessonSchedules o1 = new LessonSchedules(101,"Mon","Introduction to Water Skills",1,"1 hour","4pm",
                "5pm","01-04-2024",4,801);
        LessonSchedules o2 = new LessonSchedules(102,"Mon","Stroke Development",2,"1 hour","5pm",
                 "6pm","01-04-2024",4,802);
        LessonSchedules o3 = new LessonSchedules(103,"Mon","Fundamental Aquatic Skills",3,"1 hour","6pm",
                  "7pm","01-04-2024",4,803);
          
          
        LessonSchedules o4 = new LessonSchedules(104,"Wed","Introduction to Water Skills",4,"1 hour",
                   "4pm","5pm","03-04-2024",4,804);
        LessonSchedules o5 = new LessonSchedules(105,"Wed","Stroke Development",5,"1 hour","5pm",
                 "6pm","03-04-2024",4,805);
        LessonSchedules o6 = new LessonSchedules(106,"Wed","Fundamental Aquatic Skills",1,"1 hour","6pm",
                  "7pm","03-04-2024", 4,803);
          
            
        LessonSchedules o7 = new LessonSchedules(107,"Fri","Introduction to Water Skills",3,"1 hour",
                   "4pm","5pm","05-04-2024",4,802);
        LessonSchedules o8 = new LessonSchedules(108,"Fri","Stroke Development",4,"1 hour","5pm",
                 "6pm","05-04-2024",4,801);
        LessonSchedules o9 = new LessonSchedules(109,"Fri","Fundamental Aquatic Skills",2,"1 hour","6pm",
                  "7pm","05-04-2024", 4,804);
          
            
        LessonSchedules o10 = new LessonSchedules(110,"Sat","Introduction to Water Skills",1,"1 hour",
                   "2pm","3pm","06-04-2024",4,805);
        LessonSchedules o11 = new LessonSchedules(111,"Sat","Stroke Development",5,"1 hour","3pm",
                 "4pm","06-04-2024",4,802);
          
          
        LessonSchedules o12 = new LessonSchedules(112,"Mon","Introduction to Water Skills",3,"1 hour","4pm",
                "5pm","08-04-2024",4,804);
        LessonSchedules o13 = new LessonSchedules(113,"Mon","Stroke Development",1,"1 hour","5pm",
                 "6pm","08-04-2024",4,805);
        LessonSchedules o14 = new LessonSchedules(114,"Mon","Fundamental Aquatic Skills",2,"1 hour","6pm",
                  "7pm","08-04-2024",4,802);
          
          
        LessonSchedules o15 = new LessonSchedules(115,"Wed","Introduction to Water Skills",5,"1 hour",
                   "4pm","5pm","10-04-2024",4,805);
        LessonSchedules o16 = new LessonSchedules(116,"Wed","Stroke Development",4,"1 hour","5pm",
                 "6pm","10-04-2024",4,801);
        LessonSchedules o17 = new LessonSchedules(117,"Wed","Fundamental Aquatic Skills",3,"1 hour","6pm",
                  "7pm","10-04-2024", 4,804);
          
            
        LessonSchedules o18 = new LessonSchedules(118,"Fri","Introduction to Water Skills",2,"1 hour",
                   "4pm","5pm","12-04-2024",4,803);
        LessonSchedules o19 = new LessonSchedules(119,"Fri","Stroke Development",3,"1 hour","5pm",
                 "6pm","12-04-2024",4,802);
        LessonSchedules o20 = new LessonSchedules(120,"Fri","Fundamental Aquatic Skills",1,"1 hour","6pm",
                  "7pm","12-04-2024", 4,801);
          
            
        LessonSchedules o21 = new LessonSchedules(121,"Sat","Introduction to Water Skills",3,"1 hour",
                   "2pm","3pm","13-04-2024",4,805);
        LessonSchedules o22 = new LessonSchedules(122,"Sat","Stroke Development",5,"5 hour","3pm",
                 "4pm","13-04-2024",4,801);
          
          
          
        LessonSchedules o23 = new LessonSchedules(123,"Mon","Introduction to Water Skills",4,"1 hour","4pm",
                "5pm","15-04-2024",4,801);
        LessonSchedules o24 = new LessonSchedules(124,"Mon","Stroke Development",5,"1 hour","5pm",
                 "6pm","15-04-2024",4,803);
        LessonSchedules o25 = new LessonSchedules(125,"Mon","Fundamental Aquatic Skills",1,"1 hour","6pm",
                  "7pm","15-04-2024",4,804);
          
          
        LessonSchedules o26 = new LessonSchedules(126,"Wed","Introduction to Water Skills",3,"1 hour",
                   "4pm","5pm","17-04-2024",4,801);
        LessonSchedules o27 = new LessonSchedules(127,"Wed","Stroke Development",2,"1 hour","5pm",
                 "6pm","17-04-2024",4,805);
        LessonSchedules o28 = new LessonSchedules(128,"Wed","Fundamental Aquatic Skills",5,"1 hour","6pm",
                  "7pm","17-04-2024", 4,803);
          
            
        LessonSchedules o29 = new LessonSchedules(129,"Fri","Introduction to Water Skills",1,"1 hour",
                   "4pm","5pm","19-04-2024",4,805);
        LessonSchedules o30 = new LessonSchedules(130,"Fri","Stroke Development",4,"1 hour","5pm",
                 "6pm","19-04-2024",4,804);
        LessonSchedules o31 = new LessonSchedules(131,"Fri","Fundamental Aquatic Skills",2,"1 hour","6pm",
                  "7pm","19-04-2024", 4,802);
          
            
        LessonSchedules o32 = new LessonSchedules(132,"Sat","Introduction to Water Skills",1,"1 hour",
                   "2pm","3pm","20-04-2024",4,805);
        LessonSchedules o33 = new LessonSchedules(133,"Sat","Stroke Development",4,"5 hour","3pm",
                 "4pm","20-04-2024",4,804);
          

        LessonSchedules o34 = new LessonSchedules(134,"Mon","Introduction to Water Skills",3,"1 hour","4pm",
                "5pm","22-04-2024",4,802);
        LessonSchedules o35 = new LessonSchedules(135,"Mon","Stroke Development",2,"1 hour","5pm",
                 "6pm","22-04-2024",4,801);
        LessonSchedules o36 = new LessonSchedules(136,"Mon","Fundamental Aquatic Skills",5,"1 hour","6pm",
                  "7pm","22-04-2024",4,803);
          
          
        LessonSchedules o37 = new LessonSchedules(137,"Wed","Introduction to Water Skills",4,"1 hour",
                   "4pm","5pm","24-04-2024",4,805);
        LessonSchedules o38 = new LessonSchedules(138,"Wed","Stroke Development",3,"1 hour","5pm",
                 "6pm","24-04-2024",4,804);
        LessonSchedules o39 = new LessonSchedules(139,"Wed","Fundamental Aquatic Skills",1,"1 hour","6pm",
                  "7pm","24-04-2024", 4,802);
          
            
        LessonSchedules o40 = new LessonSchedules(140,"Fri","Introduction to Water Skills",2,"1 hour",
                   "4pm","5pm","26-04-2024",4,803);
        LessonSchedules o41 = new LessonSchedules(141,"Fri","Stroke Development",3,"1 hour","5pm",
                 "6pm","26-04-2024",4,801);
        LessonSchedules o42 = new LessonSchedules(142,"Fri","Fundamental Aquatic Skills",5,"1 hour","6pm",
                  "7pm","26-04-2024", 4,803);
          
            
        LessonSchedules o43 = new LessonSchedules(143,"Sat","Introduction to Water Skills",1,"1 hour",
                   "2pm","3pm","27-04-2024",4,802);
        LessonSchedules o44 = new LessonSchedules(144,"Sat","Stroke Development",2,"5 hour","3pm",
                 "4pm","27-04-2024",4,803);
          
        
        LessonSchedules.sData.add(o1);
        LessonSchedules.sData.add(o2);
        LessonSchedules.sData.add(o3);
        LessonSchedules.sData.add(o4);
        LessonSchedules.sData.add(o5);
        LessonSchedules.sData.add(o6);
        LessonSchedules.sData.add(o7);
        LessonSchedules.sData.add(o8);
        LessonSchedules.sData.add(o9);
        LessonSchedules.sData.add(o10);
        LessonSchedules.sData.add(o11);
        LessonSchedules.sData.add(o12);
        LessonSchedules.sData.add(o13);
        LessonSchedules.sData.add(o14);
        LessonSchedules.sData.add(o15);
        LessonSchedules.sData.add(o16);
        LessonSchedules.sData.add(o17);
        LessonSchedules.sData.add(o18);
        LessonSchedules.sData.add(o19);
        LessonSchedules.sData.add(o20);
        LessonSchedules.sData.add(o21);
        LessonSchedules.sData.add(o22);
        LessonSchedules.sData.add(o23);
        LessonSchedules.sData.add(o24);
        LessonSchedules.sData.add(o25);
        LessonSchedules.sData.add(o26);
        LessonSchedules.sData.add(o27);
        LessonSchedules.sData.add(o28);
        LessonSchedules.sData.add(o29);
        LessonSchedules.sData.add(o30);
        LessonSchedules.sData.add(o31);
        LessonSchedules.sData.add(o32);
        LessonSchedules.sData.add(o33);
        LessonSchedules.sData.add(o34);
        LessonSchedules.sData.add(o35);
        LessonSchedules.sData.add(o36);
        LessonSchedules.sData.add(o37);
        LessonSchedules.sData.add(o38);
        LessonSchedules.sData.add(o39);
        LessonSchedules.sData.add(o40);
        LessonSchedules.sData.add(o41);
        LessonSchedules.sData.add(o42);
        LessonSchedules.sData.add(o43);
        LessonSchedules.sData.add(o44);
          
    }
    
    //Filter Schedule
    public static void filterSchedule(){
        applyFilter = 1;
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            choice = filterOptions();
            switch (choice) {
                case 1 -> {
                       System.out.println("\n(Mon | Wed | Fri | Sat)");
                        System.out.print("Please Enter Weekday : ");
                        String selectedWeekDay = sc.nextLine();

                        if(selectedWeekDay.equalsIgnoreCase("")){
                            do{
                                System.out.print("\nPlease Enter Valid Weekday : ");
                                selectedWeekDay = sc.nextLine();
                            }while(selectedWeekDay.equalsIgnoreCase(""));
                        }

                        if(!(selectedWeekDay.equalsIgnoreCase("Mon") || selectedWeekDay.equalsIgnoreCase("Wed") || selectedWeekDay.equalsIgnoreCase("Fri") ||
                                selectedWeekDay.equalsIgnoreCase("Sat") || selectedWeekDay.equalsIgnoreCase("Monday") || selectedWeekDay.equalsIgnoreCase("Wednesday") 
                                || selectedWeekDay.equalsIgnoreCase("Friday") || selectedWeekDay.equalsIgnoreCase("Saturday"))){
                            do{
                                System.out.print("\nPlease enter valid weekday : ");
                                selectedWeekDay = sc.nextLine();
                            }while(!(selectedWeekDay.equalsIgnoreCase("Mon") || selectedWeekDay.equalsIgnoreCase("Wed") || 
                                    selectedWeekDay.equalsIgnoreCase("Fri") ||
                                selectedWeekDay.equalsIgnoreCase("Sat") || selectedWeekDay.equalsIgnoreCase("Monday") || selectedWeekDay.equalsIgnoreCase("Wednesday") 
                                || selectedWeekDay.equalsIgnoreCase("Friday") || selectedWeekDay.equalsIgnoreCase("Saturday")));
                        }
                        
                        if(selectedWeekDay.equalsIgnoreCase("Monday")){
                            selectedWeekDay = "Mon";
                        }else if(selectedWeekDay.equalsIgnoreCase("Wednesday")){
                            selectedWeekDay = "Wed";
                        }else if(selectedWeekDay.equalsIgnoreCase("Friday")){
                            selectedWeekDay = "Fri";
                        }else if(selectedWeekDay.equalsIgnoreCase("Saturday")){
                            selectedWeekDay = "Sat";
                        }

                        displaySchedule(0,selectedWeekDay,0);
                }
                case 2 -> {
                        System.out.println("\n(1 to 5)");
                        System.out.print("Please Enter Grade Level : ");
                        String selectedGradeLevel = sc.nextLine();

                        if(selectedGradeLevel.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(selectedGradeLevel) || (Integer.parseInt(selectedGradeLevel) < 0 
                                || Integer.parseInt(selectedGradeLevel) > 5)){
                            do{
                                System.out.print("\nPlease Enter Valid Grade Level (1 to 5) : ");
                                selectedGradeLevel = sc.nextLine();
                            }while(selectedGradeLevel.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(selectedGradeLevel) || (Integer.parseInt(selectedGradeLevel) < 0 
                                    || Integer.parseInt(selectedGradeLevel) > 5));
                        }
                        displaySchedule(Integer.parseInt(selectedGradeLevel),"",0);
                }
                case 3 -> {   
                        System.out.println("\nSelect any Coach from below list : ");
                        Coaches.displayCoach();
        
                        System.out.print("Please Enter Coach Num : ");
                        String selectedCoach = sc.nextLine();

                        if(selectedCoach.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(selectedCoach)){
                            do{
                                System.out.print("\nPlease enter valid Coach Num : ");
                                selectedCoach = sc.nextLine();
                            }while(selectedCoach.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(selectedCoach));
                        }
                        
                        boolean isValidated = ValidateClass.isValidatedCoach(Integer.parseInt(selectedCoach));

                        if(!isValidated || !HJJSBookingInterface.isNumeric(selectedCoach)){
                            do{
                                System.out.print("\nPlease Enter Valid Coach Num : ");
                                selectedCoach = sc.nextLine();
                                 isValidated = ValidateClass.isValidatedCoach(Integer.parseInt(selectedCoach));
                            }while(!isValidated || !HJJSBookingInterface.isNumeric(selectedCoach));
                        }
                            
                        displaySchedule(0,"",Integer.parseInt(selectedCoach));
                }
                case 4 -> {                        
                    displaySchedule(0,"",0);
                }
                case 5 -> { 
                            updateClass = 0;
                            bookClass = 0;
                            ScheduledBookings.tempBookingCodeToChange = 0;
                            return;
                         }
                default -> System.out.println("\nPlease enter a valid choice (1-4)");
            }
        } while (choice != 5);
        
    }
    
    
    //Display Schedule
    public static void displaySchedule(int gradeLevel, String day, int coachNum){
                                   
        System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-30s | %-15s | %-15s | %-12s |  %-12s | %-15s | %-10s | %-20s | %-10s |\n",
                "ScheduleNo","Lesson", "ScheduledDay", "GradeLevel","StartTime","EndTime", "ScheduledOn", "Duration", "ClassTakenBy", "Seats");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                              
        List<LessonSchedules> lessonSchedules = LessonSchedules.getsData();
        List<Coaches> cdata =Coaches.getcData();
        
      
        Set<String> uniqueData = new HashSet<>(); 
        for(LessonSchedules obj : lessonSchedules){
            if (!uniqueData.contains(String.valueOf(obj.getScheduleNo()))){
                
                String coachname = "";
                for(Coaches coachobj : cdata){
                    if(obj.getCoachNo() == coachobj.getCoachNo()){
                        coachname = coachobj.getFirstName()+" "+coachobj.getLastName();
                        break;
                    }
                }
        
                uniqueData.add(String.valueOf(obj.getScheduleNo()));
                if(!day.equalsIgnoreCase("") && obj.getScheduleWeekDay().equalsIgnoreCase(day)){
                     System.out.printf("| %-15s | %-30s | %-15s | %-15s | %-12s |  %-12s | %-15s | %-10s | %-20s | %-10s |\n", 
                    obj.getScheduleNo(),obj.getScheduledLessonName(), obj.getScheduleWeekDay(),"Grade - "+obj.getScheduledLesssonGrade(), obj.getStartTime(), obj.getEndTime(),obj.getScheduledDate(), 
                    obj.getDuration(), coachname, obj.getNumOfSeats());
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                }
                if(gradeLevel != 0 && obj.getScheduledLesssonGrade() == gradeLevel){
                    System.out.printf("| %-15s | %-30s | %-15s | %-15s | %-12s |  %-12s | %-15s | %-10s | %-20s | %-10s |\n",
                    obj.getScheduleNo(),obj.getScheduledLessonName(), obj.getScheduleWeekDay(),"Grade - "+obj.getScheduledLesssonGrade(), obj.getStartTime(), obj.getEndTime(),obj.getScheduledDate(), 
                    obj.getDuration(), coachname, obj.getNumOfSeats());
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                }
                if(coachNum != 0 && obj.getCoachNo() == coachNum){
                    System.out.printf("| %-15s | %-30s | %-15s | %-15s | %-12s |  %-12s | %-15s | %-10s | %-20s | %-10s |\n",
                    obj.getScheduleNo(),obj.getScheduledLessonName(), obj.getScheduleWeekDay(),"Grade - "+obj.getScheduledLesssonGrade(),obj.getStartTime(),obj.getEndTime(), obj.getScheduledDate(), 
                    obj.getDuration(), coachname, obj.getNumOfSeats());
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                }
                if(coachNum == 0 && day.equalsIgnoreCase("") && gradeLevel == 0){
                     System.out.printf("| %-15s | %-30s | %-15s | %-15s | %-12s |  %-12s | %-15s | %-10s | %-20s | %-10s |\n",
                    obj.getScheduleNo(),obj.getScheduledLessonName(), obj.getScheduleWeekDay(),"Grade - "+obj.getScheduledLesssonGrade(), obj.getStartTime(), obj.getEndTime(),obj.getScheduledDate(), 
                    obj.getDuration(), coachname, obj.getNumOfSeats());
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                }
            }
        }
        
      
        //if update class
        if(applyFilter == 1){
            if(updateClass == 1){
               ScheduledBookings.updateClassInfo();  
            // If book class
            }else{
                 ScheduledBookings.bookClassInfo();
            }
        }
    }
    
    
    
    //Filter Options
    private static int filterOptions(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nSelect any choice form below menu => ");
        System.out.println("1. According to Day ");             
        System.out.println("2. According to Grade Level");        
        System.out.println("3. According to Coach");
        System.out.println("4. All Lessons");
        System.out.println("5. Back To Main Menu");
        
        String choice  = "";
        
        /* Validation for Menu Options */
        while (true) {
            System.out.print("\nEnter Correct Choice ==> ");
            choice = sc.nextLine();
            if (choice.isEmpty()) {
                System.out.println("\nPlease Select Choice. ");
            } else if (!HJJSBookingInterface.isNumeric(choice)) {
                System.out.println("\nMust be a numeric value. ");
            } else {
                break;
            }
        }
        return Integer.parseInt(choice);
    }
    
    
}
