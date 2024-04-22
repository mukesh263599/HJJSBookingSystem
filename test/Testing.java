
import hjjsbookingsystem.GivenRatings;
import hjjsbookingsystem.LessonSchedules;
import hjjsbookingsystem.ScheduledBookings;
import org.junit.Test;
import static org.junit.Assert.*;


public class Testing {
    
     
     @Test
     public void test1_gradeLevelFilter() {
        int gradeLevel = 3;
        System.out.println("\n\n##Testing to Filter Scheduled Claases By Given Grade Level : "+gradeLevel);
        LessonSchedules.displaySchedule(gradeLevel, "", 0);
     }
     
     
      
     @Test
     public void test2_bookClass() {
        int rollNo = 715;
        int scheduleNo = 138;
        System.out.println("\n\n##Testing to book a class for Learner");
        ScheduledBookings.bookNewClass(rollNo, scheduleNo);
        assertTrue(!ScheduledBookings.bData.isEmpty());
     }
     
     
         
     @Test
     public void test3_alreadyBooked() {
        int rollNo = 715;
        int scheduleNo = 138;
        System.out.println("\n\n##Testing to check whether the class is already booked or not");
        ScheduledBookings.bookNewClass(rollNo, scheduleNo);
     }
     
     
      
         
     @Test
     public void test4_higherLevelClass() {
        int rollNo = 715;
        int scheduleNo = 142;
        System.out.println("\n\n##Testing to check whether the learner is booking class which "
                + "is not of his current grade level and not of one higher grade level");
        ScheduledBookings.bookNewClass(rollNo, scheduleNo);
     }
     
     
      
     @Test
     public void test5_cancelClass() {
        int bookingCode = LessonSchedules.applyFilter;
        System.out.println("\n\n##Testing to cancel a class by Learner");
        ScheduledBookings.cancelBooking(bookingCode);
        System.out.println("\nCancel Class Successful");
     }
     
     
    
     
     
     
}
