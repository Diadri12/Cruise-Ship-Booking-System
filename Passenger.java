
public class Passenger  {
     String firstName;
     String lastName;
     int noOfAdultPassengers;
     int noOfChildPassengers;
     double totalExpenses;


    Passenger(){
        firstName = "fName";
        lastName = "lName";
        noOfAdultPassengers = 0;
        noOfChildPassengers = 0;
        totalExpenses =0.00;
    }

    Passenger(String firstName, String lastName, int noOfAdultPassengers,int noOfChildPassengers,double totalExpenses){
        this.firstName = firstName;
        this.lastName = lastName;
        this.noOfAdultPassengers = noOfAdultPassengers;
        this.noOfChildPassengers = noOfChildPassengers;
        this.totalExpenses = totalExpenses;
    }

    public void Expenses() {
        int age = 0;
        int adult = noOfAdultPassengers * 700; ;
        int child = noOfChildPassengers * 500;
        totalExpenses = adult + child;
    }

    public void setPassenger(){
        firstName = this.firstName;
        lastName = this.lastName;
        noOfAdultPassengers = this.noOfAdultPassengers;
        noOfChildPassengers = this.noOfChildPassengers;
        totalExpenses = totalExpenses;
    }

    public String addPassenger(){
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Total No of Adult Passengers: " + noOfAdultPassengers);
        System.out.println("Total No of Child Passengers: "+ noOfChildPassengers);
        System.out.println("Total Expenses: $" + totalExpenses);
        return firstName + lastName + noOfAdultPassengers + noOfChildPassengers + totalExpenses;
    }

    public String toString(){
        int totalPassengers = noOfAdultPassengers + noOfChildPassengers;
        return "\nFull Name: "+ firstName + " " + lastName + " " + "\nTotal Passengers in Cabin: " + totalPassengers;

    }

    public String getFirstName(){

        return firstName;
    }

    public String getLastName(){

        return lastName;
    }

    public int getNoOfChildPassengers(){

        return noOfChildPassengers;
    }

    public int getNoOfAdultPassengers(){

        return noOfAdultPassengers;
    }

    public double getTotalExpenses(){

        return totalExpenses;
    }
}
