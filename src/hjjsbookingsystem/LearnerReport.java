
package hjjsbookingsystem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class LearnerReport implements ReportCommand {
    
    @Override
    public void execute() {
       
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nEnter Month No. : ");
        String givenMon = sc.nextLine();
        String lessonMonth = "4";
        
        if(!HJJSBookingInterface.isNumeric(givenMon) || (Integer.parseInt(givenMon) < 1 || Integer.parseInt(givenMon) > 12)){
            System.out.println("\nMonth Num should be valid numeric between 1 to 12");
            return;
        }
         
        List<ScheduledBookings> bData = ScheduledBookings.getbData();
        List<Learners> ldata = Learners.getlData();
        List<LessonSchedules> lsdata = LessonSchedules.getsData();
        List<Coaches> cdata = Coaches.getcData();
        
        System.out.println();

        HashMap<Integer, int[]> learnerClasses = new HashMap<>();
        
        Set<Integer> rollNo = new HashSet<>(); 
        if(givenMon.equalsIgnoreCase(lessonMonth)){
            
            for (int j = 0; j < bData.size(); j++) {
                for (int i = 0; i < ldata.size(); i++) {

                    int uniqueKey = ldata.get(i).getlRollNo() + bData.get(j).getBookingCode();

                    if (!rollNo.contains(uniqueKey)) {
                        rollNo.add(uniqueKey);

                        if (ldata.get(i).getlRollNo() == bData.get(j).getlRollNo()) {

                            int uniqueCode = ldata.get(i).getlRollNo();
                            int[] totalLessons = learnerClasses.getOrDefault(uniqueCode, new int[3]);

                            if (bData.get(j).getStatus().equalsIgnoreCase(ScheduledBookings.BOOKED) 
                                    || bData.get(j).getStatus().equalsIgnoreCase(ScheduledBookings.CHANGE)) {
                                totalLessons[0]++;
                            }
                            if (bData.get(j).getStatus().equalsIgnoreCase(ScheduledBookings.ATTEND)) {
                                totalLessons[1]++;
                            }
                            if (bData.get(j).getStatus().equalsIgnoreCase(ScheduledBookings.CANCEL)) {
                                totalLessons[2]++;
                            }
                            learnerClasses.put(uniqueCode, totalLessons);
                        }
                    }
                }
            }
        }

        
        if(!learnerClasses.isEmpty()){
            for (Map.Entry<Integer, int[]> entry : learnerClasses.entrySet()) {
                int learnerUniqueCode = entry.getKey();
                int[] totalLessons = entry.getValue();

                //Learenr details
                String learnerFullname = "";
                int currentGrade = 0;
                for (int i = 0; i < ldata.size(); i++) {
                   if(ldata.get(i).getlRollNo() == learnerUniqueCode){
                       learnerFullname = ldata.get(i).getlFullname();
                       currentGrade = ldata.get(i).getlCurrentGradeLevel();
                       break;
                   }
                }

                System.out.println("\nLearner Name : "+learnerFullname);
                System.out.println("Current Grade Level : "+currentGrade);
                System.out.println("Booked Classes : "+totalLessons[0]);
                System.out.println("Cancelled Classes : "+totalLessons[2]);
                System.out.println("Attended Classes : "+totalLessons[1]);
                
                System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-13s | %-20s | %-25s | %-12s | %-30s | %-15s | %-20s |\n",
                        "Booking Code", "Booking Status", "Booking Date",  "Schedule No", "Lesson Name", "Class Grade","Class By");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");

                for (int j = 0; j < bData.size(); j++) {
                    
                    if(bData.get(j).getlRollNo() == learnerUniqueCode){

                        //Lesson Grade Level
                        int lessonGrade = 0;
                        int coachNo = 0;
                        String className = "";
                        String fullName = "";
                        for (LessonSchedules lObj : lsdata) {
                            if(lObj.getScheduleNo() == bData.get(j).getScheduleNo()){
                                lessonGrade = lObj.getScheduledLesssonGrade();
                                className = lObj.getScheduledLessonName();
                                coachNo = lObj.getCoachNo();
                                break;
                            }
                        }
                        for (Coaches cObj : cdata) {
                            if(cObj.getCoachNo() == coachNo){
                                fullName = cObj.getFirstName() +" "+ cObj.getLastName();
                                break;
                            }
                        }
                        System.out.printf("| %-13s | %-20s | %-25s | %-12s | %-30s | %-15s | %-20s |\n",
                                bData.get(j).getBookingCode(), bData.get(j).getStatus(), 
                                bData.get(j).getBookingOn(), bData.get(j).getScheduleNo(),
                                className, lessonGrade, fullName);
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    }

                }
              
                System.out.println();
            }
        }else{
             System.out.println("No Data Found");
        }
    }
}
