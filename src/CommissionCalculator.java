/**
 * Author: Taylor Ericson
 * Class: CSC-240 Computer Science II (Java)
 * Description: This class manages objects representing Auto, Home, and Life insurance policies. 
 * 				It allows the user to enter policy information, and display policy information.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class CommissionCalculator {
	// List for Auto, Home, and Life policies
	private ArrayList<Policy> policies;
	
	// Scanner for user input
	private Scanner scanner;
	
	// Constructor method
	public CommissionCalculator() {
		policies = new ArrayList<>();
		scanner = new Scanner(System.in);
	}
	
	/**
	 * Runs a menu loop, allowing the user to enter policy information, compute commissions,
	 * and print policy information.
	 */
	public void run() {
		int choice = 0;
		
		// Menu loop runs until the user enters the option to quit
		while(choice != 5) {
			System.out.println("\n-----------------------------" +
					"\nWelcome to Parkland Insurance" +
					"\n-----------------------------" +
					"\nEnter any of the following:" +
					"\n1) Enter auto insurance policy information" + 
					"\n2) Enter home insurance policy information" +
					"\n3) Enter life insurance policy information" + 
					"\n4) Print all sales entered" +
					"\n5) Quit");
			
			// Ensure valid input
			if(scanner.hasNextInt()) {
				choice = scanner.nextInt();
				scanner.nextLine(); // Consume newLine
			} else {
				System.out.println("\nInvalid input. Please enter a number between 1 and 5.");
				scanner.nextLine(); // Consume newLine
				continue; // Restart menu loop
			}
			
			if (choice == 1) {
				// Get auto policy information from user
				autoInfo();
			} else if (choice == 2) {
				// Get home policy information from user
				homeInfo();
			} else if (choice == 3) {
				// Get life policy information from user
				lifeInfo();
			} else if (choice == 4) {
				// Compute commission and print out auto policy
				printPolicies();
			} else if (choice == 5) {
				// Exit message
				System.out.println("\nThanks for choosing Parkland Insurance!");
				
			} else {
				// Handle invalid menu choice
				System.out.println("\nInvalid choice. Please enter a valid menu option.");
			}
		}
	}

	// Get auto policy information from user
	private void autoInfo() {
		System.out.print("Enter first name of insured: ");
		String firstName = scanner.nextLine();
		System.out.print("Enter last name of insured: ");
		String lastName = scanner.nextLine();
		System.out.print("Enter make of vehicle: ");
		String make = scanner.nextLine();
		System.out.print("Enter model of vehicle: ");
		String model = scanner.nextLine();
		System.out.print("Enter amount of liability: $");
		double liability = scanner.nextDouble();
		System.out.print("Enter amount of collision: $");
		double collision = scanner.nextDouble();
		scanner.nextLine(); // Consume newLine
		
		Auto autoPolicy = new Auto(firstName, lastName, make, model, liability, collision);
		policies.add(autoPolicy);
		System.out.println("\nAuto policy successfully added.");
	}
	
	// Get home policy information from user
	private void homeInfo() {
		System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter house square footage: ");
        int footage = scanner.nextInt();
        System.out.print("Enter dwelling amount: $");
        double dwelling = scanner.nextDouble();
        System.out.print("Enter contents amount: $");
        double contents = scanner.nextDouble();
        System.out.print("Enter liability amount: $");
        double liability = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Create and add the policy to the list
        Home homePolicy = new Home(firstName, lastName, footage, dwelling, contents, liability);
        policies.add(homePolicy);
        System.out.println("\nHome policy successfully added.");
	}
	
	// Get life policy information from user
	private void lifeInfo() {
		System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter term amount: $");
        double term = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Create and add the policy to the list
        Life lifePolicy = new Life(firstName, lastName, age, term);
        policies.add(lifePolicy);
        System.out.println("\nLife policy added successfully!");
	}
	
	// Print all policies with computed commissions
    private void printPolicies() {
        if (policies.isEmpty()) {
            System.out.println("\nNo policies entered.");
            return;
        }

        System.out.println("\n-----------------------------");
        System.out.println("Policies Summary:");
        System.out.println("-----------------------------");

        for (Policy policy : policies) {
            policy.computeCommission(); // Call overridden methods in each subclass
            System.out.println(policy); 
        }
    }
}