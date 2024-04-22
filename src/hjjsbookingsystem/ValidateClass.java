
package hjjsbookingsystem;

import static hjjsbookingsystem.ScheduledBookings.ATTEND;
import static hjjsbookingsystem.ScheduledBookings.CANCEL;
import java.util.List;


public class ValidateClass {
    
    //is Validated coach
    public static boolean isValidatedCoach(int coachNo){
            
        boolean isValidated = false;
        List<Coaches> cdata = Coaches.getcData();
        
        for(Coaches obj : cdata){
            if(obj.getCoachNo() == coachNo){
                isValidated = true;
                break;
            }
        }
        return isValidated;
    }
    
    
    //is Validated Learner
    public static boolean isValidatedLearner(int rollNo){
            
        boolean isValidated = false;
        List<Learners> ldata = Learners.getlData();
        
        for(Learners obj : ldata){
            if(obj.getlRollNo() == rollNo){
                isValidated = true;
                break;
            }
        }
        return isValidated;
    }
    
    
    //is Validated Learner Secret Code
    public static boolean isValidatedLearnerCode(int rollNo, String secretCode){
            
        boolean isValidated = false;
        List<Learners> ldata = Learners.getlData();
        
        for(Learners obj : ldata){
            if(obj.getlRollNo() == rollNo && obj.getlSecretCode().equalsIgnoreCase(secretCode)){
                isValidated = true;
                break;
            }
        }
        return isValidated;
    }
    
    
    //is Validated staff Secret Code
    public static boolean isValidatedStaffCode(String secretCode){
            
        boolean isValidated = false;
        List<Staffs> sdata = Staffs.getsData();
        
        for(Staffs obj : sdata){
            if(obj.getlSecretCode().equalsIgnoreCase(secretCode)){
                isValidated = true;
                break;
            }
        }
        return isValidated;
    }
    
    
    //is Validated Schedule
    public static boolean isValidatedSchedule(int scheduleNo){
            
        boolean isValidated = false;
        List<LessonSchedules> ldata = LessonSchedules.getsData();
        
        for(LessonSchedules obj : ldata){
            if(obj.getScheduleNo() == scheduleNo){
                isValidated = true;
                break;
            }
        }
        return isValidated;
    }


    //Update number of seats 
    public static void updateNumOfSeats(int scheduleNo, int add, int subtract){
         List<LessonSchedules> ldata = LessonSchedules.getsData();
         for(LessonSchedules obj : ldata){
            if(obj.getScheduleNo() == scheduleNo){
                int seats = obj.getNumOfSeats();
                if(add != 0){
                    obj.setNumOfSeats(seats+1);
                }
                if(subtract != 0){
                    obj.setNumOfSeats(seats-1);
                }
                break;
            }
        }
    }
    
    
    
    //Seats Available or not
    public static int seatsAvailableOrNot(int scheduleNo){      
        int noOfseats = 0;
       List<LessonSchedules> ldata = LessonSchedules.getsData();
         for(LessonSchedules obj : ldata){
            if(obj.getScheduleNo() == scheduleNo){
                int seats = obj.getNumOfSeats();
                noOfseats = seats;
                break;
            }
        }
         return noOfseats;
    }
    
    
    
    
    
    //Is Booking Class Twice
    public static boolean isTwiceBookingClass(int scheduleNo, int learnerRollNo){      
        boolean isTwice = false;
        List<ScheduledBookings> bData = ScheduledBookings.getbData();
        for(ScheduledBookings obj : bData){
            if(obj.getlRollNo() == learnerRollNo&& obj.getScheduleNo()== scheduleNo){
                isTwice = true;
                break;
            }
        }
        return isTwice;
    }
    
    
     
    
    
    //Is Cancelled Or Attended
    public static boolean isCancelledOrAttended(int bookingCode){      
        boolean isAttendedOrCancelled = false;
        List<ScheduledBookings> bData = ScheduledBookings.getbData();
        for(ScheduledBookings obj : bData){
            if(obj.getBookingCode() == bookingCode){
                if(obj.getStatus().equalsIgnoreCase(ATTEND) || obj.getStatus().equalsIgnoreCase(CANCEL)){
                    isAttendedOrCancelled = true;
                    break;
                 }
            }
        }
        return isAttendedOrCancelled;
    }
    
    
     
    
    
    //Is Learner Roll No from Bookings
    public static int getLearnerRollNo(int bookingCode){      
        int rollNo = 0;
        List<ScheduledBookings> bData = ScheduledBookings.getbData();
        for(ScheduledBookings obj : bData){
            if(obj.getBookingCode()== bookingCode){
                rollNo = obj.getlRollNo();
                break;
            }
        }
        return rollNo;
    }
    
    
    
    //Is Staff or Learner
    public static int isStaffOrLearner(int bookingCode){      
        int rollNo = 0;
        List<ScheduledBookings> bData = ScheduledBookings.getbData();
        for(ScheduledBookings obj : bData){
            if(obj.getBookingCode()== bookingCode){
                rollNo = obj.getlRollNo();
                break;
            }
        }
        return rollNo;
    }
    
    
     
    // Higher / Lower Grade Level Class
    public static boolean matchCurrentGradeWithClassGrade(int scheduleNo, int rollNo){
        boolean isHigher = false;
       
        //Get Learner Grade
        List<Learners> ldata = Learners.getlData();
        int currentGrade = 0;
        for(Learners obj : ldata){
            if(obj.getlRollNo() == rollNo){
                currentGrade = obj.getlCurrentGradeLevel();
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
        
        int allowed = currentGrade +1;
        if(scheduleGrade < currentGrade || scheduleGrade > allowed){
            isHigher = true;
        }
        
        return isHigher;
    }
    
          
    //Get current grade of learner
    public static int getLearnerCurrentGrade(int rollNo){
        int currentGrade = 0;

        //Get Learner Grade
        List<Learners> ldata = Learners.getlData();
        for(Learners obj : ldata){
            if(obj.getlRollNo() == rollNo){
                currentGrade = obj.getlCurrentGradeLevel();
                break;
            }
        }

        return currentGrade;
    }
    
    
      
    //Is Booking Code Found
    public static boolean getBookingCode(int bookingCode){
        boolean found = false;
        
        List<ScheduledBookings> bData = ScheduledBookings.getbData();
        for(ScheduledBookings obj : bData){
            if(obj.getBookingCode() == bookingCode){
                found = true;
                break;
            }
        }
        
        return found;
    }
    
   
    //Update Learner current grade
    public static void updateGrade(int rollNo){
        List<Learners> lrdata = Learners.getlData();
        for(Learners obj : lrdata){
            if(obj.getlRollNo() == rollNo){
                int grade = obj.getlCurrentGradeLevel();
                obj.setlCurrentGradeLevel(grade+1);
                break;
            }
        }
    }

}


