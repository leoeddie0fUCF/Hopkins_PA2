package hopkins_p1;

import java.util.Scanner;

public class P1_Decrypt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int plain = 0;
		int c_remain = 0;
		
		int d4;
		int d3;
		int d2;
		int d1;
		
		System.out.println("Hopkins Decryption Client");
		
		//ensures the message is 4 digits
		//assumes the message is a non-negative integer
		while(plain == 0) {
			
			System.out.print("Enter 4-digit message to decrypt: ");
			
			plain = scan.nextInt();
			
			if(plain <= 999 || plain >= 10000) {
				
				plain = 0;
				
				System.out.println("Cannot decrypt this. Please try again.");
				
			}
			
		}
		
		while (c_remain == 0) {
			
			//assume this is a positive single digit integer.
			System.out.print("Enter single digit remainder from encryption (this should have been given along with the ciphertext for integrity reasons): ");
			c_remain = scan.nextInt();
			
			if(c_remain < 0 || c_remain > 9) {
				
				c_remain = 0;
				
				System.out.println("This is not a valid single digit. Please try again.");
				
			}
			
		}
		
		System.out.println("Reversing fourth and third step");
		d4 = plain / 1000;
		d3 = (plain / 100) - (d4 * 10);
		d2 = (plain / 10) - ((d4 * 100) + (d3 * 10));
		d1 = plain % 10;
		//System.out.println("" + d4 + " " + d3 + " " + d2 + " " + d1);
		
		plain = (d2 * 1000) + (d1 * 100) + (d4 * 10) + d3;
		
		System.out.println("Reversing second step");
		plain = (plain * 10) + c_remain;
		//System.out.println(plain);
		
		System.out.println("Reversing first step");
		plain -= 7777;
		//System.out.println(plain);
	
		System.out.println("Original message: " + plain);
		System.out.println("Thank you for using this decryption service. Goodbye.");
		
	}

}
