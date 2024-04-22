
package hjjsbookingsystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class Learners {
    
    private int lRollNo;
    private int lCurrentGradeLevel;
    private String lFullname;
    private String lContactNo;
    private String lSecretCode;
    private String lGender;
    private int lAge;

    public static ArrayList <Learners> lData = new ArrayList<>();
        
    public Learners(int lRollNo, int lCurrentGradeLevel, String lFullname, String lContactNo, String lSecretCode, String lGender, int lAge) {
        this.lRollNo = lRollNo;
        this.lCurrentGradeLevel = lCurrentGradeLevel;
        this.lFullname = lFullname;
        this.lContactNo = lContactNo;
        this.lSecretCode = lSecretCode;
        this.lGender = lGender;
        this.lAge = lAge;
    }

    public int getlRollNo() {
        return lRollNo;
    }

    public int getlCurrentGradeLevel() {
        return lCurrentGradeLevel;
    }

    public String getlFullname() {
        return lFullname;
    }

    public String getlContactNo() {
        return lContactNo;
    }

    public String getlSecretCode() {
        return lSecretCode;
    }

    public String getlGender() {
        return lGender;
    }

    public int getlAge() {
        return lAge;
    }

    public static ArrayList<Learners> getlData() {
        saveData();
        return lData;
    }

    //Save Data
    private static void saveData(){
        Learners o1 = new Learners(701,2,"Sally Bell","07582 888425","012345","Male",5);
        Learners o2 = new Learners(702,1,"Harry Kelly","01902 714229","012345","Male",6);
        Learners o3 = new Learners(703,3,"Alexander","01600 775641","012345","Male",7);
        Learners o4 = new Learners(704,4,"Harris","01386 701520","012345","Male",9);
        Learners o5 = new Learners(705,5,"Rob Bell","01202 692542","012345","Male",10);
        
        Learners o6 = new Learners(706,2,"Ken Russell","015394 32143","012345","Male",5);
        Learners o7 = new Learners(707,4,"Julie Taylor","01434 688888","012345","Male",4);
        Learners o8 = new Learners(708,1,"Ava Mitchell","01392 462900","012345","Male",11);
        Learners o9 = new Learners(709,3,"Sophia Carter","01748 821258","012345","Male",7);
        Learners o10 = new Learners(710,4,"Butler","01423 877010","012345","Male",6);
        
        Learners o11 = new Learners(711,1,"Evans","01977 520390","012345","Male",8);
        Learners o12 = new Learners(712,3,"Alexa Watson","01935 892381","012345","Male",8);
        Learners o13 = new Learners(713,5,"Evie Richards","0151 709 7858","012345","Male",9);
        Learners o14 = new Learners(714,2,"Nick Hill","01934 852771","012345","Male",10);
        Learners o15 = new Learners(715,2,"Leo Williams","01322 447840","012345","Male",4);
        
        Learners.lData.add(o1);
        Learners.lData.add(o2);
        Learners.lData.add(o3);
        Learners.lData.add(o4);
        Learners.lData.add(o5);
        Learners.lData.add(o6);
        Learners.lData.add(o7);
        Learners.lData.add(o8);
        Learners.lData.add(o9);
        Learners.lData.add(o10);
        Learners.lData.add(o11);
        Learners.lData.add(o12);
        Learners.lData.add(o13);
        Learners.lData.add(o14);
        Learners.lData.add(o15);
    }
    
    public void setlCurrentGradeLevel(int lCurrentGradeLevel) {
        this.lCurrentGradeLevel = lCurrentGradeLevel;
    }
    
    //New Learner
    public static void newLearner(){
        Scanner sc = new Scanner(System.in);
        
        //Full Name
        System.out.print("\nPlease Enter Full Name : ");
        String firstName = sc.nextLine();
        
        if(firstName.equalsIgnoreCase("")){
            do{
                System.out.print("\nPlease Enter Full Name : ");
                firstName = sc.nextLine();
            }while(firstName.equalsIgnoreCase(""));
        }
   
        //Secret Code
        System.out.print("\nPlease Enter Secret Code while booking new class or updating booking : ");
        String secretCode = sc.nextLine();
        
        if(secretCode.equalsIgnoreCase("")){
            do{
                System.out.print("\nPlease Enter Secret Code : ");
                secretCode = sc.nextLine();
            }while(secretCode.equalsIgnoreCase(""));
        }
        
        //Grade Level
        System.out.print("\nPlease Enter Grade Level (1 - 5) : ");
        String grade = sc.nextLine();
         
        if(grade.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(grade)
                || (Integer.parseInt(grade) < 1 || Integer.parseInt(grade) > 5)){
            do{
                System.out.print("\nPlease Enter Valid Grade Level : ");
                grade = sc.nextLine();
            }while(grade.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(grade) 
                    || (Integer.parseInt(grade) < 1 || Integer.parseInt(grade) > 5));
        }
        
        //Contact
        System.out.print("\nPlease Enter Contact : ");
        String contact = sc.nextLine();
        
        if(contact.equalsIgnoreCase("")){
            do{
                System.out.print("\nPlease Enter Contact : ");
                contact = sc.nextLine();
            }while(contact.equalsIgnoreCase(""));
        }
        
        //Gender
        System.out.print("\nPlease Enter Gender : ");
        String gender = sc.nextLine();
        
        if(gender.equalsIgnoreCase("") || !(gender.equalsIgnoreCase("M") ||
                gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("Male") 
                || gender.equalsIgnoreCase("Female") )){
            do{
                System.out.print("\nPlease Enter Valid Gender : ");
                gender = sc.nextLine();
            }while(gender.equalsIgnoreCase("") || !(gender.equalsIgnoreCase("M") ||
                    gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("Male") 
                || gender.equalsIgnoreCase("Female")));
        }
           
        //Age
        System.out.print("\nPlease Enter Age : ");
        String age = sc.nextLine();
         
        if(age.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(age) || 
                Integer.parseInt(age) < 4 || Integer.parseInt(age) > 11){
            do{
                System.out.print("\nPlease Enter Valid Age : ");
                age = sc.nextLine();
            }while(age.equalsIgnoreCase("") || !HJJSBookingInterface.isNumeric(age) 
                    || Integer.parseInt(age) < 4 || Integer.parseInt(age) > 11);
        }

        //RollNumber
        Random random = new Random();
        int rollnumber = random.nextInt(900) + 100; 
        
        //Add New Learner
        Learners obj = new Learners(rollnumber,Integer.parseInt(grade),firstName,contact,secretCode,gender,
                Integer.parseInt(age));
        Learners.lData.add(obj);
        System.out.println("\nRegistered with Roll Number : "+rollnumber);
    }
    
    
    
    //Display Learners List
    public static void displayLearners(){
         List<Learners> ldata = Learners.getlData();
        
        System.out.println("\n\n--------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-12s | %-12s  |\n",
                "Rollno","Current Grade","Full Name", "Contact", "Gender", "Age");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        Set<String> uniqueData = new HashSet<>(); 
        for(Learners obj : ldata){
           if (!uniqueData.contains(String.valueOf(obj.getlRollNo()))){

                uniqueData.add(String.valueOf(obj.getlRollNo()));

                System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-12s | %-12s  |\n",
                obj.getlRollNo(),obj.getlCurrentGradeLevel(),obj.getlFullname(), obj.getlContactNo(), obj.getlGender(), obj.getlAge());
                System.out.println("--------------------------------------------------------------------------------------------------------");
           }
       }
    }
}
