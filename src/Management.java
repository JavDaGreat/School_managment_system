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


}
