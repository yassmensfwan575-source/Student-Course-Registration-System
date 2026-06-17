
package StudentCourseRegistrationSystem;

public class Course {
   final private String id;
   final private int creditHrs;
   final private int maxClassSize;
   private String name;
   private int classSize;
   private int totalNumOfStudentRegistered;
   private int totalNumOfStudentWaiting;

    
   public Course(String name,String id,int creditHrs, int maxClassSize){
       this.name=name;
       this.id=id;
       this.creditHrs=creditHrs;
       this.maxClassSize=maxClassSize;
   }

    public String getId() {
        return id;
    }

    public int getCreditHrs() {
        return creditHrs;
    }

    public int getMaxClassSize() {
        return maxClassSize;
    }

    public String getName() {
        return name;
    }

    public int getClassSize() {
        return classSize;
    }

    public int getTotalNumOfStudentWaiting() {
        return totalNumOfStudentWaiting;
    }
     
    public void dataUpdate(int index){
        if(index==0){
            this.totalNumOfStudentRegistered++;
            this.classSize++;
        }else{
            this.classSize--;
            this.totalNumOfStudentRegistered--;
        }
         
    }
    
    
    
    public void studentWaitingDataUpdate(int index){
        if(index==0){
             this.totalNumOfStudentWaiting++;
        }else{
             this.totalNumOfStudentWaiting--;
        }
       
    }
    
    
    public int getTotalNumOfStudentRegistered() {
        return totalNumOfStudentRegistered;
    }

    public String toString() {
        return  "course name: " +this.name + "\ncourse id: " +this.id +"\ncourse credit hours: "+ this.creditHrs+"h " + "\ncourse maximum Class Size: " + this.maxClassSize;
    }
   
   
}
