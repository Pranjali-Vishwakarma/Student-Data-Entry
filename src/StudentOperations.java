import java.util.*;
import exceptions.*;
import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;
import exceptions.StudentNotFoundException;

public class StudentOperations {
    private final Map<Integer, Student> studentMap = new HashMap<>();

    // Add Student with validation
    public void addStudent(Scanner sc) {
        try {
            System.out.print("Enter Roll No: ");
            int rollNo = sc.nextInt();

            if (studentMap.containsKey(rollNo)) {
                throw new DuplicateRollNumberException("Student with this Roll No already exists.");
            }

            sc.nextLine(); // consume newline
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            if (!name.matches("[a-zA-Z ]+")) {
                throw new InvalidNameException("Name must contain only alphabets and spaces.");
            }

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            if (age < 5 || age > 100) {
                throw new InvalidAgeException("Age must be between 5 and 100.");
            }

            Student student = new Student(name, age, rollNo);
            studentMap.put(rollNo, student);
            System.out.println("Student added successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Try again.");
            sc.nextLine(); // clear buffer
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // View All Students
    public void viewAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            studentMap.values().forEach(System.out::println);
        }
    }

    // Search by Roll No
    public void searchStudent(Scanner sc) {
        System.out.print("Enter Roll No to search: ");
        int rollNo = sc.nextInt();

        try {
            if (!studentMap.containsKey(rollNo)) {
                throw new StudentNotFoundException("No student found with this Roll No.");
            }
            System.out.println(studentMap.get(rollNo));
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Delete by Roll No
    public void deleteStudent(Scanner sc) {
        System.out.print("Enter Roll No to delete: ");
        int rollNo = sc.nextInt();

        try {
            if (!studentMap.containsKey(rollNo)) {
                throw new StudentNotFoundException("No student found with this Roll No.");
            }
            studentMap.remove(rollNo);
            System.out.println("Student deleted successfully!");
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}