/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import sun.net.www.content.audio.x_aiff;

/**
 *
 * @author ibrahim mushtaha
 */
public class JavaApplication15 {

    public static Scanner s = new Scanner(System.in);
    public static boolean AdmRun1 = true;

    public static void main(String[] args) throws IOException {

        while (AdmRun1) {
            System.out.println("1-add holiday.");
            System.out.println("2-delete holiday.");
            System.out.println("3-Report About Manager Holiday");
            System.out.println("4-Veiw all holiday");
            System.out.println("5-Accept the holiday");
            System.out.println("Enter number : ");
            int x = s.nextInt();
            switch (x) {
                case 1:
                    File file1 = new File("C:\\Users\\ibrahim mushtaha\\Desktop\\programing\\JavaApplication15\\src\\New folder");
                    System.out.println("Enter id : ");
                    String adm_Id = s.next();
                    System.out.println("Enter name : ");
                    String adm_Name = s.next();
                    System.out.println("Enter reason : ");
                    String adm_reason = s.next();
                    System.out.println("Enter Details : ");
                    String adm_Details = s.next();
                    System.out.println("Enter date : ");
                    String adm_Date = s.next();
                    holidayReject(adm_Name, adm_Id, adm_reason, adm_Details, adm_Date);
                    break;

                case 2:
                    DeleteManager();
                    break;

                case 3:
                    ReportAboutAllManagers();
                    break;
                case 4:
                    ViewAllHoliady();
                    break;
            }

        }
    }

    public static void holidayReject(String adm_Name, String adm_Id, String adm_reason, String adm_Details, String adm_Date) throws IOException {

        File file1 = new File("C:\\Users\\ibrahim mushtaha\\Desktop\\programing\\JavaApplication15\\src\\New folder\\" + adm_Id + ".txt");
        FileWriter fr = new FileWriter(file1);
        PrintWriter pr = new PrintWriter(fr);

        pr.println(adm_Details);
        pr.println(adm_Name);
        pr.println(adm_Id);
        pr.println(adm_reason);
        pr.println(adm_Date);
        fr.close();
        pr.close();
    }

    public static hol getObjectFromManager(File f) {
        hol ho = null;
        try {
            Scanner t = new Scanner(f);
            ho = new hol();
            ho.setName(t.nextLine());
            ho.setDate(t.nextLine());
            ho.setId(t.nextLine());
            ho.setReason(t.nextLine());
            ho.setDetails(t.nextLine());
        } catch (FileNotFoundException ex) {
            System.out.println("the Manager ID is not found");

        }
        return ho;
    }

    public static void DeleteManager() {
        System.out.println("  >>>>> Delete Manager <<<<<");
        System.out.println("Enter your ID : ");
        String name = s.next();
        File file1 = new File("C:\\Users\\ibrahim mushtaha\\Desktop\\programing\\JavaApplication15\\src\\New folder\\" + name + ".txt");
        if (file1.exists()) {
            file1.delete();
            System.out.println("File is deleted successfulys");
        } else {
            System.out.println("the Manager ID is not found");
        }

    }

    public static void ListFileForFolder(final File f) {
        for (File file1 : f.listFiles()) {
            hol man = getObjectFromManager(file1);
            System.out.println(man);
        }
    }

    public static void ReportAboutAllManagers() {
        File file1 = new File("C:\\Users\\ibrahim mushtaha\\Desktop\\programing\\JavaApplication15\\src\\New folder");
        ListFileForFolder(file1);
        System.out.println("Done");
    }

    public static void ViewAllHoliady() {
        File file1 = new File("C:\\Users\\ibrahim mushtaha\\Desktop\\programing\\JavaApplication15\\src\\New folder");
        ListFileForFolder(file1);
        System.out.println("Done");
    }
  
}
