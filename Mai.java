import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        inputStudents();//call the input student functiom
        showAllAttendance();//call the show all attendance function

        System.out.println("\nTaking attendance for all students:");
        for (int x = 0; x < currentStudents; x++) {//loop to take attendance for all students in rooster
            System.out.println("\nUpdating attendance for: " + studentRoster[x]);//print of which stuendt attendane isw being updated
            Student student = new Student(studentRoster[x], studentRosterID[x]);//Creates a new Student object for the current student using their name and id from the arry
            //calling the methofds
            student.updateAttendance();
            student.showAttendance();
        }
        
    }
    //this si final so the calue cant be changed
    private static final int maxNumStudent = 5;
    private static int[] studentRosterID = new int[maxNumStudent];//Static so that there is only one of it instedad of one for each 
    private static String[] studentRoster = new String[maxNumStudent];//Static so that there is only one of it instedad of one for each 
    private static int uniqueID = 000;//this eill be for studient id
    private static int currentStudents = 0;//to keep track of the num of students

    //fucntion to add student
    public static void inputStudents() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter information for " + maxNumStudent + " students:");

        while (currentStudents < maxNumStudent) {//make user enter teh amount of studnt names is in maxnumostutends
            System.out.println("\nEnter name for student #" + (currentStudents + 1));//show current student and add one since it starts at 0
            String name = reader.nextLine();

            uniqueID = uniqueID + 1; // increment the id
            studentRosterID[currentStudents] = uniqueID; // assign teh ID to student
            studentRoster[currentStudents] = name;//store teh naem in the roster
            currentStudents=currentStudents+1;//adds one to the current student

            System.out.println("Added: " + name + " ID: " + uniqueID + " \n");
        }
    }
// methid that shows studnt id and naem
    public static void showAllAttendance() {
        System.out.println("\nShowing attendance for all students:");
        for (int x = 0; x < currentStudents; x++) {//loop to show all the students
            System.out.println("\nStudent ID: " + studentRosterID[x]);//show the student ID
            System.out.println("Student Name: " + studentRoster[x]);//show the student name
        }
    }

    
}
