import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    private int quiz1Score = 0;
    private int quiz2Score = 0;
    private int quiz3Score = 0;
    private int midtermScore = 0;
    private int finalScore = 0;

    public Scanner reader = new Scanner(System.in); 

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
    public void displayInfo() {
        //This prints out studnet information
            System.out.println("\nSTUDENT INFORMATION");
            System.out.println("Name: " + name + "\n ID: " + uniqueID);
            System.out.println("Attendance\nPresent: " + present + "\nTardy: " + tardy + "\nAbsent: " + absent);

        
    }

    // function to update the student attendance
    public void updateAttendance() throws IOException{

        Scanner reader = new Scanner(System.in);

        int choice = 0;//inital and maek var of the user input 

        // shows the current infpomation of the student
        displayInfo();

        // if the loop is between 1-3 then it will loop
        while (choice < 1 || choice > 3) {

            System.out.println("\nEnter Attendance");
            System.out.println("1 for present\n2 for tardy\n3 for absent");

            // user input
            choice = reader.nextInt();
            reader.nextLine(); //makes sure hte new line is ok 

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
            updateAttendanceFile();
            
        }

        displayInfo();
    }
    public void updateAttendanceFile() throws IOException {
        //this. - is a method that you can refer to the current object you operate on 
        // learned  at https://www.w3schools.com/java/ref_keyword_this.asp
        File file = new File(this.uniqueID + ".txt"); //makes a new file based on the students ID 


    // Use a Scanner to read the file line by line
   // Read the file and build the updated content
   
    Scanner fileScanner = new Scanner(file);
    String updatedContent = "";
    while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        if (line.contains("Overall Present:")) {
            line = "Overall Present: " + present;
        } else if (line.contains("Overall Tardy:")) {
            line = "Overall Tardy: " + tardy;
        } else if (line.contains("Overall Absent:")) {
            line = "Overall Absent: " + absent;
        }
        updatedContent += line + "\n";
    }
    fileScanner.close();

    // Write the updated content back to the file
    PrintWriter writer = new PrintWriter(new FileWriter(file));
    writer.print(updatedContent);
    writer.close();
 

    System.out.println("Attendance updated in file " + this.uniqueID + ".txt");
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

    public void Grade() throws IOException {
        // Display current state (this may call your StudentStats method)
        StudentStats(1);
        
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Which assignment do you want to grade?");
        System.out.println("1. Quiz 1");
        System.out.println("2. Quiz 2");
        System.out.println("3. Quiz 3");
        System.out.println("4. Midterm");
        System.out.println("5. Final");
        
        int choice = reader.nextInt();
        reader.nextLine(); // clear the newline
        
        System.out.println("Enter the new score:");
        int newScore = reader.nextInt();
        reader.nextLine();
        
        switch (choice) {
            case 1:
                quiz1Score = newScore;
                break;
            case 2:
                quiz2Score = newScore;
                break;
            case 3:
                quiz3Score = newScore;
                break;
            case 4:
                midtermScore = newScore;
                break;
            case 5:
                finalScore = newScore;
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        
        // Save the updated instance state to the file
        saveStudentState();
        
        // Optionally, output the updated file content to verify
        System.out.println("Updated student file:");
        Scanner fileScanner = new Scanner(new File(this.uniqueID + ".txt"));
        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }
        fileScanner.close();
    }

        public void saveStudentState() throws IOException { 
            File file = new File(this.uniqueID + ".txt");
            // Open the file in overwrite mode 
            PrintWriter writer = new PrintWriter(new FileWriter(file, false));
            
            // Write student information
            writer.println("Student full name: " + name);
            // (Add any other details you want to store, such as graduation year if available)
            
            // Write attendance information
            writer.println("Overall Present: " + present);
            writer.println("Overall Tardy: " + tardy);
            writer.println("Overall Absent: " + absent);
            
            // Write assignment grades from the object variables
            writer.println("Quiz 1 Score: " + quiz1Score); //quiz 1
            writer.println("Quiz 2 Score: " + quiz2Score);
            writer.println("Quiz 3 Score: " + quiz3Score);

            writer.println("Midterm Score: " + midtermScore);
            writer.println("Final Score: " + finalScore);
            
            writer.close();
            System.out.println("Student state saved to file " + this.uniqueID + ".txt");
        }
        
        public void StudentStats(int FileDisplayType) throws IOException{
            //assumes ID given has already been vetted and is correct, so no error handling 

            Scanner FileScan = new Scanner(new File(this.uniqueID + ".txt")); //reads / sets up file for reading 

            if (FileDisplayType == 1){ //if it's one - then you print entire file
                System.out.println("----- Full Student Stats for Student ID: " + this.uniqueID + " -----");

                while (FileScan.hasNextLine()) { //reads the entire file while scanning to see if there is more out there 
                    System.out.println(FileScan.nextLine()); //then printing what it reads 
                }
                System.out.println("Attendance:");
                System.out.println("   Present: " + present);
                System.out.println("   Tardy: " + tardy);
                System.out.println("   Absent: " + absent);
                System.out.println("Grades:");
                System.out.println("   Quiz 1 Score: " + quiz1Score);
                System.out.println("   Quiz 2 Score: " + quiz2Score);
                System.out.println("   Quiz 3 Score: " + quiz3Score);
                System.out.println("   Midterm Score: " + midtermScore);
                System.out.println("   Final Score: " + finalScore);

                System.out.println("--------------------------------------------------------"); //for formatting 
            } 
            else { //if it's two, then you print the summery - name, grade, attendence totals, courses enrolled in + grades 
                System.out.println("----- Summary Student Stats for Student ID " + this.uniqueID + " -----"); 
                
                while(FileScan.hasNextLine())
                {   
                    boolean IsSummStatLine = false; //makes a variable to control the flow of what is counts as summery stats and what isn't 

                    String line = FileScan.nextLine(); // making a string to store and test the next line

                    if (line.indexOf("Student Full name:") != -1) { //if it contains student's full name in the line 
                        IsSummStatLine = true; 
                    } else if(line.indexOf("Student Graduation Year:") != -1) //if it contains the student's grad year
                    {
                                IsSummStatLine = true; }

                    if ( IsSummStatLine == true) //if it is so 
                    {
                        System.out.println(line); //prints out summery stat
                    }
                }
                System.out.println("Attendance: Present " + present + ", Tardy " + tardy + ", Absent " + absent);
        int quizAvg = (quiz1Score + quiz2Score + quiz3Score) / 3;
        System.out.println("Quiz Average: " + quizAvg);
        System.out.println("Midterm: " + midtermScore + ", Final: " + finalScore);
        System.out.println("--------------------------------------------------------");
                System.out.println("--------------------------------------------------------"); //for formatting 
            } 
        
            FileScan.close(); //for funsies and to make sure it dosn't bleed into next method 
        }   
    }
