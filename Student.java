
package StudentCourseRegistrationSystem;

import java.util.ArrayList;

public class Student { 
    static final private int maxNumRegisteredCourse=7;
    static final private int maxRegisteredCreditHrs=42;
    final private int id;
    private final String name;
    private String standing;
    private int totalRegisteredCreditHrs;
    private int totalNumRegisteredCourse;
    private final ArrayList <Course> registeredCourse= new ArrayList();
    
    public Student(String name,int id){
        this.id=id;
        this.name=name;
       
    }

    public int getMaxNumRegisteredCourse() {
        return maxNumRegisteredCourse;
    }

    public int getMaxRegisteredCridetHrs() {
        return maxRegisteredCreditHrs;
    }
    
    public void setStanding(String standing) {
        this.standing = standing;
    } 

    public String getStanding() {
        return standing;
    }
 
    public int getId() {
        return id;
    }
    

    public String getName() {
        return name;
    }

    public int getTotalRegisteredCreditHrs() {
        return totalRegisteredCreditHrs;
    }

    public int getTotalNumRegisteredCourse() {
        return totalNumRegisteredCourse;
    }

   
    public String toString() {
        return  "student name: "+this.name +"\nstudent id: " + this.id + "\nstudent standing: " + this.standing;
    }
 
    
    public void dataUpdate(Course course,int index){//registeration happen
        if(index==0){
        this.totalRegisteredCreditHrs+=course.getCreditHrs();
        this.totalNumRegisteredCourse++;
        this.registeredCourse.add(course);
        }else{
            this.totalRegisteredCreditHrs-=course.getCreditHrs();
        this.totalNumRegisteredCourse--;
        this.registeredCourse.remove(course);
        }
    }
    
    
}
