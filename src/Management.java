public class Management {
   Database data = new Database();


    public Management(){

    }


    public void printStudentList(){
        data.getStudentList().forEach(System.out::println);

    }
    public void printCourseList(){
        data.getCourseList().forEach(System.out::println);

    }

    public void addStudent(String name , int age , double gpa){
        data.createStudent(new Student(data.getStudentList().size()+1,name,age,gpa));
    }

    public void removeStudent (int id){
        data.deleteStudent(id);
    }

    public void updateStudent (int id,String name , int age, double gpa){
        data.putStudent(id,name,age,gpa);
    }

    public void addToNewCourse (int courseId,String name){
        data.addToCourse(courseId,name);

    }
    public void removeStudentFromCourse(String name,int courseId){

        data.removeFromCourse(name,courseId);
    }

    public void sortByCredit (){
        data.sortCoursesByCredit();
    }
    public void sortByStudents (){
        data.sortCoursesByAttendance();
    }

    public void sortStudentsbugpda (){
        data.sortStudentByPga();
    }



}
