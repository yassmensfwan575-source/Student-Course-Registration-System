
package StudentCourseRegistrationSystem;

public class Registration { 
    final private Student student; 
    final private Course course;

    public Registration(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
    
    public void addRegistration(){//registeration happen
        this.course.dataUpdate(0);
        this.student.dataUpdate(course, 0);//inc
       
    }
    public void removeRegistration(){
        this.course.dataUpdate(1);
        this.student.dataUpdate(course,1);//dec
    }

    public Student getStudent() {
        return student; 
    }

    public Course getCourse() {
        return course;
    }
    
    
    
}
