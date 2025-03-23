import java.util.Scanner;

public class ColabStudent {
    // this si to store student name, Id, and attendance
    // this is also private so that only methods inside the Student class can modify
    // it.thsii is to avoid errro
    private String name;
    private int uniqueID;
    private int present;
    private int tardy;
    private int absent;

    // initialize student inofmation
    public ColabStudent(String studentName, int studentID) {
        name = studentName;
        uniqueID = studentID;
        present = 0;
        tardy = 0;
        absent = 0;

    }

    // function to get student name
    // public cause other classes like manin need to use it
    public String getName() {
        return name;
    }

    // fucntion to get student ID
    public int getUniqueID() {
        return uniqueID;
    }

    // function with parameter to show student info
    public void displayInfo(int Display) {

        if (Display == 0) {// if display is 0 then display all student info

            System.out.println("\nSTUDENT INFORMATION");
            System.out.println("Name: " + name + "\n ID: " + uniqueID);
            System.out.println("Attendance\nPresent: " + present + "\nTardy: " + tardy + "\nAbsent: " + absent);

        }
    }

    // function to update the student attendance
    public void updateAttendance() {

        Scanner reader = new Scanner(System.in);

        int choice = 0;//inital and maek var of the user input 

        // shows the current infpomation of the student
        displayInfo(0);

        // if the loop is between 1-3 then it will loop
        while (choice < 1 || choice > 3) {

            System.out.println("\nEnter Attendance");
            System.out.println("1 for present\n2 for tardy\n3 for absent");

            // user input
            choice = reader.nextInt();

            // user input optuon
            if (choice == 1) {
                // Increment present counter
                present++;
                System.out.println("Marked as present");
            } else if (choice == 2) {
                // Increment tardy counter
                tardy++;
                System.out.println("Marked as tardy");
            } else if (choice == 3) {
                // Increment absent countre
                absent++;
                System.out.println("Marked as absent");
            } else {

                System.out.println("Error! This is not an option. Please enter 1, 2, or 3");
                reader.nextLine(); // thos is to clear invalid input: Learned from https://stackoverflow.com/questions/38830142/how-to-handle-invalid-input-when-using-scanner-nextint
            }
        }

        displayInfo(0);
    }

    public void showAttendance() {
        String attStats;
        // THis is to show which status has the higehst value
        if (present > 0 && present > tardy && present > absent) {
            attStats = "is present";
        } else if (tardy > 0 && tardy >= present && tardy > absent) {
            attStats = "is tardy";
        } else if (absent > 0 && absent >= present && absent >= tardy) {
            attStats = "is absent";
        } else {
            attStats = "has no attendance recorded";
        }
        System.out.println(name + " " + attStats);
    }

    
}
