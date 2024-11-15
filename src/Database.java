import java.io.FileWriter;
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
        courseList.add(new Course(101, "Introduction to Java", "Dr. Smith", 1, new ArrayList<>(List.of("David", "Eva", "Ivy", "Henry", "Frank", "Grace"))));
        courseList.add(new Course(102, "Data Structures", "Prof. Johnson", 4, new ArrayList<>(List.of("Henry", "Frank", "Grace"))));
        courseList.add(new Course(103, "Web Development", "Dr. Brown", 2, new ArrayList<>(List.of("Lily", "Jack"))));
        courseList.add(new Course(104, "Operating Systems", "Prof. Davis", 4, new ArrayList<>(List.of("Ben", "Eva", "Clara"))));
        courseList.add(new Course(105, "Database Management", "Dr. Miller", 2, new ArrayList<>(List.of("Clara", "Alex", "Henry", "Jack"))));
        courseList.add(new Course(106, "Computer Networks", "Prof. Wilson", 3, new ArrayList<>(List.of("David"))));
        courseList.add(new Course(107, "AI Development", "Dr. Lee", 4, new ArrayList<>(List.of("Henry"))));
        courseList.add(new Course(108, "Software Engineering", "Prof. Taylor", 3, new ArrayList<>(List.of("Jack", "Ivy", "Eva", "Clara", "David"))));
        courseList.add(new Course(109, "Machine Learning", "Dr. Anderson", 4, new ArrayList<>(List.of("David", "Ben", "Clara", "Alex"))));
        courseList.add(new Course(110, "Discrete Mathematics", "Prof. Thomas", 5, new ArrayList<>(List.of("Ivy", "Clara"))));

    }

    public int findCourseById(int id) {
        int index = -1;
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseId() == id) {
                index = i;
            }
        }
        return index;

    }

    public void addToCourse(int courseId, String name) {
        Student foundedStudent = studentList.stream().
                filter(student -> student.getName().equals(name)).findFirst().orElse(null);
        if (foundedStudent == null) {
            System.out.println("Student doesn't exist");
            return;
        }
        var index = findCourseById(courseId);
        courseList.get(index).setStudentListCourse(name);
        System.out.println(name + " has been added to " + courseList.get(index).getCourseName());
    }

    public void removeFromCourse(String name, int courseId) {
        Student foundedStudent = studentList.stream().
                filter(student -> student.getName().equals(name)).findFirst().orElse(null);
        if (foundedStudent == null) {
            System.out.println("Student doesn't exist");
            return;
        }
        var index = findCourseById(courseId);
        courseList.get(index).studentListCourse.removeIf(list -> list.equals(name));
        System.out.println(
                "student " + foundedStudent.getName() + " is removed from course "
                        + courseList.get(index).getCourseName());

    }


    public void createStudent(Student student) {
        studentList.add(student);
        System.out.println("Student : " + student.getName() + " added successfully");
    }

    public void deleteStudent(int id) {
        if (studentList.removeIf(student -> student.getStudentId() == id)) {
            System.out.println("Student whit id : " + id + " has been removed");

        } else {
            System.out.println("The student dose not exist");
        }
    }

    public void putStudent(int id, String name, int age, double gpa) {
        boolean studentUpdate = studentList.stream()
                .filter(student -> student.getStudentId() == id)
                .findFirst()
                .map(student -> {
                    student.setName(name);
                    student.setAge(age);
                    student.setGpa(gpa);
                    System.out.println("User updated");
                    return true;
                }).orElse(false);
        if (!studentUpdate)
            System.out.println("No student with id: " + id + " was found");
    }


    public void sortCoursesByCredit() {
        courseList.stream().sorted(Comparator.comparingInt(Course::getCredits)).
                forEach(System.out::println);

    }

    public void sortCoursesByAttendance() {
        courseList.stream().sorted
                        (Comparator.comparingInt(course -> course.getStudentListCourse().size()))
                .forEach(System.out::println);

    }

    public void sortStudentByGpa() {
        studentList.stream().
                sorted(Comparator.comparing(Student::getGpa)).forEach(System.out::println);
    }
}
