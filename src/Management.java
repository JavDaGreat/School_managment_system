import java.util.Scanner;

public class Management {
    Database data = new Database();


    public Management() {
        service();

    }


    public void service() {

        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                displayMenu();
                int option = input.nextInt();
                switch (option) {
                    case 1: {
                        System.out.println("1 to print Student List or 2 for Course List");
                        int option1 = input.nextInt();
                        printList(option1);
                        break;

                    }
                    case 2: {
                        System.out.println("1 to sort list by credit or 2 by Attenders or 3 to sort students by GPA ");
                        int option1 = input.nextInt();
                        sortCourse(option1);
                        break;

                    }
                    case 3: {
                        System.out.println("1 for add student 2 for delete student 3 for update student");
                        int option1 = input.nextInt();
                        input.nextLine();
                        if (option1 == 2) {
                            System.out.println("Please entre Id");
                            int id = input.nextInt();
                            studentOperation(option1, "", id, 0, 0);
                            break;
                        }
                        if (option1 == 1) {
                            System.out.println("Please entre name");
                            String name = input.nextLine();
                            System.out.println("Please entre age");
                            int age = input.nextInt();
                            input.nextLine();
                            System.out.println("Please entre GPA");
                            double gpa = input.nextDouble();
                            studentOperation(option1, name, 0, age, gpa);
                            break;
                        }
                        if (option1 == 3) {
                            System.out.println("Please entre name");
                            String name = input.nextLine();
                            System.out.println("Please entre age");
                            int age = input.nextInt();
                            input.nextLine();
                            System.out.println("Please entre GPA");
                            double gpa = input.nextDouble();
                            int id = input.nextInt();
                            studentOperation(option1, name, id, age, gpa);
                            break;
                        }

                        break;
                    }
                    case 4: {
                        System.out.println("1 for add student to course 2 for delete student from the course");
                        int option1 = input.nextInt();
                        input.nextLine();
                        System.out.println("Please entre name");
                        String name = input.nextLine();
                        System.out.println("Please entre courseId");
                        int courseId = input.nextInt();
                        courseOperation(option1, courseId, name);
                        break;
                    }
                    case 5: {
                        return;
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("An error Occurred" + e.getMessage());
        }

    }

    public void printList(int option) {
        if (option == 1) data.getStudentList().forEach(System.out::println);
        else if (option == 2) data.getCourseList().forEach(System.out::println);

    }


    public void studentOperation(int option, String name, int id, int age, double gpa) {
        if (option == 1)
            data.createStudent(
                    new Student(data.getStudentList().size() + 1, name, age, gpa));
        else if (option == 2) data.deleteStudent(id);
        else if (option == 3) data.putStudent(id, name, age, gpa);

    }


    public void courseOperation(int option, int courseId, String name) {
        if (option == 1) data.addToCourse(courseId, name);
        else if (option == 2) data.removeFromCourse(name, courseId);

    }


    public void sortCourse(int option) {
        if (option == 1) data.sortCoursesByCredit();
        else if (option == 2) data.sortCoursesByAttendance();
        else if (option == 3) data.sortStudentByGpa();

    }


    public void displayMenu() {
        System.out.println("""
                Welcome to School Management System
                Please select a number between 1-5:
                1. Print Lists
                2. Sort Lists
                3. Student related operation
                4. Course related operation
                5. To Exit
                """);

    }


}
