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
    Scanner fileScanner = new Scanner(file);
    StringBuffer fileBuffer = new StringBuffer();

    while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        // Use indexOf to check if the line contains one of the attendance labels.
        if (line.indexOf("Overall Present:") != -1) {
            line = "Overall Present: " + present;
        } else if (line.indexOf("Overall Tardy:") != -1) {
            line = "Overall Tardy: " + tardy;
        } else if (line.indexOf("Overall Absent:") != -1) {
            line = "Overall Absent: " + absent;
        }
        fileBuffer.append(line).append(System.lineSeparator());
    }
    fileScanner.close();

    // Write the updated contents back to the file (overwriting existing content)
    PrintWriter writer = new PrintWriter(new FileWriter(file));
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

    public void Grade(int Student_ID)throws IOException{
        StudentStats(1); //prints out the stats of the student
        Scanner reader = new Scanner(System.in); //so it works for this as well

            System.out.println("Do you want to change a grade or input one in \n('Override' or 'Normal Grade'): ");
            String gradeOption = reader.nextLine();

            System.out.println("for which of the student's courses"); 
            String CourseName = reader.nextLine(); 

            if (gradeOption.equals("Override")){ //makes the override equence 
                System.out.println("What grade do you want to override \n 1 - Quiz Percentage Score: \n 2 - Midterm Percentage Score \n 3 - Final Percentage Score:): "); //asks user
                //print options like 1=quiz or smth
                int assignmentType = reader.nextInt(); //takes in the input 
                reader.nextLine(); //clears the new line

                System.out.println("What % do you want to change it to: ");
                int changePercent = reader.nextInt();
                reader.nextLine();
                
                String FullAssingmentName; 

                switch(assignmentType) //sets assingment type 
                {
                    case 1: //quiz percentage
                        FullAssingmentName = CourseName + " Quiz Percentage Score";
                        break;
                    case 2: //midterm percetnage
                        FullAssingmentName = CourseName + " Midterm Percentage Score";
                        break;
                    case 3: //final
                        FullAssingmentName = CourseName + " Final Percentage Score"; 
                        break;

                    default: //otherwise do this
                        System.out.println("ERROR - INPUT error try again"); 
                        Grade(Student_ID); //calls it again 
                        break;
                }
                //replace the current percentage score with the new one 

            } else if (gradeOption.equals("Normal Grade")){
                System.out.println("What assignment grade do you want to input (\n 1 - Quiz \n 2 - Final \n 3 - Midterm) ");
                int assignmentType = reader.nextInt(); //reads it 
                reader.nextLine();

                //also the 1=quiz etc
                switch(assignmentType){
                    case 1:
                        //quiz
                        System.out.println("What grade did they get: ");
                        int quizScore = reader.nextInt();
                        reader.nextLine();
                        break;
                    case 2:
                        //hw
                        System.out.println("What grade did they get: ");
                        int hwScore = reader.nextInt();
                        reader.nextLine();
                        break;
                    case 3:
                        //midterm
                        System.out.println("What grade did they get: ");
                        int midtermScore = reader.nextInt();
                        reader.nextLine();
                        break;
                    case 4:
                        //final
                        System.out.println("What grade did they get: ");
                        int finalScore = reader.nextInt();
                        reader.nextLine();
                        break;
                    default:
                        System.out.println("That isn't a option, try again. ");
                        //goes back to the grade class and loops again 
                        //put the funtion/method in loop :3
                    }
                //update the files, CalculateGrade() and StudentStats()
                //idk to do on githubbbbbb
                            
                
                } else 
                {
                    System.out.println("Invalid Option");
                }
                
          
            
        }
        public void StudentStats(int FileDisplayType) throws IOException{
            //assumes ID given has already been vetted and is correct, so no error handling 

            Scanner FileScan = new Scanner(new File(this.uniqueID + ".txt")); //reads / sets up file for reading 

            if (FileDisplayType == 1){ //if it's one - then you print entire file
                System.out.println("----- Full Student Stats for Student ID: " + this.uniqueID + " -----");

                while (FileScan.hasNextLine()) { //reads the entire file while scanning to see if there is more out there 
                    System.out.println(FileScan.nextLine()); //then printing what it reads 
                }

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
                        IsSummStatLine = true; 
                    } else if(line.indexOf("Course Name:") != -1 ) //contains course name
                    {
                        IsSummStatLine = true; 
                    }else if(line.indexOf("Overall Grade:") != -1) //contains overall grade
                    {
                        IsSummStatLine = true; 
                    }else if(line.indexOf("Present:") != -1) //contains overall present 
                    {
                        IsSummStatLine = true; 
                    }else if(line.indexOf("Tardy:") != -1) //contains overall tardy 
                    {
                        IsSummStatLine = true; 
                    }else if(line.indexOf("Absent:") != -1) //contains overall absents
                    {
                        IsSummStatLine = true; //makes it true so it can print 
                    }

                    if ( IsSummStatLine == true) //if it is so 
                    {
                        System.out.println(line); //prints out summery stat
                    }
                }
                System.out.println("--------------------------------------------------------"); //for formatting 
            } 
        
            FileScan.close(); //for funsies and to make sure it dosn't bleed into next method 
        }   
}
