
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
// Welcome to CruiseShip Array Version
public class CruiseShipPartOne {
    //Getting the details of the already existing passengers
    static Scanner Sc = new Scanner(System.in);
    public static String[] custName = new String[12];
    public static int[] Cabin = new int[12];
    public static int[] availabilityStatus = new int[12];

    public static void main(String[] args) throws IOException {
        String menu;
        boolean validInput;
        System.out.println("Enter the number of existing cabins");
        int end = Sc.nextInt();
        for (int i = 1; i < Cabin.length; i++) {
            do{
                System.out.println("Enter a Cabin Number from 1 to 12");
                if (Sc.hasNextInt()){
                    Cabin[i] = Sc.nextInt();
                    validInput = true;
                } else{
                    System.out.println("Enter valid Cabin Number");
                    validInput = false;
                    Sc.next();
                }
            }while (!validInput);
            System.out.println("Enter the Customer Name for Cabin Number " + Cabin[i] + ":");
            custName[i] = Sc.next();
            availabilityStatus[i] = 1;
            System.out.println("Cabin " + Cabin[i] + " is occupied by " + custName[i]);
            System.out.println("Status of Cabin " + Cabin[i] + " is now: " + availabilityStatus[i]);
            if (i == end) {
                break;
            }

        }
            for (int i = 0; i < 12;i++){
                System.out.println("Menu");
                System.out.println("A: Add New Customer");
                System.out.println("V: View All Cabins");
                System.out.println("E: Display All Empty Cabins");
                System.out.println("D: Delete Customer From Cabin");
                System.out.println("F: Find Cabin From Customer Name");
                System.out.println("S: Store Program Data Into File");
                System.out.println("L: Load Program Data Into File");
                System.out.println("O: View Passengers Ordered Alphabetically By Name ");

                System.out.println("Enter Desired Menu Option: ");
                menu = Sc.next();
                switch (menu) {
                    case "A":
                        menu = "Add New Customer";
                        addCustomer();
                        break;
                    case "V":
                        menu = "View All Cabins";
                        displayDetails();
                        break;
                    case "E":
                        menu = "Display All Empty Cabins";
                        displayEmptyCabin();
                        break;
                    case "D":
                        menu = "Delete Customer From Cabin";
                        deleteCabin();
                        break;
                    case "F":
                        menu = "Find Cabin From Customer Name";
                        findCabin();
                        break;
                    case "S":
                        menu = "Store Program Data Into File";
                        storeContentsInFile();
                        break;
                    case "L":
                        menu = "Load Program Data Into File";
                        loadContentsFromFile();
                        break;
                    case "O":
                        menu = "View Passengers Ordered Alphabetically By Name";
                        Sorting();
                    case "Stop":
                        System.out.println("This is the end of the CruiseShip Array Version");
                        System.exit(0);
                }
                System.out.println("The Selected Menu Option is: " + menu);
            }

    }

    // Adding new customers
    public static String addCustomer() {
        for (int i = 0; i < 3; i++) {
            while (availabilityStatus[i] == 0) {
                    System.out.println("Enter Customer name: ");
                    custName[i] = Sc.next();
                    System.out.println("Customer Name " + custName[i] + " can be assigned to Cabin Number " + Cabin[i]);
                    Cabin[i]++;
                    availabilityStatus[i] = 1;
                    System.out.println("Status of Cabin " + Cabin[i] + " is now: " + availabilityStatus[i]);
                    System.out.println(Arrays.toString(Cabin));
                    System.out.println(Arrays.toString(custName));
                    System.out.println(Arrays.toString(availabilityStatus));
                    break;
            }
        }

        return null;
    }
    // Displaying the details of the passengers
    public static String displayDetails(){
        System.out.println("Cabin Customer Details");
        for (int i = 0; i < 12; i++) {
            System.out.println("Cabin Number: " + Cabin[i]);
            System.out.println("Customer Name: " + custName[i]);
            System.out.println("Cabin availability status: " + availabilityStatus[i]);
            if(Cabin[i] == 0 || custName[i] == null || availabilityStatus[i] == 0){
                System.out.println("The Cabin is empty");
            }
        }
        return null;
    }
    // Displaying all the empty cabins
    public static String displayEmptyCabin() {
        for (int i=0; i < Cabin.length; i++) {
            while (availabilityStatus[i] == 0){
                System.out.println(i);
                System.out.println("Cabin number has not been set");
                System.out.println("Customer has not been assigned to Cabin");
                break;
            }
        }
        return null;
    }
    // Deleting Cabins
    public static String deleteCabin() {
        String[] deleteCabin = new String[custName.length - 1];
        System.out.println("Enter the Customer Name you wish to delete: " );
        String element = Sc.next();

        int indexLess = 0;
        for (int i = 0; i < custName.length; i++){
            if (!custName[i].equals(element)){
                deleteCabin[indexLess] = custName[i];
                indexLess++;
            }
            deleteCabin = custName;
            System.out.println("Elements-------");
            System.out.println(deleteCabin[i]);
            break;
        }
        return null;
    }
    //Finding Cabins using the name of the passenger
    public static String findCabin(){
        System.out.println("Enter name of Passenger");
        String Name = Sc.next();
        for (int i =1; i < 12;i++){
            if (!custName.equals(Name)){
                System.out.println("Passenger name cannot be found");
            } else {
                System.out.println(Name + " Belongs to " + Cabin[i]);
            }
            break;
        }

        return null;
    }
    // Storing program contents into file
    public static String storeContentsInFile() throws IOException {
        try{
            File CruiseShip = new File("CruiseShip.txt");
            PrintStream writer = new PrintStream(CruiseShip);
            for(int i = 0; i < 12; i++){
                writer.println("Cabin No: " +Cabin[i]);
                writer.println("Customer Name: " +custName[i]);
                writer.println("Availability Status: " + availabilityStatus[i]);
            }
            writer.close();
        } catch (IOException e){
            System.out.println("Error IO Exception is: " + e);
        }
        System.out.println("Data has been stored in the file successfully");
        return null;
    }
    // Loading program contents from file
    public static void loadContentsFromFile() throws FileNotFoundException {
        try{
            File Cabin = new File("CruiseShip.txt");
            if (!Desktop.isDesktopSupported()){
                System.out.println("File is not supported.");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (Cabin.exists()){
                desktop.open(Cabin);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    // Sorting names of Passengers
    public static String Sorting(){
        for(int m=0; m < 12; m++){
            if (custName[m] == null){
                System.out.println("Empty Cabin");
        } else{
                System.out.println(custName[m]);
            }
        }
        for (int i = 0; i < custName.length; i++){
            for (int j = i + 1; j < custName.length; j++) {
                while (custName[i] != null){
                    if (custName[j].compareTo(custName[i]) > 0) {
                        String order = custName[j];
                        custName[j] = custName[i];
                        custName[i] = order;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(custName));
        return null;
    }
}
