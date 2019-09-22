package hopkins_p1;

import java.util.Scanner;

public class P1_Encrypt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int cipher = 0;
		int c_remain = 0;
		
		int d4;
		int d3;
		int d2;
		int d1;
		
		System.out.println("Hopkins Encryption Client");
		
		//ensures the message is 4 digits
		//assumes the message is a non-negative integer
		while(cipher == 0) {
			
			System.out.print("Enter 4-digit message to encrypt: ");
			
			cipher = scan.nextInt();
			
			if(cipher <= 999 || cipher >= 10000) {
				
				cipher = 0;
				
				System.out.println("Cannot encrypt this. Please try again.");
				
			}
			
		}
		
		System.out.println("Performing first step");
		cipher += 7;
		cipher += 70;
		cipher += 700;
		cipher += 7000;
		//System.out.println(cipher);
		
		System.out.println("Performing second step");
		c_remain = cipher - ((cipher / 10) * 10);
		cipher /= 10;
		//System.out.println(cipher);
		
		System.out.println("Performing third and fourth step");
		d4 = cipher / 1000;
		d3 = (cipher / 100) - (d4 * 10);
		d2 = (cipher / 10) - ((d4 * 100) + (d3 * 10));
		d1 = cipher % 10;
		//System.out.println("" + d4 + " " + d3 + " " + d2 + " " + d1);
		
		cipher = (d2 * 1000) + (d1 * 100) + (d4 * 10) + d3;
		
		//System.out.println(cipher);
		
		System.out.println("Cipher Integer: " + cipher);
		System.out.println("Remainder: " + c_remain + " (THIS IS CRUCIAL FOR THE RECIPIENT TO HAVE FOR THE INTEGITRY OF THE ORIGINAL MESSAGE!)");
		System.out.println("Thank you for using this encryption service. Goodbye.");
		
	}

}
