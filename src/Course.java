import java.util.List;

public class Course {
    private int courseId;
    private String CourseName;
    private String instructor;
    private int credits;
    private List<Student> studentList;


    public Course(int courseId, List<Student> studentList, int credits, String instructor, String courseName) {
        this.courseId = courseId;
        this.studentList = studentList;
        this.credits = credits;
        this.instructor = instructor;
        CourseName = courseName;
    }
}
