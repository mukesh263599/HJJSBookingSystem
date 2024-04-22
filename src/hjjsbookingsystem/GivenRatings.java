
package hjjsbookingsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GivenRatings {
    
    private int bookingCode;
    private int lRollNo;
    private int cochaUniqueNo;
    private int starsRating;
    private String review;
    private String attendedOn;
    
   public static ArrayList <GivenRatings> rData = new ArrayList<>();

    public GivenRatings(int bookingCode, int lRollNo, int cochaUniqueNo, int starsRating, String review, String attendedOn) {
        this.bookingCode = bookingCode;
        this.lRollNo = lRollNo;
        this.cochaUniqueNo = cochaUniqueNo;
        this.starsRating = starsRating;
        this.review = review;
        this.attendedOn = attendedOn;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public int getlRollNo() {
        return lRollNo;
    }

    public int getCochaUniqueNo() {
        return cochaUniqueNo;
    }

    public int getStarsRating() {
        return starsRating;
    }

    public String getReview() {
        return review;
    }

    public String getAttendedOn() {
        return attendedOn;
    }

    public static ArrayList<GivenRatings> getrData() {
        return rData;
    }

    //Give Rating
    public static void giveRating(int bookingCode){
        
          //Current datetime
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY 'at' h:mm:ss a");
        String formattedDateTime = now.format(formatter);
        
        int rollNo = 0;
        int scheduleNo = 0;
        int coachNum = 0;
        List<ScheduledBookings> bData = ScheduledBookings.getbData();
        List<LessonSchedules> lData = LessonSchedules.getsData();
        List<Learners> lrdata = Learners.getlData();
        
        
        for(ScheduledBookings obj : bData){
            if(obj.getBookingCode() == bookingCode){
                rollNo = obj.getlRollNo();
                scheduleNo = obj.getScheduleNo();
                break;
            }
        }
        for(LessonSchedules lobj : lData){
            if(lobj.getScheduleNo() == scheduleNo){
                coachNum = lobj.getCoachNo();
                break;
            }
        }
        
        //Write Review
        Scanner sc = new Scanner(System.in);

        System.out.print("\nWrite Review : ");
        String review = sc.nextLine();
        
         if(review.equalsIgnoreCase("")){
            do{
                System.out.print("\nPlease Write few lines : ");
                review = sc.nextLine();
            }while(review.equalsIgnoreCase(""));
        }
         
        //Take Rating
        System.out.print("\nEnter Rating between 1 to 5 : ");
        String starrating = sc.nextLine();
        
        if(starrating.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(starrating) || 
                (Integer.parseInt(starrating) < 1 || Integer.parseInt(starrating) > 5)){
            do{
                System.out.print("\nPlease Enter Valid Rating between 1 to 5 : ");
                starrating = sc.nextLine();
            }while(starrating.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(starrating) || 
                (Integer.parseInt(starrating) < 1 || Integer.parseInt(starrating) > 5));
        }
        
        GivenRatings o = new GivenRatings(bookingCode,rollNo,coachNum,Integer.parseInt(starrating),review,formattedDateTime);
        GivenRatings.rData.add(o);
        
         for(ScheduledBookings obj : bData){
            if(obj.getBookingCode() == bookingCode){
                obj.setStatus(ScheduledBookings.ATTEND);
                break;
            }
        }
         
        //Update seats by adding by 1
        ValidateClass.updateNumOfSeats(scheduleNo,1,0);
        
           //Get Learner Grade
        int currentGrade = ValidateClass.getLearnerCurrentGrade(rollNo);
        
        for(Learners obj2 : lrdata){
            if(obj2.getlRollNo() == rollNo){
                currentGrade = obj2.getlCurrentGradeLevel();
                break;
            }
        }
        
        //Get Class Grade
        List<LessonSchedules> sdata = LessonSchedules.getsData();
        int scheduleGrade = 0;
        for(LessonSchedules obj : sdata){
            if(obj.getScheduleNo()== scheduleNo){
                scheduleGrade = obj.getScheduledLesssonGrade();
                break;
            }
        }
        
        boolean isUpdated = false;
        
        if(scheduleGrade > currentGrade){
            isUpdated = true;
        }
        
        if(isUpdated){
            ValidateClass.updateGrade(rollNo);
        }
       
        return;
    }
}
