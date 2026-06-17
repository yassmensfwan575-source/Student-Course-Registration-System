
package StudentCourseRegistrationSystem;

import java.util.ArrayList;

public class StudentCourseRegistration {

    //each system have one final list no one can cahnge it 
    private final ArrayList<Registration> registration = new ArrayList<>();
    private final ArrayList<Registration> waitingList = new ArrayList<>();
    private final ArrayList<Student> students = new ArrayList<>();
    private final ArrayList<Course> courses = new ArrayList<>();

    public StudentCourseRegistration() {
        this.populateStudents();
        this.pupulateCourses();
    }

    private void populateStudents() {//static?
        students.add(new Student("Hasan Hasan", 10));
        students.get(0).setStanding("Freshmen");
        students.add(new Student("Ahmed Mehmet", 11));
        students.get(1).setStanding("Sophomore");
        students.add(new Student("Hasan Huseyin", 22));
        students.get(2).setStanding("Junior");
        students.add(new Student("Ayse Fatma", 13));
        students.get(3).setStanding("Senior");
        students.add(new Student("Kazim Kazim", 9));
        students.get(4).setStanding("Freshmen");
        students.add(new Student("Lale Ceren", 123));
        students.get(5).setStanding("Sophomore");
        students.add(new Student("Hale Jale", 666));
        students.get(6).setStanding("Junior");
        students.add(new Student("Obladi Oblade", 4004));
        students.get(7).setStanding("Senior");
        students.add(new Student("Selen Seren", 42));
        students.get(8).setStanding("Freshmen");
        students.add(new Student("Mustafa Keser", 2459));
        students.get(9).setStanding("Sophomore");
        students.add(new Student("Sude Cansu", 7));
        students.get(10).setStanding("Junior");

    }

