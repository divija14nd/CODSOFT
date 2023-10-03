/**
 * 
 */
package codsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 */
public class CourseRegistrationSystem {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        System.out.println("----------------------------------");
    	System.out.println("STUDENT COURSE REGISTRATION SYSTEM");
    	System.out.println("----------------------------------");

    	
        while (true) {
        	System.out.println("\nMENU:");
        	System.out.println("-----");
            System.out.println("1. Add a Course");
            System.out.println("2. Register a Student");
            System.out.println("3. View Course List");
            System.out.println("4. Register a Student for a Course");
            System.out.println("5. Drop a Course for a Student");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter Course Code: ");
                    String courseCode = scanner.next();
                    System.out.print("Enter Course Title: ");
                    String courseTitle = scanner.next();
                    System.out.print("Enter Course Description: ");
                    String courseDescription = scanner.next();
                    System.out.print("Enter Course Capacity: ");
                    int courseCapacity = scanner.nextInt();
                    Course newCourse = new Course(courseCode, courseTitle, courseDescription, courseCapacity);
                    courses.add(newCourse);
                    break;

                case 2:
                    System.out.print("\nEnter Student ID: ");
                    String studentID = scanner.next();
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.next();
                    Student newStudent = new Student(studentID, studentName);
                    students.add(newStudent);
                    break;

                case 3:
                    System.out.println("\nCourse List:");
                    for (Course course : courses) {
                        System.out.println(course.toString());
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.print("\nEnter Student ID: ");
                    String stuID = scanner.next();
                    System.out.print("Enter Course Code: ");
                    String code = scanner.next();
                    Student studentToRegister = null;
                    Course courseToRegister = null;
                    for (Student student : students) {
                        if (student.getStudentID().equals(stuID)) {
                            studentToRegister = student;
                            break;
                        }
                    }
                    for (Course course : courses) {
                        if (course.getCode().equals(code)) {
                            courseToRegister = course;
                            break;
                        }
                    }
                    if (studentToRegister != null && courseToRegister != null) {
                        studentToRegister.registerCourse(courseToRegister);
                        System.out.println("Student " + studentToRegister.getName() + " has been registered for course " +
                                courseToRegister.getTitle());
                    } else {
                        System.out.println("Student or course not found.");
                    }
                    break;

                case 5:
                    System.out.print("\nEnter Student ID: ");
                    String studentIDForDrop = scanner.next();
                    System.out.print("Enter Course Code: ");
                    String courseCodeForDrop = scanner.next();
                    Student studentToDrop = null;
                    Course courseToDrop = null;
                    for (Student student : students) {
                        if (student.getStudentID().equals(studentIDForDrop)) {
                            studentToDrop = student;
                            break;
                        }
                    }
                    for (Course course : courses) {
                        if (course.getCode().equals(courseCodeForDrop)) {
                            courseToDrop = course;
                            break;
                        }
                    }
                    if (studentToDrop != null && courseToDrop != null) {
                        studentToDrop.dropCourse(courseToDrop);
                        System.out.println("Student " + studentToDrop.getName() + " has dropped course " +
                                courseToDrop.getTitle());
                    } else {
                        System.out.println("Student or course not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}