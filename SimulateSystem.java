
package StudentCourseRegistrationSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class SimulateSystem {
   static private final StudentCourseRegistration system =new StudentCourseRegistration();
   static private final Scanner in = new Scanner(System.in);
    
    static private int menu(){
        System.out.println("====================================");
        System.out.println("********THE MENU********");
        System.out.println("1-List all student in the system.");
        System.out.println("2-List all courses in the system.");
        System.out.println("3-Register a student to a course.");
        System.out.println("4-Try register a student to a course.");
        System.out.println("5-Unregister a student from a course.");
        System.out.println("6-Exit");
        System.out.println("Enter your choice: ");
        int menuChoice= in.nextInt();
        System.out.println("-------------------------------------");
        return menuChoice;
    }
    
    static private void printList(ArrayList list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1)+":");
            System.out.println(".......................");
            System.out.println(list.get(i));
            System.out.println();
        }
    }
    
    static private void printStudentInfo(ArrayList<Student> list){
        System.out.println("Student informations:");
        System.out.println("ids:(registered courses no.),(registered credit Hrs no.)");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId()+": ("+list.get(i).getTotalNumRegisteredCourse()+")                "
                    + "          ("+list.get(i).getTotalRegisteredCreditHrs()+")");
        }
        System.out.println("==============================================================");
    }
    
    static private void printCourseInfo(ArrayList<Course> list){
         System.out.println("Courses informations:");
         System.out.println("ids: (registered students no.),(waiting list student no.)");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId()+": ("+list.get(i).getTotalNumOfStudentRegistered()+")            "
                    + "                ("+list.get(i).getTotalNumOfStudentWaiting()+")");
        }
        System.out.println("==============================================================");
    }
    
    static private void printWaitingListInfo(ArrayList<Registration> list){
        System.out.println("Waiting list informations:");
        System.out.println("Students name: (courses name)");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getStudent().getName()+": ("+list.get(i).getCourse().getName()+")");
        }
        System.out.println("==============================================================");
    }
    
    static public void main(String[] args) {
        while(true){
            int studentId;
            String courseId;
            switch(menu()){
                case 1:
                    System.out.println("**STUDENTS IN THE SYSTEM**");
                    printList(system.getStudents());
                    break;
                case 2:
                    System.out.println("**COURSES IN THE SYSTEM**");
                    printList(system.getCourses());
                    break;
                case 3:
                    System.out.println("PROVOIDE US WITH THE FOLLOWING: ");
                    System.out.print("Student Id: ");
                    studentId=in.nextInt();
                    System.out.print("Course Id: ");
                    in.nextLine();
                    courseId=in.nextLine();
                    System.out.println(system.addRegistration(studentId, courseId));
                    break;
                case 4:
                    System.out.println("PROVOIDE US WITH THE FOLLOWING: ");
                    System.out.print("Student Id: ");
                    studentId=in.nextInt();
                    System.out.print("Course Id: ");
                    in.nextLine();
                    courseId=in.nextLine();
                    System.out.println(system.registerOrWait(studentId, courseId));
                    break;
                case 5:
                    System.out.println("PROVOIDE US WITH THE FOLLOWING: ");
                    System.out.print("Student Id: ");
                    studentId=in.nextInt();
                    System.out.print("Course Id: ");
                    in.nextLine();
                    courseId=in.nextLine();
                    system.unregister(studentId, courseId);
                    break;
                case 6:
                    printStudentInfo(system.getStudents());
                    printCourseInfo(system.getCourses());
                    printWaitingListInfo(system.getWaitingList());
                    System.out.println("Exiting....");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!!");
                    System.out.println("Back to the menu....");
            }
        }
    }
}
