package hopkins_p2;

import java.util.Scanner;

public class P2_BMI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		double height_in = 0.0;
		double height_m = 0.0;
		double weight_lb = 0.0;
		double weight_kg = 0.0;
		double BMI_USC = 0.0;
		double BMI_MET = 0.0;
		
		int path = -1;
		
		System.out.println("Hopkins BMI Calculator");
		
		//measurement unit choice
		while (path != 0 && path != 1) {
			
			System.out.println("Set units for calculation");
			System.out.println("0: lb, in");
			System.out.println("1: kg, m");
			System.out.print("Choice: ");
			
			path = sc.nextInt();
			
			if(path != 0 && path != 1) {
				
				path = -1;
				
				System.out.println("Invalid choice. Try again.");
				
			}
			
		}
		
		if(path == 0) {
			//get info
			System.out.println("Enter weight(lb): ");
			weight_lb = sc.nextDouble();
			System.out.println("Enter height(in): ");
			height_in = sc.nextDouble();
			
			//display BMI and category
			BMI_USC = (703.0 * weight_lb) / (height_in * height_in);
			
			System.out.printf("Your BMI: %.1f\n", BMI_USC);
			
			if(BMI_USC < 18.5) {
				
				System.out.println("Category: Underweight");
				
			}else if(BMI_USC >= 18.5 && BMI_USC <= 24.9) {
				
				System.out.println("Category: Normal Weight");
				
			}else if(BMI_USC >= 25 && BMI_USC <= 29.9) {
				
				System.out.println("Category: Overweight");
				
			}else if(BMI_USC >= 30) {
				
				System.out.println("Category: Obesity");
				
			}
			
		}else if(path == 1)
		{
			//get info
			System.out.println("Enter weight(kg): ");
			weight_kg = sc.nextDouble();
			System.out.println("Enter height(m): ");
			height_m = sc.nextDouble();
			
			//display BMI and category
			BMI_MET = weight_kg / (height_m * height_m);
			
			System.out.printf("Your BMI: %.1f\n", BMI_MET);
			
			if(BMI_MET < 18.5) {
				
				System.out.println("Category: Underweight");
				
			}else if(BMI_MET >= 18.5 && BMI_MET <= 24.9) {
				
				System.out.println("Category: Normal Weight");
				
			}else if(BMI_MET >= 25 && BMI_MET <= 29.9) {
				
				System.out.println("Category: Overweight");
				
			}else if(BMI_MET >= 30) {
				
				System.out.println("Category: Obesity");
				
			}
			
		}
	
		System.out.println("Thank you for using this BMI calculator. Goodbye!");
		
	}

}
