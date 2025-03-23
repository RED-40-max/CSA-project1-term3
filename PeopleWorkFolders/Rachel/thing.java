import java.util.Scanner;

public class Main
{
   
   public static void Menu() { // method
      Scanner input = new Scanner(System.in);
      boolean inPortal = true; 
      while (inPortal) {
         System.out.println("Hi! Welcome to the Kude High School registration portal.\n Enter: \n (1) Register new student" 
         + "\n(2) Add student to course \n(3) See attendance \n(4) Update grades \n(5) Exit portal");
         int option = input.nextInt();
         switch (option) {
            case 1: // register new student
               while (true) {
                  printStudents();
                  System.out.println("Which student? Enter an ID, or 9 to exit.");
                  int ID = input.nextInt();
                  if (ID != 9) Student.registerStudent();
                  else break;
               }
               break;
               
            case 2: // add student to course
               while (true) {
                  printStudents();
                  System.out.println("Which student? Enter an ID, or 9 to exit.");
                  int ID = input.nextInt();
                  if (ID != 9) Student.addStudentToCourse();
                  else break;
               }
               break;
               
            case 3: // see attendance
               Student.showAttendance();
               System.out.println("Would you like to update the attendance? Enter 1 if yes, 2 if no.");
               int i = input.nextInt();
               if (i == yes) {
                  while (true) {
                     printStudents();
                     System.out.println("Which student? Enter an ID, or 9 to exit.");
                     int ID = input.nextInt();
                     if (ID != 9) Student.updateAttendance();
                     else break;
                  }
               }
               break;
               
            case 4: // update grades
               while (true) {
                  printStudents();
                  System.out.println("Which student? Enter an ID, or 9 to exit.");
                  int ID = input.nextInt();
                  if (ID != 9) {
                     Student.studentStats(ID); // idk if this is correct way to call it
                     Student.grade(ID);
                  }
                  else break;
               }
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
}

public class Student 
{
   // variables
   private int studentID;
   private int uniqueID = 1; // gives unique ID to each student
   private String firstName;
   private String lastName;
   private int gradYear; 
   private int[] overallAttendance;
   private String[] coursesEnrolled;
   
   // constructor
   public void registerStudent() {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter the student's first and last name:");
      this.firstName = input.next();
      this.lastName = input.next();
      System.out.println("Enter the student's year of graduation:");
      this.gradYear = input.next();
      System.out.println("Enter the student's total number of presents, tardies, and absences:");
      for (int i = 0; i < 3; i++) this.overallAttendance[i] = input.next();
      boolean Continue = true;
      while (Continue) {
         System.out.println("Enter the number of student's courses they are taking:");
         int numCourses = input.next();
         
         if (numCourses < 5) { // students can only take up to 4 courses a year
            for (int i = 0; i < numCourses; i++) {
               String course = input.next();
               if (!(course : this.coursesEnrolled)) coursesEnrolled[i] = course; 
               else {
                  System.out.println("You can't register for the same class more than once. Try again."); // if user registers for same class twice
                  this.coursesEnrolled = {}; // resets course list to none
                  break;
               }
                  
            }
         else {
            System.out.print("Students can only take up to 4 classes a year. ");
            }
         }
         if (this.coursesEnrolled.length == numCourses) Continue = false; // succesfully signed up for right courses
      }
   }
}
