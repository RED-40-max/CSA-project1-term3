
import java.util.Scanner; 
import java.io.*; 

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
            String NameLine ;
            while(FileScan.hasNext()) //reads entire file
            {
                if () 
                {
                    NameLine =  FileScan.nextLine();
                    break;  //exits from the loop once it's found the name  
                }

            }



        //prints out student's name process
        System.out.println("Student Name: ": + ); //prints out student's name
            
        //prints out student's ID process
            //first find the student ID thorught a loop, finding name: and making substrig to later print


        System.out.println("Student ID: " + ); //prints out student's ID
        System.out.println("is this the intended Student? (press any key or type \"no\"): "); 
        String UserConfermation = reader.next(); //reads and stores user answer 
            if (UserConfermation == "no") //if it's wrong then try again
            {
                AddStudentToCourse(); //try again 
            } 

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
        int Course_Choice = reader.nextInt(); //reads in the Choice
        
    //checks if student is in course   
        boolean IsStudentNotInCourse = true; //asssumes that student is not in course 
        Scanner FileScan; //sets up file scanner
        FileScan = new Scanner(new File(ID_Choice + ".txt")); //reads in the specified document 
        while(FileScan.hasNext()) //reads file 
        {
            //trys to find string 
            //find the line of courses - and make a string out of it, if it is the course, then error, otherewise just add it in


        }


        
       

    


    }

    public static void CalculateGrade()
    {
        
    }

}

