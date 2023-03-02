
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

// Welcome to CruiseShip Class Version
public class Cabin {
    public static Passenger[] passengers = new Passenger[12];
    public static queue [] Queue = new queue[5];
    public static Scanner Sc2 = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        //Getting the details of the already existing passengers
        String menu;
        boolean validInput;
        System.out.println("Enter the number of cabins currently occupied: ");
        int cabinsOccupied = Sc2.nextInt();
        for (int i = 1; i < passengers.length; i++) {
            passengers[i] = new Passenger();
            queue Queue = new queue(5);
            int totalPassengers = passengers[i].noOfAdultPassengers + passengers[i].noOfChildPassengers;
            if (totalPassengers < 3){
                System.out.println("Passenger Details for Cabin No: " + (i));
                System.out.println("Enter first Name: ");
                passengers[i].firstName = Sc2.next();
                System.out.println("Enter last Name: ");
                passengers[i].lastName = Sc2.next();
                System.out.println("Enter No.of Adult Passengers: ");
                if (Sc2.hasNextInt()){
                    passengers[i].noOfAdultPassengers = Sc2.nextInt();
                    validInput = true;
                } else{
                    System.out.println("Enter valid Cabin Number");
                    validInput = false;
                    Sc2.next();
                }while (!validInput);
                System.out.println("Enter No.of Child Passengers: ");
                if (Sc2.hasNextInt()){
                    passengers[i].noOfChildPassengers = Sc2.nextInt();
                    validInput = true;
                } else{
                    System.out.println("Enter valid Cabin Number");
                    validInput = false;
                    Sc2.next();
                }while (!validInput);
                passengers[i].Expenses();
                passengers[i].setPassenger();
                passengers[i].addPassenger();
                passengers[i].toString();
                if (cabinsOccupied == i){
                    break;
                }
            } else {
                System.out.println("Re enter the number of passengers");
            }
        }

