
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
        boolean IsValidID = false; 
        //iterates thorught the array to check if user provided ID matches a valid ID within the Roster
        for(int x: StudentRosterID)
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

    //making it calculate grades 

    public static void CalculateGrade(int ID_Choice) throws IOException
    {
        String[] Courses = {"World History", "Geometry", "AP Chemistry", "AP Literature" }; //makes a list of courses to iterate thorught
        //StudentStats() 
        //make file scanner to read the file
        Scanner FileScan = new Scanner(new File(ID_Choice + ".txt")); 

        //find all course names and store in a string 
        //find index of first course, do calculations, take away that index and loop for all other instances 

        String CompLine; //comparing line 
        //find all the classes student is in 
        
        String CurrentCourse; //makes a string to store it 

       
     
        for(int x = 0; x < Courses.length; x++)
        {
            //in this loop to reset for each course
            int RunningQuizScore = 0; //points earned - 
            int RunningQuizDenom = 0; //demonanators / what the points max was 

            int MidtermScore = 0; //for the midterm
            int FinalScore = 0; //for the final
            double QuizWeights = 0; 
            double SummitiveWeight = 0; 
            double HomeworkWeight = 0; 
            String LetterGrade = "P"; 
            

            while(FileScan.hasNext()) //reads entire file
            { 
            
                CompLine = FileScan.next(); //reads one line at a atime 
                if(CompLine.indexOf(Courses[x]) != -1) //if the course name exists 
                {
                //sets weights for the classes when conforiming 
                    if(CompLine.indexOf(Courses[x] + " Type: AP") != -1)  // if it is a AP type course sets up for AP weightage 
                    {   
                         QuizWeights = 0.10; //sets up for AP tests
                         SummitiveWeight = 0.8; 
                         HomeworkWeight = 0.1; 
                    }
                    else if(CompLine.indexOf(Courses[x] + " Type: Regular") != -1)  // if it is a AP type course sets up for AP weightage 
                    {   
                         QuizWeights = 0.20; //sets up for AP tests
                         SummitiveWeight = 0.8; 
                         HomeworkWeight = 0.0; 
                    }
                //selects the category and reads it in as numbers 
                
                
                    for(int m = 0; m < 5; m++) //loop for quizzes
                    {
                        String ComaprisonQuiz = (Courses[x] + " Quiz "+ m + "Score: " );  
                        //finds the string containg quiz score to total it up
                        if (CompLine.indexOf(ComaprisonQuiz)!= -1)
                        {
                            int HolderValueQuiz = FileScan.nextInt();
                            if( HolderValueQuiz != 999) //if next int contains anything but 
                            {   
                                RunningQuizScore += HolderValueQuiz; //adds the points to the running score of it 
                                RunningQuizDenom += 20; //adds 20 since each quiz is worth 20 points 
                            }

                        }
                    
                    }
        
                
                String ComaprisonMidterm = (Courses[x] + " Midterm Percentage Score: " ); //sets up a string to compare to 
                if (CompLine.indexOf( ComaprisonMidterm) != -1) //checks if there is a midterm line for this course
                {
                    int HolderValueMidterm = FileScan.nextInt();
                    if( HolderValueMidterm != 999) //if next int contains anything but 
                    { 
                        MidtermScore = HolderValueMidterm;

                    }   
                
                    //if ap / not ap - calculates final grades based on weights and totals 


                }
                String ComparisionFinal = (Courses[x] + " Final Score: " ); //checks if there is a midterm line for this course
                if(CompLine.indexOf(ComparisionFinal) != -1)
                {
                    int HolderValueFinal = FileScan.nextInt();
                    if(HolderValueFinal != 999)
                    {
                        FinalScore = HolderValueFinal; //sets it up

                    }

                }
            
                
        }       

    
        }
        // at the end of the while loop then we take all the scores and calculate it 
            double QuizPercentScore = (double)RunningQuizScore/(double)RunningQuizDenom; //calculates quiz percentage
            double MidtermPercentScore = (double)MidtermScore/50.0; //finds midterm score 
            double FinalPercentScore = (double)FinalScore / 100.0; //finds final score 

            double CoursePercentageScore = (QuizPercentScore * QuizWeights) + (((MidtermPercentScore + FinalPercentScore)/2 ) *SummitiveWeight) + (HomeworkWeight * 1); 
            //this assumes that we obtain the sumative score by midterm and final percent score by avrageing the midterm and final and multiplying it by the summitive weight 
            //we are also assuming that homework has been completed and is weighted at 1 - so basically a free 10% to students in that class 
            if((CoursePercentageScore > 0.93 )&&(CoursePercentageScore <=1))
            {
                LetterGrade = "A"; 
            } else if((CoursePercentageScore > 0.9 )&&(CoursePercentageScore <= 0.93))
            {
                LetterGrade = "A-"; 

            } else if((CoursePercentageScore > 0.87 )&&(CoursePercentageScore <=0.9))
            {
                LetterGrade = "B+"; 
                
            } else if((CoursePercentageScore > 0.83 )&&(CoursePercentageScore <= 0.87))
            {
                LetterGrade = "B"; 
                
            } else if((CoursePercentageScore > 0.8 )&&(CoursePercentageScore <=0.83))
            {
                LetterGrade = "B-"; 
                
            } else if((CoursePercentageScore > 0.75 )&&(CoursePercentageScore <=0.8))
            {
                LetterGrade = "C+"; 
                
            } else if((CoursePercentageScore > 0.70 )&&(CoursePercentageScore <= 0.75))
            {
                LetterGrade = "C"; 
                
            } else if((CoursePercentageScore > 0.65 )&&(CoursePercentageScore <= 0.70))
            {
                LetterGrade = "C-"; 
                
            } else if((CoursePercentageScore > 0.60 )&&(CoursePercentageScore <= 0.65))
            {
                LetterGrade = "D+"; 
            } else if((CoursePercentageScore > 0.55 )&&(CoursePercentageScore <= 0.60))
            {
                LetterGrade = "D"; 
                
            } else if((CoursePercentageScore > 0.50 )&&(CoursePercentageScore <= 0.55))
            {
                LetterGrade = "D-"; 
                
            } else if((CoursePercentageScore > 0 )&&(CoursePercentageScore <= 0.50))
            {
                LetterGrade = "F"; 
            }

        //write the scores in by replaceing with specified course
        PrintWriter writer = new PrintWriter(new FileWriter(ID_Choice +".txt", true));
    //the writing back to the file agent / loop         
    //QuizPercentScore
    //MidtermPercentScore
    //FinalPercentScore
    //overall grade LetterGrade




}
    }

}

