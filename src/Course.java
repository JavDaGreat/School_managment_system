import java.util.ArrayList;
import java.util.List;

public class Course {


    private int courseId;
    private String CourseName;
    private String instructor;
    private int credits;
    List<String> studentListCourse;




public Course(int courseId, String courseName, String instructor, int credits,List<String> studentListCourse) {
    this.courseId = courseId;
    CourseName = courseName;
    this.instructor = instructor;
    this.credits = credits;
    this.studentListCourse =studentListCourse;

    }

    @Override
    public String toString(){
        return String.format("Course: %-20s  ID: %-5d  Instruct: %-15s  Credit: %-5d Students: %-15s"
                , CourseName, courseId, instructor,credits,studentListCourse);


    }

}
