/*this is what i have so far
- I need array names and varibales mainly
- a lot o stuff i have depends on that soooo :3
*/
//this is in Main
        public static void registerStudent(){
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

            StudentUniqueID+=UniqueID;
            UniqueID+=1;
            public static void AddStudentToCourse(){
                //ifdk how make file help
            }
            
        }
        public static void PrintStudents(){
            /*
            int counter=0 //need arrays 
            System.out.println("First name: "+nameArray[counter]);
            System.out.println("ID: "+idArray[counter]);
            counter+=1;

            */
        }
        public static void StudentStats(int FileDIsplayType) {
            //Read student file
            System.out.println("Full or short file (1 for full, 2 for short): ");
            if (FileDisplayType==0){
                /*
                System.out.println(
            } //I need the array names 
            else {
                System.out.println(
            }
                    */
        
                    
        
    
        }


//this is in student class
        public static void Grade(){
            StudentStats(1);
            System.out.println("Do you want to change a grade or input one in: ");
            String gradeOption=reader.nextLine();
            if (gradeOption=="Override"){
                System.out.println("What assignment grade do you want to override: ");
                //print options like 1=quiz or smth
                int assignmentType=reader.nextInt();
                System.out.println("What % do you want to change it to: ");
                int changePercent=reader.nextInt();
                //idk what the psuedocode wants me to do with the %
            if (gradeOption=="Normal Grade"){
                System.out.println("What assignment grade do you want to override: ");
                int assignmentType=reader.nextInt();
                //also the 1=quiz etc
                switch(assignmentType){
                    case 1:
                        //quiz
                        System.out.println("What grade did they get: ");
                        int quizScore=reader.nextInt();
                        break;
                    case 2:
                        //hw
                        System.out.println("What grade did they get: ");
                        int hwScore=reader.nextInt();
                        break;
                    case 3:
                        //midterm
                        System.out.println("What grade did they get: ");
                        int midtermScore=reader.nextInt();
                        break;
                    case 4:
                        //final
                        System.out.println("What grade did they get: ");
                        int finalScore=reader.nextInt();
                        break;
                    default:
                        System.out.println("That isn't a option, try again. ");
                        //goes back to the grade class and loops again 
                        //put the funtion/method in loop :3
                    }
                //update the files, CalculateGrade() and StudentStats()
                //idk to do on githubbbbbb
                            
                
                }
                
            }
            
        }

