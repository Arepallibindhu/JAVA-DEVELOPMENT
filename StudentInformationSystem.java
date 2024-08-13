import java.util.ArrayList;
import java.util.Scanner;

// Class representing a student
class Student {
    private int id;
    private String name;
    private int age;
    private String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course;
    }
}

// Class representing the Student Information System
public class StudentInformationSystem {

    private ArrayList<Student> students = new ArrayList<>();
    private int currentId = 1;
    private Scanner scanner = new Scanner(System.in);

    // Method to add a new student
    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter student course: ");
        String course = scanner.nextLine();

        Student student = new Student(currentId++, name, age, course);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Method to view all students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Method to update a student
    public void updateStudent() {
        System.out.print("Enter the student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = findStudentById(id);
        if (student != null) {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new course: ");
            String course = scanner.nextLine();

            student.setName(name);
            student.setAge(age);
            student.setCourse(course);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method to delete a student
    public void deleteStudent() {
        System.out.print("Enter the student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Helper method to find a student by ID
    private Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Main menu
    public void showMenu() {
        while (true) {
            System.out.println("\nStudent Information System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentInformationSystem sis = new StudentInformationSystem();
        sis.showMenu();
    }
}
