public class Student {
    private int studentId;


    private String name;
    private int age;
    private double gpa;


    public Student(int studentId, String name, int age, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("Name: %-10s  ID: %-5d  Age: %-3d GPA: %-3.1f", name, studentId, age, gpa);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
