package calculator;

import java.util.Vector;
import java.util.Scanner;

public class Calculator {
	
	public Calculator() {
		inputScanner = new Scanner(System.in); //initialize
	}

	Scanner inputScanner; //declare
	final int numOfInputs = 2;
	int selectedOperation;

	/**
	 * This method prints out instructions about the calculator
	 */
	private void printWelcomeMessage() {
		System.out.println("Welcome to TA_Calculator_2.0");
		System.out.println("Select options 1 - 5");
		System.out.println("Option 1: Addition");
		System.out.println("Option 2: subtraction");
		System.out.println("Option 3: multiplication");
		System.out.println("Option 4  division");
		System.out.println("Option 5: Exit");
	}

	Vector<Float> getInputForOperation(String taskName) {
		// Print out selected operation
		System.out.println(taskName);
		
		Vector<Float> inputList = new Vector<Float>();
		try {
			for (int i = 0; i < numOfInputs; i++) {
				System.out.println("Input value " + (i + 1) + ":");
				float num = inputScanner.nextFloat();
				inputList.add(num);
			}
		} catch (Exception e) {
			System.out.println("Invalid input received: " + e.getMessage());
		}
		return inputList;
	}

	public void execute() {
		printWelcomeMessage();
		
		selectedOperation = 0;

		try {
			selectedOperation = inputScanner.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid input received: " +  e);
		}

		Vector<Float> inputList;
		float result;
		
		switch (selectedOperation) {
		case 1:
			inputList = getInputForOperation("You have selected Addition");
			result = doAddition(inputList);
			System.out.println(result + "\n\n");
			break;
		case 2:
			inputList = getInputForOperation("You have selected Subtraction");
			result = doSubtraction(inputList);
			System.out.println(result + "\n\n");
			break;
		case 3:
			inputList = getInputForOperation("You have selected Multiplication");
			result = doMultiplication(inputList);
			System.out.println(result + "\n\n");
			break;
		case 4:
			inputList = getInputForOperation("You have selected Division");
			result = doDivision(inputList);
			System.out.println(result + "\n\n");
			break;
		case 5:
			System.out.println("You have chosen to end the program");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option");
			inputScanner.nextLine();
		}
	}

	private float doAddition(Vector<Float> values) {
		float result = 0;
		//float result = values.elementAt(0) + values.elementAt(1);
		for (int i = 0; i < values.size(); i++) {
			result = result + (float)values.elementAt(i);
		}
		return result;
	}

	private float doSubtraction(Vector<Float> values) {
		//float result = values.elementAt(0) - values.elementAt(1);
		float result = values.elementAt(0);
		for (int i = 1; i < values.size(); i++) {
			result = result - (float) values.elementAt(i);
		}
		return result;
	}

	private float doMultiplication(Vector<Float> values) {
		//float result = values.elementAt(0) * values.elementAt(1);
		float result = values.elementAt(0);
		for (int i = 1; i < values.size(); i++) {
			result = result * (float) values.elementAt(i);
		}
		return result;
	}


	private float doDivision(Vector<Float> values) {
		//float result = values.elementAt(0) / values.elementAt(1);
		float result = values.elementAt(0);
		for (int i = 1; i < values.size(); i++) {
			result = result / (float) values.elementAt(i);
		}
		return result;
	}
	
	// program starts here
	public static void main(String[] args) {
		Calculator calc = new Calculator();  // declaration && initialization
		while(true){
		    calc.execute();
		}
	}
}