        for (int i = 0; i < 12; i++) {
            System.out.println("Menu");
            System.out.println("A: Add New Customer");
            System.out.println("V: View All Cabins");
            System.out.println("E: Display All Empty Cabins");
            System.out.println("D: Delete Customer From Cabin");
            System.out.println("F: Find Cabin From Customer Name");
            System.out.println("S: Store Program Data Into File");
            System.out.println("L: Load Program Data Into File");
            System.out.println("O: View Passengers Ordered Alphabetically By Name ");
            System.out.println("T: Print expenses of all passengers");

            System.out.println("Enter Desired Menu Option");
            menu = Sc2.next();
            switch (menu){
                case "A":
                    menu = "Add New Customer";
                    addCustomer();
                    break;
                case "V":
                    menu = "View All Cabins";
                    viewCabins();
                    break;
                case "E":
                    menu = "Display All Empty Cabins";
                    displayEmptyCabins();
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
                    StoreProgramDataIntoFile();
                    break;
                case "L":
                    menu = "Load Program Data Into File";
                    loadProgramDataIntoFile();
                    break;
                case "O":
                    menu = "View Passengers Ordered Alphabetically By Name";
                    Sorting();
                    break;
                case "T":
                    menu= "Print expenses of all the passengers";
                    displayExpenses();
                    break;
                case "Stop":
                    System.out.println("This is the end of the CruiseShip Class Version");
                    System.exit(0);
            }

            System.out.println("The Selected Menu Option is: " + menu);
        }
    }
    // Adding new customers
    public static String addCustomer(){
        for (int i =1; i < passengers.length; i++) {
            System.out.println("Enter required choice");
            int choice = Sc2.nextInt();
            if(choice == 1){
                    System.out.println("Adding new Passenger to Cabin");
                    System.out.println("Enter first Name: ");
                    passengers[i].firstName = Sc2.next();
                    System.out.println("Enter last Name: ");
                    passengers[i].lastName = Sc2.next();
                    System.out.println("Enter No.of Adult Passengers: ");
                    passengers[i].noOfAdultPassengers = Sc2.nextInt();
                    System.out.println("Enter No.of Child Passengers: ");
                    passengers[i].noOfChildPassengers = Sc2.nextInt();
                    passengers[i].Expenses();
                    passengers[i].setPassenger();
                    passengers[i].addPassenger();
            }
            else if (choice == 2) {
                System.out.println("Customer is added to the Waiting List");
                System.out.println("Enter first Name: ");
                passengers[i].firstName = Sc2.next();
                System.out.println("Enter last Name: ");
                passengers[i].lastName = Sc2.next();
                System.out.println("Enter No.of Adult Passengers: ");
                passengers[i].noOfAdultPassengers = Sc2.nextInt();
                System.out.println("Enter No.of Child Passengers: ");
                passengers[i].noOfChildPassengers = Sc2.nextInt();
                queue Queue = new queue(5);
                Queue.Enqueue(passengers[i].firstName, passengers[i].lastName, passengers[i].noOfAdultPassengers, passengers[i].noOfChildPassengers);
                Queue.display();
                System.out.println(Arrays.toString(Queue.waitingList));
            }
            break;
        }
            return null;
    }
    // Displaying the details of the passengers
    public static void viewCabins() {
        for (int i = 0; i < 12; i++) {
            if (passengers[i] == null){
                System.out.println("Cabin is empty");
            }else{
                System.out.println(passengers[i]);
            }
        }
    }
    // Displaying all the empty cabins
    public static String displayEmptyCabins(){
        for (Passenger passengers:passengers) {
            if (passengers== null){
                System.out.println("Cabin is empty");
            }
        }
        return null;
    }
    // Deleting Cabins
    public static Passenger deleteCabin(){
        String[] delete = new String[11];
        System.out.println("Enter the customer name you wish to delete: ");
        String Delete = Sc2.next();
        for (int i =1; i< passengers.length; i++){
            while (passengers[i] != null){
                if (passengers[i].lastName.equals(Delete)){
                    for (int index = 0; index < i; index++){
                        delete[index] = String.valueOf(passengers[index]);
                    }
                    for (int j =i; j < passengers.length - 1; j++){
                        delete[j] = String.valueOf(passengers[j + 1]);
                    }
                    break;
                }
                System.out.println("The Cabin Details are: ");
                System.out.println(passengers[i]);

                String enterToCabin = Queue[i].Dequeue(passengers[i].firstName , passengers[i].lastName,passengers[i].noOfChildPassengers,passengers[i].noOfAdultPassengers);
                enterToCabin = passengers[i].addPassenger();
                enterToCabin = passengers[i].toString();
            }
            }

        return null;
    }
    //Finding Cabins using the name of the passenger
    public static String findCabin(){
        System.out.println("Enter the Last Name of the Passenger: ");
        String Name = Sc2.next();
        for (int i = 1; i < 12;i++){
            while (passengers[i] != null){
                if (passengers[i].lastName.equals(Name)){
                    System.out.println("Passenger: " + Name + " has occupied Cabin No: " + (i) + " : " + passengers[i].firstName + " "+ passengers[i].lastName);
                    break;
                } else {
                    System.out.println("Passenger name cannot be found");
                }
                break;
            }
        }
        return null;
    }
    // Storing program contents into file
    public static String StoreProgramDataIntoFile() throws IOException {
        try{
            File cabinData = new File("Cabin Data.txt");
            PrintStream cabin = new PrintStream(cabinData);
            int index = 0;
            while (index < passengers.length){
                if(passengers[index] != null){
                    cabin.println("First Name: " + passengers[index].firstName);
                    cabin.println("Last Name: " + passengers[index].lastName);
                    cabin.println("Total Number of Adult Passengers: " + passengers[index].noOfAdultPassengers);
                    cabin.println("Total Number of Child Passengers: " +passengers[index].noOfChildPassengers);
                    cabin.println("Total Expenses: " +passengers[index].totalExpenses);
                }
                index++;
            }
            cabin.close();
        } catch (FileNotFoundException fnf){
            System.out.println("File is not found.");
        }
        return null;
    }
    // Loading program contents from file
    public static void loadProgramDataIntoFile() throws FileNotFoundException{
        try{
            File cabinData = new File("Cabin Data.txt");
            if (!Desktop.isDesktopSupported()){
                System.out.println("File is not supported.");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (cabinData.exists()){
                desktop.open(cabinData);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    // Sorting names of Passengers
    public static String Sorting(){
        String sortCustomers = "";
        for (int i = 1; i < 12; i++){
            for (int j = i; j < 12; j++){
                    if ((passengers[i].lastName).compareTo(passengers[j].lastName)> 0){
                        sortCustomers = passengers[i].lastName;
                        passengers[i].lastName = passengers[j].lastName;
                        passengers[j].lastName = sortCustomers;
                    }

            }
        }
        System.out.println("Sorting Passengers alphabetically by their last names");
        for (int i = 0; i < 12; i++){
            System.out.println(passengers[i]);
        }
        return null;
    }
    // Displaying expenses of all the passengers
    public static void displayExpenses(){
        System.out.println("Displaying Expenses of all passengers in the CruiseShip");
        for (int i =0; i < 12; i++){
            while (passengers[i] != null){
                System.out.println("Full Name: " + passengers[i].firstName + " " + passengers[i].lastName);
                System.out.println("Expenses: $ " + passengers[i].totalExpenses);
                break;
            }
        }
    }
}