    private void pupulateCourses() {//static?
        courses.add(new Course("programming", "cs0", 1, 2));
        courses.add(new Course("Mathematics", "ee2", 2, 2));
        courses.add(new Course("Software", "cs1", 1, 2));
        courses.add(new Course("Circuits", "ee3", 3, 3));
        courses.add(new Course("Underwater Voleyball", "uw1", 1, 3));
        courses.add(new Course("Principles of Life", "pol7", 4, 616));
        courses.add(new Course("Critical Thiking", "all", 42, 42));
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Registration> getWaitingList() {
        return waitingList;
    }
    private Student studentIdCheck(int studentId) {
        for (int i = 0; i < this.students.size(); i++) {
            Student s = this.students.get(i);
            if (s.getId() == studentId) {
                return s;
            }
        }
        return null;//not found
        

    }

    private Course courseIdCheck(String courseId) {
        for (int i = 0; i < this.courses.size(); i++) {
            Course c = this.courses.get(i);
            if (c.getId().equals(courseId)) {
                return c;
            }
        }
        return null;//not found
    }

    private Registration registrationCheck(Student s, Course c) {
        for (int i = 0; i < this.registration.size(); i++) {
            Registration r = this.registration.get(i);
            if (r.getStudent().getId() == s.getId() && r.getCourse().getId().equals(c.getId())) {
                return r;
            }
        }
        return null;//not found
    }

    //to find a certain registration in the waiting list
    private Registration waitingListCheck(Student s, Course c) {
        for (int i = 0; i < this.waitingList.size(); i++) {
            Registration r = this.waitingList.get(i);
            if (r.getStudent().getId() == s.getId() && r.getCourse().getId().equals(c.getId())) {
                return r;
            }
        }
        return null;//not found
    }

    //to find if there is any student in the waitinglist of a certain course
    private Registration waitingListCheck(Course c) {
        for (int i = 0; i < this.waitingList.size(); i++) {
            Registration pendingRegisteration = this.waitingList.get(i);
            if (pendingRegisteration.getCourse().getId().equals(c.getId())) {
                Student s = pendingRegisteration.getStudent();
                if (studentConditions(s, c) == null) {
                    return pendingRegisteration;
                } 
            }
        }
        return null;//not found
    }

    private String studentConditions(Student s, Course c) {
        if (s.getStanding().equals("Senior")) {
            if (s.getTotalNumRegisteredCourse() >= (s.getMaxNumRegisteredCourse() + 1)) {
                return "Exceeding maximum number of courses!!";          //maxhrs+(maxhrs+0.2)=maxhrs*1.2
            } else if (s.getTotalRegisteredCreditHrs() + c.getCreditHrs() > (s.getMaxRegisteredCridetHrs() * 1.2)) {
                return "Exceeding maximum coures hours!!";
            }
        } else {
            if (s.getTotalNumRegisteredCourse() >= s.getMaxNumRegisteredCourse()) {
                return "Exceeding maximum number of courses!!";
            } else if (s.getTotalRegisteredCreditHrs() + c.getCreditHrs() > s.getMaxRegisteredCridetHrs()) {
                return "Exceeding maximum coures hours!!";
            }
        }
        return null;//conditions met 
    }

    public String addRegistration(int studentId, String courseId) {
        Student s = studentIdCheck(studentId);
        if (s == null) {
            return "Unknown Student Id!!";
        }

        Course c = courseIdCheck(courseId);
        if (c == null) {
            return "Unkown Course Id!!";
        }

        //studentConditions
        if (studentConditions(s, c) != null) {
            return studentConditions(s, c);
        }

        //cousreConditions
        if (c.getClassSize() >= c.getMaxClassSize()) {
            return "Exceeeding maximum number of student!!";
        }
        //the registeration
        if (registrationCheck(s, c) != null) {
            return "Existing Registration!!";
        } else {
            Registration newRegistration = new Registration(s, c);
            newRegistration.addRegistration();//updating data 
            this.registration.add(newRegistration);
            return "Successfully Registered!!";
        }

    }

    public String registerOrWait(int studentId, String courseId) {
        Student s = studentIdCheck(studentId);
        if (s == null) {
            return "Unknown Student Id!!";
        }

        Course c = courseIdCheck(courseId);
        if (c == null) {
            return "Unknown Course Id!!";
        }
        if (registrationCheck(s, c) != null) {
            return "Existing Registration!!";
        } else {
            if (c.getClassSize() >= c.getMaxClassSize()) {
                for (int i = 0; i < this.waitingList.size(); i++) {
                    Registration r = this.waitingList.get(i);
                    if (r.getStudent().getId() == studentId && r.getCourse().getId().equals(courseId)) {
                        return "Already on waiting list!!";
                    }
                }

                if(studentConditions(s, c)==null){
                    Registration pendingRegistration = new Registration(s, c);
                    this.waitingList.add(pendingRegistration);
                    c.studentWaitingDataUpdate(0);//inc
                    return "Course is full. \nThe Registration have been added to the waiting list!! ";
                }
            }
            return (addRegistration(studentId, courseId));
        }
    }

    public void unregister(int studentId, String courseId) {
        Student s = studentIdCheck(studentId);
        if (s == null) {
            System.out.println("Unknown Student Id!!");
            return;
        }

        Course c = courseIdCheck(courseId);
        if (c == null) {
            System.out.println("Unknown Course Id!!");
            return;
        }

        Registration targetRegistration = registrationCheck(s, c);
        if (targetRegistration == null) {
            targetRegistration = waitingListCheck(s, c);
            if (targetRegistration == null) {
                System.out.println("No Registration found!!");
            } else {
                c.studentWaitingDataUpdate(1);//dec
                this.waitingList.remove(targetRegistration);
                System.out.println("Succesfully removed from waiting List..");
            }
        } else {
            targetRegistration.removeRegistration();
            this.registration.remove(targetRegistration);
            System.out.println("Succesfully unregitered..");
            Registration pendingRegistration = waitingListCheck(c);
            if (pendingRegistration != null) {//found , no need for cousreConditions check
                this.waitingList.remove(pendingRegistration);
                c.studentWaitingDataUpdate(1);
                addRegistration(pendingRegistration.getStudent().getId(), c.getId());
            }
        }

    }

}
