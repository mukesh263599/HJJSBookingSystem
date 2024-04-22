
package hjjsbookingsystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Coaches {
    
    private int coachNo;
    private String firstName;
    private String lastName;
    private String contact;
    private String gender;
    private String instructedGradeLevel;
    private int age;

    
    public static ArrayList <Coaches> cData = new ArrayList<>();

    public Coaches(int coachNo, String firstName, String lastName, String contact, String gender, String instructedGradeLevel, int age) {
        this.coachNo = coachNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.gender = gender;
        this.instructedGradeLevel = instructedGradeLevel;
        this.age = age;
    }

    public int getCoachNo() {
        return coachNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContact() {
        return contact;
    }

    public String getGender() {
        return gender;
    }

    public String getInstructedGradeLevel() {
        return instructedGradeLevel;
    }

    public int getAge() {
        return age;
    }

    public static ArrayList<Coaches> getcData() {
        saveData();
        return cData;
    }
    
    //Save Data
    private static void saveData(){
        Coaches o1 = new Coaches(801,"Jodie","Richards","01872 223330","Male","All",39);
        Coaches o2 = new Coaches(802,"Fred","Allen","01536 411176","Male","All",34);
        Coaches o3 = new Coaches(803,"Freya","Martin","01473 251397","Female","All",33);
        Coaches o4 = new Coaches(804,"Emily","Jackson","028 7776 6456","Female","All",32);
        Coaches o5 = new Coaches(805,"Wayne","Adams","01603 426408","Male","All",31);
        
        Coaches.cData.add(o1);
        Coaches.cData.add(o2);
        Coaches.cData.add(o3);
        Coaches.cData.add(o4);
        Coaches.cData.add(o5);
    }
    
    //Display Coach List
    public static void displayCoach(){
         List<Coaches> cdata = Coaches.getcData();
        
        System.out.println("\n\n--------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-12s | %-12s  |\n",
                "CoachNum","First name", "Last Name","Contact", "Gender", "Age");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        Set<String> uniqueData = new HashSet<>(); 
        for(Coaches obj : cdata){
           if (!uniqueData.contains(String.valueOf(obj.getCoachNo()))){

                uniqueData.add(String.valueOf(obj.getCoachNo()));

                System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-12s | %-12s  |\n",
                        obj.getCoachNo(),obj.getFirstName(), obj.getLastName(),obj.getContact(), obj.getGender(), obj.getAge());
                System.out.println("--------------------------------------------------------------------------------------------------------");
           }
       }
    }
}
