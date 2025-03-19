
import java.io.IOException;
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
    //checks if student is in course   

        
       

    


    }

    public static void CalculateGrade()
    {
        
    }

}

