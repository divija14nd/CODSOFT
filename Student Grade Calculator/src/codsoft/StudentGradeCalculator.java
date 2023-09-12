/**
 * Task 2: Student Grade Calculator
 */
package codsoft;

import java.util.Scanner;

public class StudentGradeCalculator {

      
	public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
    
            // Input: Take marks obtained in each subject
            System.out.print("Enter the number of subjects: ");
            
            int numSubjects = scanner.nextInt();
            int[] marks = new int[numSubjects];
    
            System.out.print("\n");
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();
            }
    
            // Calculate Total Marks
            int totalMarks = calculateTotalMarks(marks);
    
            // Calculate Average Percentage
            double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);
    
            // Grade Calculation
            char grade = calculateGrade(averagePercentage);
    
            // Display Results
            displayResults(totalMarks, averagePercentage, grade);
    
            scanner.close();
        }
    
        // Method to calculate Total Marks
        public static int calculateTotalMarks(int[] marks) {
            int total = 0;
            for (int mark : marks) {
                total += mark;
            }
            return total;
        }
    
        // Method to calculate Average Percentage
        public static double calculateAveragePercentage(int totalMarks, int numSubjects) {
            return (double) totalMarks / numSubjects;
        }
    
        // Method to calculate Grade
        public static char calculateGrade(double averagePercentage) {
            if (averagePercentage >= 90) {
                return 'A';
            } else if (averagePercentage >= 75) {
                return 'B';
            } else if (averagePercentage >= 65) {
                return 'C';
            } else if (averagePercentage >= 55) {
                return 'D';
            } else {
                return 'F';
            }
        }
    
        // Method to display Results
        public static void displayResults(int totalMarks, double averagePercentage, char grade) {
            double roundedAveragePercentage = Math.round(averagePercentage * 100.0) / 100.0;

            System.out.println("\nTotal Marks: " + totalMarks);
            System.out.println("Average Percentage: " + roundedAveragePercentage + "%");
            System.out.println("Grade: " + grade);
    }
}






	



