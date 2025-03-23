/* 
TO-DO 
- unify Student Registration
    + merge / edit inputStudents() and registerStudent()
        + so that it creates a file, writes student info, updates student Roster and Student Roster id arrays 
        + make sure it reads / writes with proper error handling and checks for file exsitence 
        + make sure it writes in the details into the file

- Edit StudentStats(int FileDisplayType) 
    + finish code that displays the students stats (based on 1 or 2)
    + make sure it works thorught the program with it's parameters 
    + project integration thorught code. 

- updateAttendance() for I/O 
    + make it so that it updates the file, rather then the variable 

- showAttendance() for I/O 
    + make it so that it reads from a perticular file 
    + make it so that it reads only some things / total attendence from perticular file 

- Grade() - for I/O 
    + make it so that it reads and updates to a perticular selected file 
    + integrate grade thorught the program 
    + make sure override vs. normal is sepreate and clear 
    + make sure file updates and calcuations are set and do it 


- Menu() - for how to create and call new objects 
    + find out how to create a new student object and manipulate it 
    + figure out how to create / call a perticular student and a perticular method within that students thing 
    + call case 3 and 4 better / edit it so no syntax errors 
    + fix calls so they are called on the proper object and the correct studen'ts data is used 
    + integrate better into program 

- main(String[] args)
    + sort out how that will work and the flow, given menu and whatnot
    + review main so no redudencies with calling methods  
    
- use findStudentIndex(int Id)  
    + find places where it could streamline efficency and make it better 
    + revise the loop so it returns the correct index when a match is found, rather then overrighting each time 
    + use if need be, otherwise leave it. 

other stuff: 
    + for string comparsions use .equals() instead of == 
    + after using nextInt(), add nextLine() to clear and avoid skipping input 
    + make sure variable names, methods, and classes are all consisitant 
    + put a little more comments on some bare looking stuff 
    + wayy more I/O then what it currently has 

 */



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner; //imports for scanning 

public class ColabMain {
       //this si final so the calue cant be changed
    private static final int maxNumStudent = 5;
    private static int[] studentRosterID = new int[maxNumStudent];//Static so that there is only one of it instedad of one for each 
    private static String[] studentRoster = new String[maxNumStudent];//Static so that there is only one of it instedad of one for each 
    private static int uniqueID = 0;//this eill be for studient id
    private static int currentStudents = 0;//to keep track of the num of students
    private static Scanner reader = new Scanner(System.in);

    
    
    public static void main(String[] args) throws IOException{
        Menu(); 
        
        //inputStudents();//call the input student functiom
        registerStudent(); //to make new students w/ file 
        showAllAttendance();//call the show all attendance function

        System.out.println("\nTaking attendance for all students:");
        for (int x = 0; x < currentStudents; x++) {//loop to take attendance for all students in rooster
            System.out.println("\nUpdating attendance for: " + studentRoster[x]);//print of which stuendt attendane isw being updated
            ColabStudent students = new ColabStudent(studentRoster[x], studentRosterID[x]);//Creates a new Student object for the current student using their name and id from the arry
            //calling the methofds
            students.updateAttendance();
            students.showAttendance();
            AddStudentToCourse();
        }
        
    }
 

