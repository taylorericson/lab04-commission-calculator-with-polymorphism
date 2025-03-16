# lab04-commission-calculator-with-polymorphism
## CSC 240 - Lab 4 Commission Calculator w/ Polymorphism

A project completed as part of the class CSC 240 at Parkland College.

Directions: 
-
Re-design the CommissionCalculator class from the previous lab to store an ArrayList of base Policy class object reference variables as shown below to replace the single Auto, Home, and Life policy as in the previous lab.

 

       ArrayList<Policy> policies;

      

Use the menu below to prompt a user to input any number of different types of insurance policies. For options 1-3, use the input information to create the specific type of policy and store it in the newly added ArrayList of base Policy objects above.

 

-----------------------------

Welcome to Parkland Insurance

-----------------------------

Enter any of the following:

       1) Enter auto insurance policy information

       2) Enter home insurance policy information

       3) Enter life insurance policy information

       4) Print all sales entered

       5) Quit

 

After policies have been created and stored, the user can then select option 4 below. This option must use the single loop shown below to compute the commission and print the information for all the policies created stored in the ArrayList of base Policy class objects.

// List all policies

       for(Policy policy : policies)
       {
             // Compute commission
             policy.computeCommission();
             
             // Print the policy
             System.out.println(policy);
       }
       
In this way, your program demonstrates polymorphism when calling the base Policy class computeCommisson and toString methods as shown. Continue the program until the user quits. Use all of the other classes (including the driver) from the previous lab. Note you do not need to modify these classes. Feel free to use classes from the instructor’s solution the previous lab.
