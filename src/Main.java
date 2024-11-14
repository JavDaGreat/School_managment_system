public class Main {
    public static void main (String[] args){

      var management = new Management();
      management.addStudent("Javad",23,2.5);

        management.printStudentList();
        management.removeStudent(12);
        management.printStudentList();
        management.addStudent("Javad",23,2.5);
        management.updateStudent(12,"Js",12,3);
        management.printStudentList();






    }
}
