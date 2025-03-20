import java.util.Scanner;

public class MarksCalculator {

    // Method to calculate total marks, average percentage, and grade
    public static void calculateResults(int numSubjects) {
        Scanner scanner = new Scanner(System.in);
        
        // Step 1: Take marks as input
        int totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks for subject " + i + " (out of 100): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear the invalid input
                System.out.print("Enter marks for subject " + i + " (out of 100): ");
            }
            int marks = scanner.nextInt();
            // Ensure marks are within the valid range
            if (marks < 0 || marks > 100) {
                System.out.println("Marks must be between 0 and 100. Please re-enter the marks.");
                i--; // Repeat the loop for this subject
                continue;
            }
            totalMarks += marks;
        }
        
        // Step 2: Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;
        
        // Step 3: Calculate grade based on average percentage
        String grade = "";
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 75) {
            grade = "B";
        } else if (averagePercentage >= 50) {
            grade = "C";
        } else if (averagePercentage >= 35) {
            grade = "D";
        } else {
            grade = "F";
        }
        
        // Step 4: Display the results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks + "/" + (numSubjects * 100));
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        // Step 5: Ask for the number of subjects
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number of subjects.");
            scanner.next(); // Clear the invalid input
            System.out.print("Enter the number of subjects: ");
        }
        int numSubjects = scanner.nextInt();
        
        // Call the method to calculate and display results
        calculateResults(numSubjects);
    }
}
