public class queue {
    public static int front;
    public static int rear;
    public static String [] waitingList = new String[5];
    public static int Size = 5;

    public queue(int i) {
    }

    public String waitingQueue(){
        int size;
        this.front = this.rear = -1;
        this.waitingList = new String[Size];
        return null;
    }

    public void Enqueue(String firstName, String lastName, int noOfAdultPassengers, int noOfChildPassengers){
        String fullName = firstName + " " + lastName;
        int totalPassengers = noOfChildPassengers + noOfAdultPassengers;
        if (isFull()){
            System.out.println("Waiting list is full");
        } else if (front == -1){
            front = 0;
        }
        rear = rear + 1 % waitingList.length;
        waitingList[rear] = "Name: " + fullName + "\n totalPassengers: " + totalPassengers;
        System.out.println(fullName + " is inserted to the waiting list");
        System.out.println(totalPassengers);
    }

    public String Dequeue(String firstName, String lastName, int noOfChildPassengers, int noOfAdultPassengers){
        String fullName = firstName + lastName;
        int totalPassengers = noOfChildPassengers + noOfAdultPassengers;
        if (isEmpty()){
            System.out.println("Waiting List is empty");
        } else{
            fullName = String.valueOf(waitingList[front]);
            if (front == rear){
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % Size;
            }
            return "Name: " + fullName + "\n totalPassengers: " + totalPassengers;
        }
        return null;
    }

    public boolean isFull(){
        if (front == 0 && rear == Size - 1){
            return true;
        }
        if (front == rear + 1){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isEmpty(){
        if (front == -1){
            return true;
        } else{
            return false;
        }
    }

    public void display(){
        int i;
        if (isEmpty()){
            System.out.println("The waiting list is empty");
        } else{
            System.out.println("Front = " + front);
            System.out.println("Names in the Waiting List");
            for ( i= front; i != rear; i = (i + 1) % Size){
                System.out.println(waitingList[i]);
            }
            System.out.println(waitingList[i]);

        }
    }

}
