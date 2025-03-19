
//importing becuse insurence and errors out otherwise 
//importing becuse insurence and errors out otherwise 
import java.io.*;
import java.util.Scanner;


public class studentToCourse
{
    private static int[] StudentRosterID; 
    private static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
    
        
    }



    public static void AddStudentToCourse() throws IOException
    { 
       

        //PrintStudents()
        System.out.println("Pick Student's ID: "); 
        int ID_Choice = reader.nextInt(); //reads in the ID chosen 

    //checking and handeling ID
        //iterates thorught the array to check if user provided ID matches a valid ID within the Roster
        for(int x: StudentRosterID)
        {
            //if so, then turn the valid ID to true
            if(x == ID_Choice)
            {
                System.out.println("Error - you have entered a ID that dose not exist");
                //adds error
                AddStudentToCourse();
                //starts from the beginning
            }
            //otherwise leave it as it's defalt-- false 
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
                    int IndexOfStart = ComparisionStringN.indexOf("FirstName:");
                    StudentNamefromFile = ComparisionStringN.substring(IndexOfStart, ComparisionStringN.length()).trim();
                    //takes the end of the First name value and the total length of the string to get the Name and also gets rid of white space
                    break; //come out off the loop after finding the ID from the file
                   
                }

            }


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
                    break; //come out off the loop after finding the ID from the file
                   
                }

            }

            System.out.println("Student ID: " + UniqueIDfromFile); //prints out student's ID found from file 
            
            System.out.println("is this the intended Student? (press any key or type \"no\"): "); 
            String UserConfermation = reader.next(); //reads and stores user answer 
                if (UserConfermation == "no") //if it's wrong then try again
                {
                    AddStudentToCourse(); //try again 
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

        }

        
        //checks if student is in course   
        boolean IsStudentNotInCourse = true; //asssumes that student is not in course 
        while(FileScan.hasNext()) //reads entire file
        {
            ComparisionStringN = FileScan.next(); //reads one line at a atime 
            if (ComparisionStringN.indexOf(CourseName) != -1) //checks if the line contains THE Course name that you want to add 
            {
                    System.out.println("ERROR - STUDENT ALREADY IN COURSE");
                    AddStudentToCourse(); //gose back to start of the class

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
        writer.println("Course Type:" + APStatus ); //setting AP status
        //setting up with course name for easy refrence 
        writer.println(CourseName + " Overall Grade: " );
        writer.println(CourseName + " Quiz Percentage Score: " );
        
        //loop for quiz writing
        for(int x = 0; x<5; x++)
        {
            writer.println(CourseName + " Quiz "+ x +"Score: " );
        }
        //other stuff
        writer.println(CourseName + " Midterm Percentage Score: " );
        writer.println(CourseName + " Midterm Score: " );

        writer.println(CourseName + " Final Percentage Score: " );
        writer.println(CourseName + " Final Score: " );

        writer.println(CourseName + " Attendence " );
        writer.println(CourseName + " Present: " );
        writer.println(CourseName + " Tardy: " );
        writer.println(CourseName + " Absent: " );
        writer.println(" "); //blank for formatting
        
        //showing that it worked
        System.out.println("you have now added" + StudentNamefromFile + "to" + CourseName); 
        //reads file if you want
        System.out.println("Would you like to see the updated File?(type 'yes' or enter anything else for no)"); 
        String UserResponseUF = reader.nextLine(); //finds users response
        if (UserResponseUF == "yes")
        {
            while(FileScan.hasNext())
            {
                System.out.println(FileScan.nextLine()); //reads the entire student file
            }
            //PrintStudents()
    
            writer.close(); //close the writer out. 
            FileScan.close(); //closes filescan too 

        } 
        //for the loop 
        System.out.println("Would you like to add another student to another course? (type 'yes' or enter anything else for no)"); 
        String UserResponseLpr = reader.nextLine(); //finds users response
        if (UserResponseLpr == "yes")
        {
            AddStudentToCourse(); //gose back to the class and calls it 
        }

    }


    public static void CalculateGrade()
    {
        
    }


   


}

