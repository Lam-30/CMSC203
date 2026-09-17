/*
 * Class: CMSC203 22537
 * Instructor: Ahmed Tarek
 * Description: (Create a Grade Calculator for one student and one course. The program reads the course grading configurations and student scores from files, 
 * validates the information, calculates category averages and the overall weighted average, determines the student’s letter grade, 
 * allows the user to choose whether +/- grading is applied, and produced a summary report)
 * Due: 09/17/2026
 * Platform/compiler:
 * I pledge that I have completed the programming assignment 
  independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: __Luis Aguero________
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) 
	{
		String defaultCourse = "CMSC203 Computer Science I";
		int defaultCategories = 3;
		
		String defaultCategory1 = "Projects";
		int defaultWeight1 = 40;
		
		String defaultCategory2 = "Quizzes";
		int defaultWeight2 = 30;
		
		String defaultCategory3 = "Exams";
		int defaultWeight3 = 30;
		
		//Configuration variables.
		
		String courseName = "";
		int categoryCount = 0;
		
		String category1 = "";
		String category2 = "";
		String category3 = "";
		
		int weight1 = 0;
		int weight2 = 0;
		int weight3 = 0;
		
		boolean defaultUsed = false;
		boolean configValid = true;
		
		System.out.println("=============================================");
		System.out.println(" CMSC203 Project 1 - Grade Calculator");
		System.out.println("=============================================");
		System.out.println();
		
		System.out.println("Loading configuration from gradeconfig.txt ...");
		
		/*
		 * Read the configuration file.
		 */
		
		try 
		{
			File configFile = new File("gradeconfig.txt");
			Scanner configScanner = new Scanner(configFile);
			
		//Read course name.
		
			if(configScanner.hasNextLine()) 
			{
				courseName = configScanner.nextLine().trim();
				
				if(courseName.length() == 0) 
				{
					configValid = false;
				}
			} 
			
			else 
			{
				configValid = false;
			}
			
			//Read number of categories.
			
		if(configValid && configScanner.hasNextLine()) 
		{
				String categoryCountText = configScanner.nextLine().trim();
				
			try 
			{
				categoryCount = Integer.parseInt(categoryCountText);
				
				if(categoryCount < 1 || categoryCount > 3)
				{
					configValid = false;
				}
			}
			catch (NumberFormatException error) 
			{
				configValid = false;
			}
		}
		else 
			{
			configValid = false;
			}
			
		if(configValid && categoryCount >= 1) 
		{
			if (configScanner.hasNextLine()) 
			{
				String line = configScanner.nextLine().trim();
				Scanner lineScanner = new Scanner(line);
				
				if (lineScanner.hasNext()) 
				{
					category1 = lineScanner.next();
				}
				else 
				{
					configValid = false;
				}
			
				if(lineScanner.hasNext()) 
				{
				String weightText = lineScanner.next();
				
					try 
					{
						weight1 = Integer.parseInt(weightText);
					}
					catch (NumberFormatException error) 
					{
						configValid = false;
					}
		
				}
				else 
				{
				configValid = false;
				}
			
			lineScanner.close();
			}
			else 
			{
			configValid =false;
			}
		
		}
		
		if (configValid && categoryCount >= 2) 
		{
			if (configScanner.hasNextLine()) 
			{
				String line = configScanner.nextLine().trim();
				Scanner lineScanner = new Scanner(line);
				
				if(lineScanner.hasNext()) 
				{
					category2 = lineScanner.next();
				
				}
				else 
				{
				configValid = false;
				}
			
				if(lineScanner.hasNext()) 
				{
					String weightText = lineScanner.next();
				
					try 
					{
						weight2 = Integer.parseInt(weightText);
					}
					catch (NumberFormatException error) 
					{
					configValid = false;
					}
				}	
				else 
				{
				configValid = false;
				}
			
			lineScanner.close();
			}
			else 
			{
				configValid = false;
			}
		}
		if (configValid && categoryCount >=3) {
			if(configScanner.hasNextLine()) {
				String line = configScanner.nextLine().trim();
				Scanner lineScanner = new Scanner(line);
				
			if (lineScanner.hasNext()) {
				category3 = lineScanner.next();
			}else {
				configValid = false;
			}
			if (lineScanner.hasNext()) {
				String weightText = lineScanner.next();
				
				try {
					weight3 = Integer.parseInt(weightText);
				}catch (NumberFormatException e) {
					configValid = false;
				}
			}else {
				configValid = false;
			}
			
			lineScanner.close();
			}else {
				configValid = false;
			}
		}
		
		//Validates category weights.
		
		if(configValid) {
			int weightTotal = weight1 + weight2 + weight3;
			
			if(weight1 < 0 || weight2 < 0 || weight3 < 0 || weightTotal != 100) {
				configValid = false;
			}
		}
		
		configScanner.close();
		}catch (FileNotFoundException error) {
			configValid = false;
		}
		
		/*
		 * Uses the required default configuration if file is missing of invalid
		 */
		if (!configValid) {
			defaultUsed = true;
			
			courseName = defaultCourse;
			categoryCount = defaultCategories;
			
			category1 = defaultCategory1;
			weight1 = defaultWeight1;
			
			category2 = defaultCategory2;
			weight2 = defaultWeight2;
			
			category3 = defaultCategory3;
			weight3 = defaultWeight3;
			
			System.out.println("Configuration missing or invalid");
			System.out.println("Using default configuration");
		}
		else 
		{
			System.out.println("Configuration loaded successfully.");
		}
		
		System.out.println();
		
		/*
		 * Input and output files.
		 */
		
		String inputFileName = "grades_input.txt";
		String outputFileName = "grades_report.txt";
		
		System.out.println("Using input file: " + inputFileName);
		System.out.println("Using output file: " + outputFileName);
		System.out.println();
		
		System.out.println("Reading student scores...");
		System.out.println();
		
		/*
		 * Student Information.
		 */
		
		String firstName = "";
		String lastName = "";
		
		/*
		 * Category averages.
		 */
		
		double average1 = 0.0;
		double average2 = 0.0;
		double average3 = 0.0;
		
		boolean inputValid = true;
		
		/*
		 * Open the student input file.
		 */
		
		Scanner inputScanner;
		
		try {
			File inputFile = new File(inputFileName);
			inputScanner = new Scanner(inputFile);
		} catch (FileNotFoundException error) {
			System.out.println("ERROR: Unable to open " + inputFileName + ".");
			System.out.println("Program ending.");
			
			return;
		}
		
		/*
		 * Read first name.
		 */
		
		if (inputScanner.hasNextLine()) 
		{
			firstName = inputScanner.nextLine().trim();
			
			if(firstName.length() == 0) 
			{
				inputValid = false;
			}
		}
		else 
		{
			inputValid = false;
		}
		/*
		 * Read last name.
		 */
		
		if (inputValid && inputScanner.hasNextLine()) 
		{
			lastName = inputScanner.nextLine().trim();
			
			if (lastName.length() == 0)
			{
				inputValid = false;
			}
		}
		else 
		{
			inputValid = false;
		}
		
		/*
		 * Process category 1.
		 */
		
		if (inputValid && categoryCount >= 1) 
		{
			
			String inputCategory = "";
			
		if(inputScanner.hasNextLine()) 
		{
			inputCategory = inputScanner.nextLine().trim();
			
		}
		else 
		{
			inputValid = false;
		}
		
		if (inputValid && !inputCategory.equals(category1)) 
		{
			System.out.println("Error: Category mismatch.");
			System.out.println("Expected: " + category1);
			System.out.println("Found: " + inputCategory);
			inputValid = false;
		}
		
		int numberScores = 0;
		
		if (inputValid && inputScanner.hasNextLine()) 
		{
			String numberText = inputScanner.nextLine().trim();
			
			try 
			{
				numberScores = Integer.parseInt(numberText);
				
				if(numberScores <= 0) 
				{
					System.out.println("ERROR: Number of scores must be positive.");
					inputValid = false;
				}
			}
			
			catch (NumberFormatException error) 
			{
				System.out.println("ERROR: Invalid number of scores.");
				inputValid = false;
			}
		}
		else 
		{
			inputValid = false;
		}
		
		double sum = 0.0;
		
		if(inputValid) 
		{
			if(inputScanner.hasNextLine()) 
			{
				String scoreLine = inputScanner.nextLine().trim();
				Scanner scoreScanner = new Scanner(scoreLine);
				
				int scoreCounter = 0;
				
		/*
		 * Loop through every score in the category.
		 */
		
		while(scoreCounter < numberScores) 
		{
			
			if(scoreScanner.hasNextDouble()) 
			{
				double score = scoreScanner.nextDouble();
				
				if(score < 0 || score > 100) 
				{
					
					System.out.println("ERROR: Score must be between 0 and 100.");
					
				inputValid = false;
				
				}
				else 
				{
					sum +=score;
				}
				
				scoreCounter ++;
				
			}
			else 
			{
				
				System.out.println("ERROR: Invalid score.");
				inputValid = false;
				break;
				
			}
		}
		
		scoreScanner.close();
		
		if (inputValid) 
		{
			average1 = sum / numberScores;
		}
		
		}
			
		else 
		{
		inputValid = false;
		}
		}
		}
		/*
		 * Process category 2.
		 */
		
		if (inputValid && categoryCount >= 2) {
			
			String inputCategory = "";
			
			if (inputScanner.hasNextLine()) {
				
				inputCategory = inputScanner.nextLine().trim();
			}else {
				
				inputValid = false;
			}
			
		if (inputValid && !inputCategory.equals(category2)) {
			System.out.println("ERROR: Category mismatch.");
			System.out.println("Expected: " + category2);
			System.out.println("Found: " + inputCategory);
			
			inputValid = false;
		}
		
		int numberScores = 0;
		
		if(inputValid && inputScanner.hasNextLine()) {
			
			String numberText = inputScanner.nextLine().trim();
			
			try {
				numberScores = Integer.parseInt(numberText);
				
			if(numberScores <= 0) {
				System.out.println("ERROR: Number of scores must be positive.");
				inputValid = false;
			}
		}catch (NumberFormatException e) {
			
			System.out.println("ERROR: Invalid number of scores.");
			inputValid = false;
		}
		}else {
			inputValid = false;
		}
		
		double sum = 0.0;
		
		if(inputValid) {
			
			if(inputScanner.hasNextLine()) {
				
				String scoreLine = inputScanner.nextLine().trim();
				Scanner scoreScanner = new Scanner(scoreLine);
				
				int scoreCounter = 0;
				
				while (scoreCounter < numberScores) {
					
					if (scoreScanner.hasNextDouble()) {
						
						double score = scoreScanner.nextDouble();
						
					if (score < 0 || score > 100) {
						
						System.out.println("ERROR: Score must be between 0 and 100.");
						inputValid = false;
					}else {
						sum += score;
					}
					
					scoreCounter++;
					
					}else {
						System.out.println("ERROR: Invalid score.");
						inputValid = false;
						break;
					}
				}
				
				scoreScanner.close();
				
				if(inputValid) {
					average2 = sum/numberScores;
				}
				
			}else {
				
				inputValid = false;
				}
			}
		}
		
		/*
		 * Process category 3
		 */
		
		if(inputValid && categoryCount >=3) {
			
			String inputCategory = "";
			
			if(inputScanner.hasNextLine()) {
				inputCategory = inputScanner.nextLine().trim();
				
			}else {
				
				inputValid = false;
			}
			
			if (inputValid && !inputCategory.equals(category3)) {
				System.out.println("ERROR: Category mismatch.");
				System.out.println("Expected: " + category3);
				System.out.println("Found: " + inputCategory);
				
				inputValid = false;
			}
			
			int numberScores = 0;
			
			if(inputValid && inputScanner.hasNextLine()) {
				
				String numberText = inputScanner.nextLine().trim();
				
				try {
					
					numberScores = Integer.parseInt(numberText);
					
					if(numberScores <= 0) {
						System.out.println("ERROR: Number of scores must be positive.");
						inputValid = false;
					}
					
				} catch (NumberFormatException e) {
					System.out.println("ERROR: Invalid number of scores.");
					inputValid = false;
				}
			}else {
				
				inputValid = false;
				
			}
			
			double sum = 0.0;
			
			if(inputValid) {
				if(inputScanner.hasNextLine()) {
					
					String scoreLine = inputScanner.nextLine().trim();
					Scanner scoreScanner = new Scanner(scoreLine);
					
				int scoreCounter = 0;
				
				while (scoreCounter < numberScores) {
					
					if (scoreScanner.hasNextDouble()) {
						double score = scoreScanner.nextDouble();
						
						if (score < 0 || score > 100) {
							
							System.out.println("ERROR: Score must be between 0 and 100.");
							
							inputValid = false;
						}else {
							
							sum += score;
						}
						
						scoreCounter ++;
					}else {
						
						System.out.println("ERROR: Invalid score.");
						inputValid = false;
						break;
					}
				}
				
				scoreScanner.close();
				
				if(inputValid) {
					average3 = sum/numberScores;
				}
				
			}else {
				inputValid = false;
			}
		}
	}
		
		inputScanner.close();
		
		/*
		 * Stop if student input was invalid.
		 */
		
		if (!inputValid) {
			System.out.println();
			System.out.println("ERROR: Invalid student input.");
			System.out.println("Program ending.");
			return;
		}
		
		/*
		 * Calculate weighted overall average.
		 */
		
		double overallAverage = 0.0;
		
		if(categoryCount >= 1) {
			overallAverage += average1 * weight1 / 100.0;
		}
		
		if(categoryCount >= 2) {
			overallAverage += average2 * weight2 / 100.0;
		}
		
		if (categoryCount >= 3) {
			overallAverage += average3 * weight3 / 100.0;
		}
		
		/*
		 * Determines the base letter grade.
		 */
		
		String baseLetter;
		
		if (overallAverage >= 90) 
		{
			baseLetter = "A";
		} 
		else if(overallAverage >= 80)
		{
			baseLetter ="B";
		}
		else if (overallAverage >= 70)
		{
			baseLetter = "C";
		}
		else if (overallAverage >= 60)
		{
			baseLetter = "D";
		}
		else
		{
			baseLetter = "F";
		}
		
		/*
		 * Keyboard input for +/- grading.
		 * Validation loop.
		 */
		
		Scanner keyboard = new Scanner(System.in);
		
		String plusMinusChoice = "";
		
		do {
			System.out.print("Apply +/- grading? (Y/N): ");
			plusMinusChoice = keyboard.nextLine().trim();
			
		if(!plusMinusChoice.equalsIgnoreCase("Y") && !plusMinusChoice.equalsIgnoreCase("N"))
		{
			System.out.println("Invalid input.Please enter Y or N.");
		}
		
		} while (!plusMinusChoice.equalsIgnoreCase("Y") && !plusMinusChoice.equalsIgnoreCase("N"));
		
		boolean plusMinusEnabled = plusMinusChoice.equalsIgnoreCase("Y");
		
		/*
		 * Calculates the final letter grade.
		 */
		
		String finalLetter = baseLetter;
		
		if(plusMinusEnabled)
		{
			if (baseLetter.equals("A"))
			{
				if (overallAverage >= 98)
				{
					finalLetter = "A+";
				}
				else if (overallAverage < 92)
				{
					finalLetter = "A-";
				}
				else
				{
					finalLetter = "A";
				}
				
			}
				
			else if (baseLetter.equals("B"))
			{
				if (overallAverage >= 88)
				{
					finalLetter = "B+";
				}
				else if (overallAverage < 82)
				{
					finalLetter = "B-";
				}
				else 
				{
					finalLetter = "B";
				}
			}
			
			else if (baseLetter.equals("C"))
			{
				if (overallAverage >= 78)
				{
					finalLetter = "C+";
				}
				else if (overallAverage < 72)
				{
					finalLetter = "C-";
				}
				else
				{
					finalLetter = "C";
				}
			}
				
			else if (baseLetter.equals("D"))
			{
				if(overallAverage >= 68)
				{
					finalLetter = "D+";
				}
				else if (overallAverage < 62)
				{
					finalLetter = "D-";
				}
				else
				{
					finalLetter = "D";
				}
				
			}else finalLetter = "F";
		}
			
		/*
		 * Display summary to the console.
		 */
			
		System.out.println();
		System.out.println("Student: " + firstName + " " + lastName);
		System.out.println("Course: " + courseName);
		System.out.println();
		System.out.println("Category Results:");
		
		if (categoryCount >= 1) 
		{
			System.out.println( " " + category1 + " (" + weight1 + "%): average = " + average1);
		}
		
		if (categoryCount >= 2) 
		{
			System.out.println( " " + category2 + " (" + weight2 + "%): average = " + average2);
		}
		
		if (categoryCount >= 3) 
		{
			System.out.println( " " + category3 + " (" + weight3 + "%): average = " + average3);
		}
		
		System.out.println();
		System.out.println("Overall numeric average: " + Math.round(overallAverage * 100.0) / 100.0);
		System.out.println("Base letter grade: " + baseLetter);
		System.out.println("Final letter grade: " + finalLetter);
		
		/*
		 * Summary to the output file.
		 */
		
		try
		{
			PrintWriter output = new PrintWriter(outputFileName);
			
			output.println("======================================");
			output.println("   Grade Calculator Report");
			output.println("======================================");
			output.println();
			
			output.println("Course: " + courseName);
			output.println("Student: "+ firstName + " " + lastName);
			output.println();
			
			output.println("Category Results:");
			
			if (categoryCount >= 1)
			{
				output.println(" " + category1 + " (" + weight1 + "%): average = " + average1);
				
			}
			
			if (categoryCount >= 2)
			{
				output.println(" " + category2 + " (" + weight2 + "%): average = " + average2);
				
			}
			
			if (categoryCount >= 3)
			{
				output.println(" " + category3 + " (" + weight3 + "%): average = " + average3);
				
			}
			
			output.println();
			
			output.println("Overall numeric average: " + overallAverage);
			
			output.println("Base letter grade: " + baseLetter);
			output.println("Final letter grade: " + finalLetter);
			
			if (plusMinusEnabled)
			{
				output.println("Apply +/- grading: Yes");
			}
			
			else
			{
				output.println("Apply +/- grading: No");
			}
			
			if(defaultUsed)
			{
				output.println("Default configuration used: Yes");
				
			}
			
			else
			{
				output.println("Default configuration used: No");
			}
			
			output.println();
			output.println("Grade scale:");
			output.println("A = 90-100");
			output.println("B = 80-89.99");
			output.println("C = 70-79.99");
			output.println("D = 60-69.99");
			output.println("F = below 60");
			
			output.close();
			
			System.out.println();
			System.out.println("Summary written to " + outputFileName);
		}
		
		catch (FileNotFoundException error)
		{
			System.out.println();
			System.out.println("ERROR: Unable to write " + outputFileName + ".");
		}
		
		System.out.println("Program complete. Goodbye!");
		
		keyboard.close();
		
	}
}

		
		
		