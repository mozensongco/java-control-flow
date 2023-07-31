package controlFlow;

import java.util.Scanner;

import java.text.DecimalFormat;


public class GradeCalculator {
	
	// I wanted to find a way to convert the grades at the end to have 2 decimal places, and this is what I found.
	private static final DecimalFormat df = new DecimalFormat("0.00");

	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		double totalSum = 0;
		int gradesCount = 0;
		
		System.out.println("Enter a grade, or a negative number if you're out of grades.");
		
		double numToAdd = Double.parseDouble(input.nextLine());
		
		// Handles the case where a negative number is the first input.
		// Eclipse kept yelling at me about not closing the scanner (it would still compile, though), so I included that in my code.
		if (numToAdd < 0) {
			System.out.println("Come back whenever you have grades to input! Have a nice day!");
			input.close();
			return;
		}
		
		while(numToAdd >= 0) {
			
			if (numToAdd > 100) {
				System.out.println("Sorry... this GradeCalculator works with the American 100-point grading system.");
				System.out.println("Please enter a number within the 0-100 range, inclusive (or a negative number to stop entering grades).");
			} else {
				gradesCount++;
				System.out.printf("Grade received! You've entered %d grade(s) so far.\n", gradesCount);
				
				totalSum += numToAdd;
				System.out.printf("Your current total is %f.\n", totalSum);
	
				System.out.println("Enter another grade (or a negative number to start the calculations).");
			}
			numToAdd = Double.parseDouble(input.nextLine());
		}
				
		double gradeAvg = totalSum / gradesCount;
		
		// Handles the case where at least one number greater than 100 is inputted, followed by a negative number.
		// Since neither totalSum nor gradesCount are updated, both are still equal to 0, and gradeAvg is evaluated as 0 / 0, or NaN.
		// I'm not actually sure if isNaN() is only available for Double objects, but I couldn't find any for Float objects?
		if (Double.isNaN(gradeAvg)) {
			System.out.println("I'm sorry this GradeCalculator won't work for your set of grades, but I hope you have a nice day!");
			input.close();
			return;
		}
		
		System.out.println("Calculating...");
		System.out.println("...");
		System.out.printf("Your average, based on %d grades, was a(n) %s. ", gradesCount, df.format(gradeAvg));
		
		if (gradeAvg > 90) {
			System.out.println("Excellent work!");
		} else if (gradeAvg > 80) {
			System.out.println("Good job!");
		} else if (gradeAvg > 70) {
			System.out.println("Keep it up!");
		} else {
			System.out.println("Let's work hard to get those grades up!");
		}
		
		input.close();
		System.out.println("That's all for now, folks!");
	}
}
