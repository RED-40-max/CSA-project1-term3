/* 
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
    //making an array that stores the objects and sorts them to easily be called and edited upon 
    private static ColabStudent[] StudentInstance = new ColabStudent[5];  //only 5 can be added tho 
    //a third parellel array 
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
        }
        
    }
 

  
// method that shows studnt id and name
    public static void showAllAttendance() {
        System.out.println("\nShowing attendance for all students:");
        for (int x = 0; x < currentStudents; x++) {//loop to show all the students
            System.out.println("\nStudent ID: " + studentRosterID[x]);//show the student ID
            System.out.println("Student Name: " + studentRoster[x]);//show the student's first name
        }
    }

//another class -  
 public static void AddStudentToCourse() throws IOException
    { 
       
        //much easier way of deailing with file I/O
        PrintStudents(); //prints all student's ID out 
        System.out.println("Enter student ID to enroll in a course (or 9 to exit):  "); 

        int ID_Choice = reader.nextInt(); //reads in the ID chosen 
        reader.nextLine(); //makes sure the next line is valid and can run thorught 
        
        if (ID_Choice == 9) //if user wishes to exit 
        {
            return; //go back 
        }
        //error handling 
        int index = findStudentIndex(ID_Choice);  //indexing the Student for finding the instance by using the parallel ID  

        if (index == -1) //if parrelell id not found 
        {
            System.out.println("Invalid Student ID - returning"); 
            return; //return 
        }

        Scanner FileScan; //sets up file scanner
        FileScan = new Scanner(new File(ID_Choice + ".txt")); //uses given id for file, and also assumes student file exisits since it is in the system 
         
        //conferms that this is the student's file user wants to select
            //first find the student name thorught a loop, finding name: and making substrig to later print 

           // String StudentNamefromFile = "skibidi"; //makes it to store the student name w/ obv error

            // while(FileScan.hasNext()) //reads entire file
            // {
            //     String ComparisionStringN = FileScan.next(); //reads one line at a atime 

            //     if (ComparisionStringN.indexOf("Student Full name:") != -1) //checks if the line contains 'unique id' - meaning it can have the unique ID of the thing
            //     {
            //         int IndexOfStart = ComparisionStringN.indexOf(":"); //finds where the colon is so we can find where the name begins  
            //         StudentNamefromFile = ComparisionStringN.substring(IndexOfStart + 1).trim(); 
            //         //finds the student file by taking 
            //         //takes the end of the First name value and the total length of the string to get the Name and also gets rid of white space
            //         break; //come out off the loop after finding the ID from the file
                   
            //     }

            // }
            
            int StudentIndex = findStudentIndex(ID_Choice);
    
        //prints out student's name process
        System.out.println("Student Name: " + studentRoster[StudentIndex]); //prints out student's name
        System.out.print("Is this correct? (yes/no): "); //for the thingy 
        String UserInput = reader.nextLine();  //stores user input

        if (!UserInput.equals("yes")) { //if it's anything but yes, cancel it
            System.out.println("Course enrollment cancelled.");
            return;
        }
        

        // //prints out student's ID process
        // //first find the student ID thorught a loop, finding name: and making substrig to later print
        //     String ComparisionStringID; //makes a string to go and help compare
        //     int UniqueIDfromFile = 99999999; //makes a string with an obvious error for testing and so it can store id from file

        //     while(FileScan.hasNext()) //reads entire file
        //     {
        //         ComparisionStringID = FileScan.next(); //reads one line at a atime 
        //         if (ComparisionStringID.indexOf("Unique ID:") != -1) //checks if the line contains 'unique id' - meaning it can have the unique ID of the thing
        //         {
        //             UniqueIDfromFile = FileScan.nextInt(); //finds and stores the next integer from the file - assuming it is the unique id
        //             FileScan.nextLine();
        //             break; //come out off the loop after finding the ID from the file
                   
        //         }

        //     }
    


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
        reader.nextLine();
        String CourseName = "ratsoup"; //intilized with skibidi name for error checking
        String APStatus = "maybe"; //initlized with radical error checking wrong value
        
        switch (UsrCourse_Choice) //based on integer input, dose course selection accordingly / adds course and appropriate status 
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
        while(FileScan.hasNextLine()) //reads entire file
        {
           String  ComparisionStringN = FileScan.nextLine(); //reads one line at a atime 
            if(ComparisionStringN.indexOf(CourseName) != -1) //checks if the line contains THE Course name that you want to add 
            {
                    System.out.println("ERROR - STUDENT ALREADY IN " + CourseName);
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

        PrintWriter writer = new PrintWriter(new FileWriter(ID_Choice +".txt", true)); 
        //makes a writer that can append to the end charecters and then turns it over to the printer writer so it can write strings
        writer.println(" "); //blank for formatting
        writer.println("Course Name:" + CourseName); //set up course name
        writer.println(CourseName + " Type: " + APStatus ); //setting AP status
        int defaltValue = 999; //this is to initalize an impossiable number so it can be checked and marked as blank - makes it easier on grade() function
        //setting up with course name for easy refrence 
       // writer.println(CourseName + " Overall Grade: " + " " + defaltValue);
        //writer.println(CourseName + " Quiz Percentage Score: " + " " + defaltValue );
        
        //loop for quiz writing
        for(int x = 0; x<3; x++)
        {
            writer.println(CourseName + " Quiz "+ x +"Score: " + " " + defaltValue);
        }
        //other stuff
        //writer.println(CourseName + " Midterm Percentage Score: " + " " + defaltValue);
        writer.println(CourseName + " Midterm Score: " + " ");

       // writer.println(CourseName + " Final Percentage Score: " + " " + defaltValue);
        writer.println(CourseName + " Final Score: " + " ");
        writer.println(" "); //blank for formatting
        
        //showing that it worked
        System.out.println("you have now added " +  studentRoster[StudentIndex] + " to " + CourseName); 
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
        System.out.println("Would you like to add another student to another course? (Type 'yes' or enter anything else for no)"); 
        String UserResponseLpr = reader.nextLine(); //finds users response
        if (UserResponseLpr.equals("yes"))
        {
            AddStudentToCourse(); //gose back to the class and calls it 
            return; //exit properly 
        }

    }
      //fucntion to add student
     
    public static void registerStudent() throws IOException{
        Scanner reader = new Scanner(System.in);

        System.out.println("Input student's first name: ");
        String firstName = reader.nextLine();

        System.out.println("Input student's last name: ");
        String lastName = reader.nextLine();

        System.out.println("Input student's graduation year (ex. 2026): ");
        String gradYear = reader.nextLine();

        String FullName = firstName + " " + lastName; //make a full name string
        int StudentUniqueID = uniqueID++; //assings the student ID  
        
        //checking for repeated names and making sure that they want to add that name 
        for (int x = 0; x < currentStudents; x++)
        {
            if(studentRoster[x].equals(FullName)) //if they find something in the roster with the same name 
            {   
                System.out.println("A student with the name " + FullName + " already exists in the roster.");
                System.out.println("Do you want to proceed with registration? (1 for yes/2 for no)"); //ask if they still want to add
                int choice = reader.nextInt(); //gets reader input
                if (choice == 1) //if yes
                {
                    break; //breaks out 
                } else if (choice == 2) //if no call menu 
                {
                    System.out.println("Registration cancelled."); ///says that it cancled it and moved on to next student 
                    Menu(); //calls menu so they can escape and choose something else 
                    break; //and break out 
                }

            }

        }

        //System.out.println("Input student's current class (Ex. ): ");
        //String studentClass = reader.nextLine();

        //System.out.println("Input their grade in that class (Ex. A, B, etc.): ");
        //String classGrade = reader.nextLine();

        File file = new File(StudentUniqueID + ".txt"); //creates a file for this student based on unique ID and assings it to a value
        PrintWriter writer = new PrintWriter(new FileWriter(file, true)); //sets up a writer to write inside the file using appending method and calls on same file we just created
       
        //writes all collected data in 
        writer.println("Student full name: " + FullName); 
        writer.println("Student graduation Year: " + gradYear);
        writer.println(" "); //space for formatting 
        //put total attendence in
        writer.println("Overall present:");
        writer.println("Overall tardy:");
        writer.println("Overall absent:");

        writer.close(); //closes so other methods are chill 

        //updating data within main to reflect state
        studentRosterID[currentStudents] = StudentUniqueID; // assign the ID at the current index
        studentRoster[currentStudents] = FullName; // store the name
        ColabStudent newStudent = new ColabStudent(FullName, StudentUniqueID); //creates an instance of this 
        StudentInstance[currentStudents] = newStudent; //adds the instance to the array so we can later access it 
        currentStudents++; // then increment the counter

        //outputs messege
        System.out.println("Added: " + FullName + " ID: " + StudentUniqueID + " \n");
         
        writer.close(); //makes sure it don't leak 

        
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
        System.out.println("Hi! Welcome to the Kude High School registration portal.");
        
        while (inPortal) {
           System.out.println("\nEnter: \n(1) Register new student \n(2) Add student to course \n(3) See attendance \n(4) Update grades \n(5) Exit portal");
           int option = input.nextInt();
           input.nextLine();

           switch (option) {
              case 1: // register new student
                 while (true) {
                    PrintStudents();
                    System.out.println("Enter anything to proceed or 9 to exit.");
                    int ID = input.nextInt();
                    input.nextLine();

                    if (ID != 9) //if exit 
                    { registerStudent(); //go back
                    }
                    else 
                    {
                        break; //othersise exit 
                    }
                 }
                 break; 

                 
              case 2: // add student to course
                 while (true) {
                    PrintStudents();
                    System.out.println("Which student? Enter an ID, or 9 to exit.");
                    int ID = input.nextInt();
                    input.nextLine();
                    if (ID != 9) 
                    { AddStudentToCourse();
                    }else 
                    {break;}
                 } break; 

                 
              case 3: 
              //file I/O - it should loop thorught all the student files and print out all total attendences 
              //use: for loop, I/O, handling, ect. 
                 PrintStudents();
                 System.out.println("Would you like to update the attendance? Enter 1 if yes, 2 if no.");
                 int i = input.nextInt(); //stores the answer
                 input.nextLine(); //clears next line 
                 if (i == 1) { //if its one 
                    PrintStudents(); //print out all students and ID 
                       System.out.println("Which student? Enter an ID, or 9 to exit."); //ask for whitch one
                       int ID = input.nextInt(); //user inputs id
                       //input.nextLine(); //next line is cleared

                       int index = findStudentIndex(ID); //id to object
                       if (ID != 9) 
                       {
                        ColabStudent student = StudentInstance[index]; //use object
                            student.updateAttendance(); //do method 
                       }
                       else{ break;}
    
                 } break; 
       
                 
              case 4: // update grades
                 
                    PrintStudents();
                    System.out.println("Which student? Enter an ID, or 9 to exit.");
                    int ID = input.nextInt();
                    input.nextLine();
                    if (ID != 9) {
                        int index = findStudentIndex(ID); //finds the student ID with the inex
                        if(index == -1) //if user entered a invalid id 
                        {
                            System.out.println("Student Not found - leaving to menu"); 
                            break; //leaves to menu 

                        } else {
                            ColabStudent student = StudentInstance[index];                        
                            student.StudentStats(1); //calling the student stats for 
                            student.Grade(); 
                        }
                    } else {break;}
                    break; 
   
                 
              case 5: // exit portal
                 System.out.println("You have now exited the student registrtion portal.");
                 inPortal = false;
                 break;
                 
              default: // error checking
                 System.out.println("That option doesn't exist! Please enter an available number.");
                 option = input.nextInt();
                 input.nextLine();
                 break;
           }
        }
        
     }

     public static int findStudentIndex(int Student_ID) //quick method that finds an ID index based on the ID that the user inputed / is given
     {
        for (int x = 0; x < currentStudents; x++ ) //move thorught all the students
        {
       
            if (studentRosterID[x] == Student_ID) //find the student name from the ID 
            {
                return x;  //after you find it, return back
            } 
        }
                return -1; //don't return anything good, return -1
     }

}


    

