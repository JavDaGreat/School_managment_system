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
    public String toString(){
        return String.format("Name: %-10s  ID: %-5d  Age: %-3d", name, studentId, age);

    }
}
