
package hjjsbookingsystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class Staffs {
    
    private int staffCode;
    private String lFullname;
    private String lSecretCode;

    public static ArrayList <Staffs> sData = new ArrayList<>();

    public Staffs(int staffCode, String lFullname, String lSecretCode) {
        this.staffCode = staffCode;
        this.lFullname = lFullname;
        this.lSecretCode = lSecretCode;
    }

    public int getStaffCode() {
        return staffCode;
    }

    public String getlFullname() {
        return lFullname;
    }

    public String getlSecretCode() {
        return lSecretCode;
    }

    public static ArrayList<Staffs> getsData() {
        saveData();
        return sData;
    }

    //Save Data
    private static void saveData(){
        Staffs o1 = new Staffs(501,"Archie Stewart","staffPass");
        Staffs.sData.add(o1);
    }

}
