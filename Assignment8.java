//   Assignment: ASU CSE205 Spring 2021 #8
//         Name: Saad Kadhi
//    StudentID: 1218676056
//      Lecture: TTH 9-10-15am
//  Description: The Assignment 8 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered. //---- is where you should add your own code

import java.io.*;
import java.util.Scanner;

public class Assignment8
{
    public static void main(String[] args)
    {
        char input1;
        String deptName, numOfFacultyStr, nameOfUniversity;
        String firstName, lastName, academicLevel;
        String university;
        int numOfFaculty;

        boolean operation = false;
        int operation2 = 0;
        String line;
        String filename;

        // create a DeptManagement object. This is used throughout this class.
        DeptManagement deptManage1 = new DeptManagement();

        File file;

        try {
            // print out the menu
            printMenu();

            // create a BufferedReader object to read input from a keyboard
            InputStreamReader isr = new InputStreamReader(System.in );
            BufferedReader stdin = new BufferedReader(isr);

            do {
                System.out.print("\nWhat action would you like to perform?\n");
                line = stdin.readLine().trim(); //read a line
                input1 = line.charAt(0);
                input1 = Character.toUpperCase(input1);

                if (line.length() == 1) //check if a user entered only one character
                {
                    switch (input1) {
                        case 'A':
                            //Add Department
                            System.out.print("Please enter the department information:\n");
                            System.out.print("Enter department name:\n");
                            deptName = stdin.readLine().trim();
                            System.out.print("Enter number of faculty:\n");
                            numOfFacultyStr = stdin.readLine().trim();
                            numOfFaculty = Integer.parseInt(numOfFacultyStr);
                            System.out.print("Enter university name:\n");
                            nameOfUniversity = stdin.readLine().trim();
                            System.out.print("Enter faculty first name:\n");
                            firstName = stdin.readLine().trim();
                            System.out.print("Enter faculty last name:\n");
                            lastName = stdin.readLine().trim();
                            System.out.print("Enter faculty academic level:\n");
                            academicLevel = stdin.readLine().trim();
                            /************************************************************************************
                             ***  Complete the follwing statement, if the department is added successfully, show
                             "Department added\n" on screen, otherwise show "Department NOT added\n"
                             ***********************************************************************************/

                            boolean added = deptManage1.addDepartment(deptName, nameOfUniversity, numOfFaculty, firstName, lastName, academicLevel);
                            if(added) {
                                System.out.print("Department added\n");
                            }else {
                                System.out.print("Department NOT added\n");
                            }
                            break;
                        case 'C':
                            //Create a new department management
                            deptManage1 = new DeptManagement();
                            break;
                        //*****
                        case 'D':
                            //Search by department's name and the university
                            System.out.print("Please enter the department name to search:\n");
                            deptName = stdin.readLine().trim();
                            System.out.print("Please enter the university name to search:\n");
                            university = stdin.readLine().trim();
                            /************************************************************************************
                             ***  Complete the follwing statement, if the department with above name and university is found
                             show deptName + " at " + university + " is found\n"; otherwise show
                             deptName + " at " + university + " is NOT found\n"
                             ***********************************************************************************/
                            int deptIndex = (deptManage1.deptExists(deptName, university));
                            String s1;
                            if(!(deptIndex == -1)) {
                            s1 = deptName + " at " + university + " is found\n";
                            } else {
                                s1 = deptName + " at " + university + " is NOT found\n";
                            }
                            System.out.print(s1);
                            //----
                            break;
                        case 'E':
                            //Search faculty
                            System.out.print("Please enter the faculty first name to search:\n");
                            firstName = stdin.readLine().trim();
                            System.out.print("Please enter the faculty last name to search:\n");
                            lastName = stdin.readLine().trim();
                            System.out.print("Please enter the faculty academic level to search:\n");
                            academicLevel = stdin.readLine().trim();
                            /************************************************************************************
                             ***  Complete the following statement, if the department with its currentFaculty has above
                             first, last and academic info. is found, show "Faculty: " + firstName + " " + lastName + ", " + academicLevel + " is found\n"; otherwise show
                             "Faculty: " + firstName + " " + lastName + ", " + academicLevel + " is NOT found\n"
                             ***********************************************************************************/
                            int facultyIndex = deptManage1.facultyExists(firstName, lastName, academicLevel);
                            String s2;
                            if(!(facultyIndex == -1)) {
                            s2 = "Faculty: " + firstName + " " + lastName + ", " + academicLevel + " is found\n";
                            } else {
                            s2 = "Faculty: " + firstName + " " + lastName + ", " + academicLevel + " is NOT found\n";
                            }
                            System.out.print(s2);
                            //----
                            break;
                        case 'L':
                            //List departments
                            System.out.print("\n" + deptManage1.listDepartments() + "\n");
                            break;

                        case 'N':
                            /************************************************************************************
                             ***  Complete the follwing statement. Sort by department names in alphabetical order
                             ***********************************************************************************/
                            //----
                            deptManage1.sortByDepartmentName();
                            System.out.print("sorted by department names\n");
                            break;

                        case 'O':
                            /************************************************************************************
                             ***  Complete the follwing statement. Sort by faculty numbers in increasing order
                             ***********************************************************************************/
                            //----
                            deptManage1.sortByFacultyNumbers();
                            System.out.print("sorted by faculty numbers\n");
                            break;
                        case 'P':
                            /************************************************************************************
                             ***  Complete the follwing statement. Sort the current faculty in alphabetical order
                             ***********************************************************************************/
                            //----
                            deptManage1.sortByDeptFaculty();
                            System.out.print("sorted by current faculty name\n");
                            break;
                        case 'Q':
                            //Quit
                            break;
                        case 'R':
                            //Remove a department
                            System.out.print("Please enter the department name to remove:\n");
                            deptName = stdin.readLine().trim();
                            System.out.print("Please enter the university name to remove:\n");
                            university = stdin.readLine().trim();
                            /************************************************************************************
                             ***  Complete the follwing statement, if the department with above name and university is found
                             remove it. Show the relevant info. accordingly.
                             ***********************************************************************************/
                            boolean remove = deptManage1.removeDepartment(deptName, university);

                            //----
                            if (remove)
                                System.out.print(deptName + " at " + university + " is removed\n");
                            else
                                System.out.print(deptName + " at " + university + " is NOT removed\n");
                            break;
                        case 'T':
                            //Close DeptManagement
                            deptManage1.closeDeptManagement();
                            System.out.print("Department management system closed\n");
                            break;
                        case 'U':
                            //Write Text to a File
                            System.out.print("Please enter a file name that we will write to:\n");
                            filename = stdin.readLine().trim();
                            try {
                                /************************************************************************************
                                 ***  Complete the follwing statement, write above string inside the relevant file
                                 ***********************************************************************************/
                                System.out.print("Please enter a string to write inside the file:\n");
                                //writes string to file
                                String s3 = stdin.readLine().trim() + "\n";
                                FileWriter fw = new FileWriter(filename);
                                BufferedWriter bw = new BufferedWriter(fw);
                                PrintWriter out = new PrintWriter(bw);
                                out.print(s3);
                                out.close();
                                System.out.print(filename + " is written\n");
                                //----
                            }
                            catch(FileNotFoundException e) {
                                    System.out.print("Write string inside the file error\n");
                            }
                            break;
                        case 'V':
                            //Read Text from a File
                            System.out.print("Please enter a file name which we will read from:\n");
                            filename = stdin.readLine().trim();
                            try {
                                /************************************************************************************
                                 ***  Complete the follwing statement, read from above text file
                                 ***********************************************************************************/
                                FileReader fr = new FileReader(filename);
                                BufferedReader read = new BufferedReader(fr);
                                System.out.print(filename + " was read\n");

                                System.out.print("The first line of the file is:\n" + read.readLine() + "\n");
                                //----
                            }
                            catch(FileNotFoundException e) {
                                    System.out.print(filename + " not found error\n");
                    }
                            catch(IOException e) {
                            System.out.print("Read string from the file error\n");
                }
                break;
            case 'W':
                //Serialize DeptManagement to a File
                System.out.print("Please enter a file name which we will write to:\n");
                filename = stdin.readLine().trim();
                try {
                    /************************************************************************************
                     ***  Complete the follwing statement, write object deptManage1 inside the data file
                     ***********************************************************************************/
                    FileOutputStream fout = new FileOutputStream(new File(filename));
                    ObjectOutputStream oout = new ObjectOutputStream(fout);

                    oout.writeObject(deptManage1);
                    fout.close();
                    oout.close();


                    //----
                }
                catch(NotSerializableException e) {
                        System.out.print("Not serializable exception\n");
                }

                catch(IOException e) {
                        System.out.print("Data file written exception\n");
                }
                break;
					case 'X':
                            //Deserialize DeptManagement from a File
                            System.out.print("Please enter a file name which we will read from:\n");
                            filename = stdin.readLine().trim();
                            try {
                                /************************************************************************************
                                 ***  Complete the follwing statement, read object from the data file and save the object
                                 as deptManage1
                                 ***********************************************************************************/
                                FileInputStream fin = new FileInputStream(new File(filename));
                                ObjectInputStream oin = new ObjectInputStream(fin);

                                deptManage1 = (DeptManagement) oin.readObject();

                                System.out.print(filename + " was read\n");

                                fin.close();
                                oin.close();

                                //----
                            }
                            //catches multiples exceptions relating to file reading
                            catch(ClassNotFoundException e) {
                                    System.out.print("Class not found exception\n");
                            }

                            catch(NotSerializableException e) {
                                    System.out.print("Not serializable exception\n");
                            }
                            catch(IOException e) {
                                    System.out.print("Data file read exception\n");
                            }
						    break;
						case '?':
						    //Display Menu
                            printMenu();
                            break;
                        default:
                            System.out.print("Unknown action\n");
                            break;


                    }
                    }
                else {
                System.out.print("Unknown action\n");

                }


            }
         while ( input1 != 'Q' || line . length () != 1);

        }
        catch(IOException exception) {
        System.out.print("IO Exception\n");
        }
    }


/** The method printMenu displays the menu to a user **/
public static void printMenu() {
        System.out.print("Choice\t\tAction\n" +
        "------\t\t------\n" +
        "A\t\tAdd a department\n" +
        "C\t\tCreate a DeptManagement\n" +
        "D\t\tSearch a department\n" +
        "E\t\tSearch a faculty\n" +
        "L\t\tList departments\n" +
        "N\t\tSort by department names\n" +
        "O\t\tSort by department faculty numbers\n" +
        "P\t\tSort by current faculty name\n" +
        "Q\t\tQuit\n" +
        "R\t\tRemove a department\n" +
        "T\t\tClose DeptManagement\n" +
        "U\t\tWrite strings to a text file\n" +
        "V\t\tRead strings from a text file\n" +
        "W\t\tSerialize DeptManagement to a data file\n" +
        "X\t\tDeserialize DeptManagement from a data file\n" +
        "?\t\tDisplay Help\n");
        }
}

