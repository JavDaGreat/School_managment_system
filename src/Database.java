import java.util.*;
import java.util.stream.Collectors;

public class Database {

    private List<Student> studentList = new ArrayList<>();
    private List<Course> courseList = new ArrayList<>();

    public Database() {
        initiateStudents(studentList);
        initiateCourses(courseList);
    }


    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void initiateStudents(List<Student> studentList) {

        studentList.add(new Student(1, "Alex", 20, 2.1));
        studentList.add(new Student(2, "Ben", 22, 3.5));
        studentList.add(new Student(3, "Clara", 19, 3.8));
        studentList.add(new Student(4, "David", 21, 2.9));
        studentList.add(new Student(5, "Eva", 23, 3.7));
        studentList.add(new Student(6, "Frank", 20, 2.5));
        studentList.add(new Student(7, "Grace", 22, 3.2));
        studentList.add(new Student(8, "Henry", 18, 3.9));
        studentList.add(new Student(9, "Ivy", 24, 3.4));
        studentList.add(new Student(10, "Jack", 20, 2.8));
        studentList.add(new Student(11, "Lily", 21, 3.6));
    }


    public void initiateCourses(List<Course> courseList) {
        courseList.add(new Course(101, "Introduction to Java", "Dr. Smith", 3, List.of("David","Eva","Ivy")));
        courseList.add(new Course(102, "Data Structures", "Prof. Johnson", 4, List.of("Henry","Frank","Grace")));
        courseList.add(new Course(103, "Web Development", "Dr. Brown", 3, List.of("Lily","Jack","Ivy")));
        courseList.add(new Course(104, "Operating Systems", "Prof. Davis", 4, List.of("Ben","Eva","Clara")));
        courseList.add(new Course(105, "Database Management", "Dr. Miller", 3, List.of("Clara","Alex","Henry")));
        courseList.add(new Course(106, "Computer Networks", "Prof. Wilson", 3, List.of("David","Eva","Jack")));
        courseList.add(new Course(107, "AI Development", "Dr. Lee", 4, List.of("Henry","Alex","David")));
        courseList.add(new Course(108, "Software Engineering", "Prof. Taylor", 3, List.of("Jack","Ivy","Eva")));
        courseList.add(new Course(109, "Machine Learning", "Dr. Anderson", 4, List.of("David","Ben","Clara")));
        courseList.add(new Course(110, "Discrete Mathematics", "Prof. Thomas", 3, List.of("Ivy","Clara","Alex")));

    }


    public void createStudent(Student student) {
        studentList.add(student);
    }
    public void deleteStudent(int id){
        if (studentList.removeIf(student -> student.getStudentId() == id)){
            System.out.println("Student whit id : "+id+" has been removed");

        } else {
            System.out.println("The student dose not exist");
        }
    }

    public void putStudent(int id, String name, int age, double gpa) {
      boolean studentUpdate =  studentList.stream()
                .filter(student -> student.getStudentId() == id)
                .findFirst()
                .map(student -> {
                    student.setName(name);
                    student.setAge(age);
                    student.setGpa(gpa);
                    return true;
                }).orElse(false);
      if(!studentUpdate)
          System.out.println("No student with id: "+ id + " was found");
    }

}
