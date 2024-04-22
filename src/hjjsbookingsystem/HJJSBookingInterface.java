
package hjjsbookingsystem;

import java.util.Scanner;


public class HJJSBookingInterface {

    public static Scanner userChoice = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.println("\nBelow are the scheduled classes of HJJS - ");
        int selectedOption;
        do {
            selectedOption = displayFunctions();
            switch (selectedOption) {
                case 1 -> LessonSchedules.filterSchedule();
                case 2 -> LessonSchedules.filterSchedule();
                case 3 -> {
                            int bookingCode = ScheduledBookings.takeBookingInfo();
                            if(bookingCode != 0){
                                LessonSchedules.updateClass = 1;
                                ScheduledBookings.tempBookingCodeToChange = bookingCode;
                                LessonSchedules.filterSchedule();
                            }
                            
                           //reset variables
                           LessonSchedules.updateClass = 0;
                           ScheduledBookings.tempBookingCodeToChange = 0;
                        }
                case 4 -> {
                            int bookingCode = ScheduledBookings.takeBookingInfo();;

                            if(bookingCode != 0){
                                ScheduledBookings.cancelBooking(bookingCode);
                                System.out.println("\nCancel Class Successful");
                            }
                         }
                case 5 -> {
                            int bookingCode = ScheduledBookings.takeBookingInfo();;

                            if(bookingCode != 0){
                                GivenRatings.giveRating(bookingCode);
                                System.out.println("\nThanks for giving review for a class");
                            }
                        }
                case 6 -> ScheduledBookings.displayBookingsInfo();
                case 7 -> reports();
                case 8 -> Learners.newLearner();
                case 9 ->{
                             System.out.println("\nThankyou for using program! The program exits\n\n");
                             System.exit(0);
                        }
                default -> System.out.println("\nPlease enter a valid choice (1-10)");
            }
        } while (selectedOption != 10);
    }
    
    
    //Functions
    private static int displayFunctions(){
        System.out.println("\nSelect any choice form below menu => ");
        System.out.println("1. Display Timetable");             
        System.out.println("2. Book a lesson");        
        System.out.println("3. Update a booking");
        System.out.println("4. Cancel a booking");
        System.out.println("5. Attend a booking and Give Rating to Coach");
        System.out.println("6. Display Bookings");
        System.out.println("7. Monthly Report ");
        System.out.println("8. New Learner");
        System.out.println("9. Exit");
        
        String choice  = "";
        
        /* Validation for Menu Options */
        while (true) {
            System.out.print("\nEnter Correct Choice ==> ");
            choice = userChoice.nextLine();
            if (choice.isEmpty()) {
                System.out.println("\nPlease Select Choice. ");
            } else if (!isNumeric(choice)) {
                System.out.println("\nMust be a numeric value. ");
            } else {
                break;
            }
        }
        return Integer.parseInt(choice);
    }
    
    
    
                         
    //is option is valid numeric
    public static boolean isNumeric(String choice) {
        for (char c : choice.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    
    //Reports
    private static void reports(){
        System.out.println("\nPress 1 for Learner Report");
        System.out.println("Press 2 for Coach Report");
        
        System.out.print("\nSelect your choice : ");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        
        if (!choice.equalsIgnoreCase("1") && !choice.equalsIgnoreCase("2") && !isNumeric(choice)) {
            System.out.println("You have selected an invalid choice");
            return;
        }
        
        ReportClient client = new ReportClient();
        client.processReport(choice);      
    }
}
