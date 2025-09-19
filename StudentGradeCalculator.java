import java.util.*;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        int[] marks = new int[n];
        int total = 0;

        // Input marks with validation
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter marks for Subject " + (i + 1) + " (0-100): ");
                int m = sc.nextInt();
                if (m >= 0 && m <= 100) {
                    marks[i] = m;
                    total += m;
                    break;
                } else {
                    System.out.println("❌ Invalid marks! Please enter between 0-100.");
                }
            }
        }

        // Calculate average
        double average = (double) total / n;

        // Find highest and lowest
        int highest = Arrays.stream(marks).max().getAsInt();
        int lowest = Arrays.stream(marks).min().getAsInt();

        // Determine grade
        String grade;
        if (average >= 90) grade = "A";
        else if (average >= 75) grade = "B";
        else if (average >= 60) grade = "C";
        else if (average >= 40) grade = "D";
        else grade = "F";

        // Display report
        System.out.println("\n📘 Student Report Card");
        System.out.println("----------------------------");
        System.out.println("Name          : " + name);
        System.out.println("Total Marks   : " + total + " / " + (n * 100));
        System.out.printf("Average Marks : %.2f\n", average);
        System.out.println("Highest Marks : " + highest);
        System.out.println("Lowest Marks  : " + lowest);
        System.out.println("Final Grade   : " + grade);
        System.out.println("Result        : " + (average >= 40 ? "PASS ✅" : "FAIL ❌"));

        sc.close();
    }
}
