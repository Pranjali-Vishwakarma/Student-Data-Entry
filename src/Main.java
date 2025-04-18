/*
Name: Pranjali Vishwakarma
PRN: 1234567890
Batch: XYZ
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentOperations operations = new StudentOperations();

        System.out.println("----- Welcome to Student Data Entry System -----");

        while (true) {
            System.out.println("\n1. Add Student\n2. View All Students\n3. Search Student by Roll No");
            System.out.println("4. Delete Student\n5. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    operations.addStudent(sc);
                    break;
                case 2:
                    operations.viewAllStudents();
                    break;
                case 3:
                    operations.searchStudent(sc);
                    break;
                case 4:
                    operations.deleteStudent(sc);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