    //fucntion to add student
    public static void inputStudents() {
        
        System.out.println("Enter information for " + maxNumStudent + " students:");

        while (currentStudents < maxNumStudent) {//make user enter teh amount of studnt names is in maxnumostutends
            System.out.println("\nEnter name for student #" + (currentStudents + 1));//show current student and add one since it starts at 0
            String name = reader.nextLine();
            File file = new File(uniqueID + ".txt"); //creates a file for this student based on unique ID
            

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

//another class -  
 public static void AddStudentToCourse() throws IOException
    { 
       

        PrintStudents(); //prints all student's ID out 
        System.out.println("Pick Student's ID: "); 
        int ID_Choice = reader.nextInt(); //reads in the ID chosen 
        
    //checking and handeling ID
        boolean IsValidID = false; 
        //iterates thorught the array to check if user provided ID matches a valid ID within the Roster
        for(int x: studentRosterID)
        {
            //if so, then turn the valid ID to true
            if(x == ID_Choice)
            {
                IsValidID = true; //changes to true so error handling isn't triggered
            }
            //otherwise leave it as it's defalt-- false 
        }  //aftwerward the loop you must have checked every value and if it still is false  - then 
        if (IsValidID == false)
        {
            System.out.println("Error - you have entered a ID that dose not exist");
                //adds error
                AddStudentToCourse();
                return; //to exit properly and avoid further calling
        }

        Scanner FileScan; //sets up file scanner
        FileScan = new Scanner(new File(ID_Choice + ".txt")); //uses given id for file
        
        

        //conferms that this is the student's file user wants to select
            //first find the student name thorught a loop, finding name: and making substrig to later print 

            String ComparisionStringN; //makes a string to go and help compare
            String StudentNamefromFile = "skibidi"; //makes it to store the student name w/ obv error

            while(FileScan.hasNext()) //reads entire file
            {
                ComparisionStringN = FileScan.next(); //reads one line at a atime 
                if (ComparisionStringN.indexOf("First Name:") != -1) //checks if the line contains 'unique id' - meaning it can have the unique ID of the thing
                {
                    int IndexOfStart = ComparisionStringN.indexOf("First Name:");
                    StudentNamefromFile = ComparisionStringN.substring(IndexOfStart, ComparisionStringN.length()).trim();
                    //takes the end of the First name value and the total length of the string to get the Name and also gets rid of white space
                    break; //come out off the loop after finding the ID from the file
                   
                }

            }

            FileScan.close(); //closed to restart 
            FileScan = new Scanner(new File(ID_Choice + ".txt")); //open to start from beging and to go throught 
    
        //prints out student's name process
        System.out.println("Student Name: " + StudentNamefromFile); //prints out student's name
            
        //prints out student's ID process
        //first find the student ID thorught a loop, finding name: and making substrig to later print
            String ComparisionStringID; //makes a string to go and help compare
            int UniqueIDfromFile = 99999999; //makes a string with an obvious error for testing and so it can store id from file

            while(FileScan.hasNext()) //reads entire file
            {
                ComparisionStringID = FileScan.next(); //reads one line at a atime 
                if (ComparisionStringID.indexOf("Unique ID:") != -1) //checks if the line contains 'unique id' - meaning it can have the unique ID of the thing
                {
                    UniqueIDfromFile = FileScan.nextInt(); //finds and stores the next integer from the file - assuming it is the unique id
                    FileScan.nextLine();
                    break; //come out off the loop after finding the ID from the file
                   
                }

            }
            
            System.out.println("Student ID: " + UniqueIDfromFile); //prints out student's ID found from file 
            
            System.out.println("is this the intended Student? (press any key or type \"no\"): "); 
            String UserConfermation = reader.next(); //reads and stores user answer 
                if (UserConfermation.equals("no")) //if it's wrong then try again
                {
                    AddStudentToCourse(); //try again 
                    return; //exit propertly and avoid furhter calling
                } 


        /* //if array is more reliable use this instead 
            for(int x = 0; 0 < StudentRosterID.length ; x++)
            {
                if(StudentRosterID[x] == ID_Choice)
                {
                    System.out.println("Student Name: " + StudentRoster[x]); //gets the name from array
                    System.out.println("Student ID: " + StudentRosterID[x]); //gets ID from the array 
                    System.out.println("is this the intended Student? (press any key or type \"no\"): "); //asks user to confirm
                    break;//exits the loop
                }

            }
            String UserConfermation = reader.next(); //reads and stores user answer based on array answers
            if (UserConfermation == "no") //if it's wrong then try again
            {
                AddStudentToCourse(); //try again 
                return; //exit properly and avoid call
            } 

         */

       
        //Asks user to input what course they would like to Assign student to 
        
        System.out.println("""
            ----Pick a course to enroll students------
                (1) World History
                (2) Geometry
                (3) AP Chemistry
                (4) AP Literature 
            -------------------------------------------    
            Choose a course to enroll the student in (1/2/3/4): 
                """); //prints out the menu
        int UsrCourse_Choice = reader.nextInt(); //reads in the Choice
        String CourseName = "ratsoup"; //intilized with skibidi name for error checking
        String APStatus = "maybe"; //initlized with radical error checking wrong value
        switch(UsrCourse_Choice) //based on integer input, dose course selection accordingly / adds course and appropriate status 
        {
            case 1: 
                CourseName = "World History";
                APStatus = "Regular";
                break; 
            case 2: 
                CourseName = "Geometry";
                APStatus = "Regular";
                break; 
            case 3: 
                CourseName = "AP Chemistry";
                APStatus = "AP";
                break; 
            case 4: 
                CourseName = "AP Literature";
                APStatus = "AP";
                break; 
            default: 
                System.out.println("ERROR - NOT VALID INPUT");
                AddStudentToCourse(); //gose back 
                return; //exits properly 

        }
        FileScan.close(); //closed to restart 
        FileScan = new Scanner(new File(ID_Choice + ".txt")); //open to start from beging and to go throught 

        
        //checks if student is in course   
        boolean IsStudentNotInCourse = true; //asssumes that student is not in course 
        while(FileScan.hasNext()) //reads entire file
        {
            ComparisionStringN = FileScan.next(); //reads one line at a atime 
            if (ComparisionStringN.indexOf(CourseName) != -1) //checks if the line contains THE Course name that you want to add 
            {
                    System.out.println("ERROR - STUDENT ALREADY IN COURSE");
                    AddStudentToCourse(); //gose back to start of the class
                    return; //exit properly 

            }
               
        }
    /* FOUND METHOD: 
            
            new FileWriter(path, true); 

        by putting the object - in this case the file,  if we make the second argument true, it will write 
        to the end of the file, rather then the beginning. this means that it won't write over existing data 
        and i can just append / add to the end of the file and the world won't explode becuse my file's data is lost 
        becuse my data won't be lost. 
        this is becuase the next param to this method from this class is 'boolean append', so you can indicate if you want to 
        append the file or not thorught this method
            curtosy of GeeksforGeeks at 
                https://www.geeksforgeeks.org/filewriter-class-in-java/
        both classes are part of 
        PrintWriter - the one we use in class is diffrent then 
        FileWriter - only writes charecters 

        so instead its: 
            PrinterWriter writer = new PrintWriter(new FileWriter(path, true)); 
        */

        PrintWriter writer = new PrintWriter(new FileWriter(UniqueIDfromFile +".txt", true)); 
        //makes a writer that can append to the end charecters and then turns it over to the printer writer so it can write strings
        writer.println(" "); //blank for formatting
        writer.println("Course Name:" + CourseName); //set up course name
        writer.println(CourseName + " Type: " + APStatus ); //setting AP status
        int defaltValue = 999; //this is to initalize an impossiable number so it can be checked and marked as blank - makes it easier on grade() function
        //setting up with course name for easy refrence 
        writer.println(CourseName + " Overall Grade: " + " " + defaltValue);
        writer.println(CourseName + " Quiz Percentage Score: " + " " + defaltValue );
        
        //loop for quiz writing
        for(int x = 0; x<5; x++)
        {
            writer.println(CourseName + " Quiz "+ x +"Score: " + " " + defaltValue);
        }
        //other stuff
        writer.println(CourseName + " Midterm Percentage Score: " + " " + defaltValue);
        writer.println(CourseName + " Midterm Score: " + " ");

        writer.println(CourseName + " Final Percentage Score: " + " " + defaltValue);
        writer.println(CourseName + " Final Score: " + " ");

        writer.println(CourseName + " Attendence " );
        writer.println(CourseName + " Present: " + " " + defaltValue);
        writer.println(CourseName + " Tardy: " + " " + defaltValue);
        writer.println(CourseName + " Absent: " + " " + defaltValue);
        writer.println(" "); //blank for formatting
        
        //showing that it worked
        System.out.println("you have now added" + StudentNamefromFile + "to" + CourseName); 
        //reads file if you want
        System.out.println("Would you like to see the updated File?(type 'yes' or enter anything else for no)"); 
        String UserResponseUF = reader.nextLine(); //finds users response

        FileScan.close(); //closed to restart 
        FileScan = new Scanner(new File(ID_Choice + ".txt")); //open to start from beging and to go throught 

        if (UserResponseUF.equals("yes"))
        {
            while(FileScan.hasNext())
            {
                System.out.println(FileScan.nextLine()); //reads the entire student file
            }
            //PrintStudents()
        } 
        writer.close(); //close the writer out. 
        FileScan.close(); //closes filescan too 

        //for the loop 
        System.out.println("Would you like to add another student to another course? (type 'yes' or enter anything else for no)"); 
        String UserResponseLpr = reader.nextLine(); //finds users response
        if (UserResponseLpr.equals("yes"))
        {
            AddStudentToCourse(); //gose back to the class and calls it 
            return; //exit properly 
        }

    }
    public static void registerStudent() throws IOException{
        int UniqueID=1;
        int StudentUniqueID=0;
            
        System.out.println("Input student's first name: ");
        String firstName=reader.nextLine();
        System.out.println("Input student's last name: ");
        String lastName=reader.nextLine();
        System.out.println("Input student's graduation year (Ex. 2026): ");
        String gradYear=reader.nextLine();
        System.out.println("Input student's current class (Ex. ): ");
        String studentClass=reader.nextLine();
        System.out.println("Input their grade in that class (Ex. A, B, etc.): ");
        String classGrade=reader.nextLine();
        //make a file for the student 
        
        StudentUniqueID+=UniqueID;
        UniqueID+=1;
        AddStudentToCourse();
        
    }
    public static void PrintStudents() throws IOException{
        
        for(int x = 0; x < currentStudents; x++) //this loop will print all students in the rosters / what their name and file is 
        {
            System.out.println("----------------------"); //for formatting
            System.out.println("First name: "+ studentRoster[x]);
            System.out.println("ID: "+ studentRosterID[x]); 
            System.out.println("----------------------"); //for formatting
      
        }
    }
//EDIT
   

    public static void Menu() throws IOException { // method
        Scanner input = new Scanner(System.in);
        boolean inPortal = true; 

        while (inPortal) {
           System.out.println("Hi! Welcome to the Kude High School registration portal.\n Enter: \n (1) Register new student" 
           + "\n(2) Add student to course \n(3) See attendance \n(4) Update grades \n(5) Exit portal");
           int option = input.nextInt();

           switch (option) {
              case 1: // register new student
                 while (true) {
                    PrintStudents();
                    System.out.println("Which student? Enter an ID, or 9 to exit.");
                    int ID = input.nextInt();
                    if (ID != 9)
                    { registerStudent();
                    }
                    else 
                    {
                        break;
                    }
                 }
                 break;
                 
              case 2: // add student to course
                 while (true) {
                    PrintStudents();
                    System.out.println("Which student? Enter an ID, or 9 to exit.");
                    int ID = input.nextInt();
                    if (ID != 9) 
                    { AddStudentToCourse();
                    }else 
                    {break;}
                 }
                 break;
                 
              case 3: 
              //file I/O - it should loop thorught all the student files and print out all total attendences 
              //use: for loop, I/O, handling, ect. 
                 System.out.println("Would you like to update the attendance? Enter 1 if yes, 2 if no.");
                 int i = input.nextInt();
                 if (i == 1) {
               
                    PrintStudents();
                       System.out.println("Which student? Enter an ID, or 9 to exit.");
                       int ID = input.nextInt();
                       if (ID != 9) 
                       {
                            ColabStudents.updateAttendance();
                       }
                       else{ break;}
    
                 }
                 break;
                 
              case 4: // update grades
                 
                    PrintStudents();
                    System.out.println("Which student? Enter an ID, or 9 to exit.");
                    int ID = input.nextInt();
                    if (ID != 9) {
    
                        students.StudentStats(1); // idk if this is correct way to call it
                        students.Grade(ID);
                    }
                    else {break;}
                
                 break;
                 
              case 5: // exit portal
                 System.out.println("You have now exited the student registrtion portal.");
                 inPortal = false;
                 break;
                 
              default: // error checking
                 System.out.println("That option doesn't exist! Please enter an available number.");
                 option = input.nextInt();
                 break;
           }
        }
        
     }

     public static int findStudentIndex(int Id) //quick method that finds an ID index based on the ID that the user inputed / is given
     {
        for (int x = 0; x < currentStudents; x++ )
        {
            if (studentRosterID[x] == Id)
            {
                Id = x; 
            } else 
            {
                Id = -1; 
            }
        }
                return Id;
     }

}


    

