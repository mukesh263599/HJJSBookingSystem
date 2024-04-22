
package hjjsbookingsystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class CoachReport implements ReportCommand{
    
    @Override
    public void execute(){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Month No. : ");
        String givenMon = sc.nextLine();
        
         if(!HJJSBookingInterface.isNumeric(givenMon) || (Integer.parseInt(givenMon) < 1 || Integer.parseInt(givenMon) > 12)){
            System.out.println("\nMonth Num should be valid numeric between 1 to 12");
            return;
        }
        
        List<GivenRatings> rdata = GivenRatings.getrData();
        List<LessonSchedules> lsdata = LessonSchedules.getsData();
        List<Coaches> cdata = Coaches.getcData();
        
        HashMap<Integer, Integer> rData = new HashMap<>();
        HashMap<Integer, Integer> rec = new HashMap<>();
        HashMap<Integer, Double> rResult = new HashMap<>();
       
        System.out.println();
       
        for (GivenRatings obj : rdata){
            for (LessonSchedules lobj : lsdata){
                
                 //Parse date
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
                
                String monthNumber = "";
                try {
                    LocalDateTime parsedDateTime = LocalDate.parse(lobj.getScheduledDate(), formatter).atStartOfDay();
                    monthNumber = parsedDateTime.format(DateTimeFormatter.ofPattern("M"));

                } catch (DateTimeParseException e) {
                    System.out.println("Error parsing datetime: " + e.getMessage());
                }
                    
                 
                if(lobj.getCoachNo() == obj.getCochaUniqueNo() && monthNumber.equalsIgnoreCase(givenMon)){
                    int givenRating = obj.getStarsRating();

                    rData.put(lobj.getCoachNo(), rData.getOrDefault(lobj.getCoachNo(), 0) + givenRating);
                    rec.put(lobj.getCoachNo(), rec.getOrDefault(lobj.getCoachNo(), 0) + 1);
                }
            }
        }

        for (Integer coachNo : rData.keySet()) {
            int ratings = rData.get(coachNo);
            int rows = rec.get(coachNo);

            if (rows > 0) {
                double avgResult = (double) ratings / rows;
                double decimalPoints = Math.round(avgResult * 10.0) / 10.0; 
                rResult.put(coachNo, decimalPoints);
            }
        }
        if(!rResult.isEmpty()){
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-12s | %-12s | %-15s | %-10s | %-10s | %-18s |\n", "CoachNo","FirstName","LastName",
                    "Contact","Gender","Age", "AverageRating");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            for (Integer coachNo : rResult.keySet()) {
                double averageRating = rResult.get(coachNo);
                
                String contact = "";
                String gender = "";
                String firstName = "";
                String lastName = "";
                int age = 0;
                
                for (Coaches cObj : cdata) {
                    if(coachNo == cObj.getCoachNo()){
                        firstName = cObj.getFirstName();
                        lastName = cObj.getLastName();
                        contact = cObj.getContact();
                        gender = cObj.getGender();
                        age = cObj.getAge();
                        break;
                    }
                }
                System.out.printf("| %-10s | %-12s | %-12s | %-15s | %-10s | %-10s | %-18s |\n", coachNo,firstName,lastName,
                    contact,gender,age, averageRating);
            }
            System.out.println("-------------------------------------------------------------------------------------------------------------");

        }else{
            System.out.println("No Data Found");
        }
    }
    
}
