package hopkins_p3;

import java.util.Scanner;

public class P3_Survey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int nUsers = 0;
		int r = 0; //used for a loop
		int b = 0; //for another loop
		int t = 0;
		int k = 0;
		String topics[] = {"Politics", "Anime", "School", "Hobbies", "Health"};
		int[][] responses = new int[5][10];
		int ans = 0;
		int totals[] = {0, 0, 0, 0, 0};
		
		int max = -999;
		int min = 999;
		
		int ma_ind = 0;
		int mi_ind = 0;
		
		int avgs[] = {0, 0, 0, 0, 0};
		
		System.out.println("Hopkins Survey Client");
		while(nUsers == 0) {
			//get people
			System.out.print("How many users will be taking this survey?");
			nUsers = sc.nextInt();
			
			if(nUsers < 1) {
				
				nUsers = 0;
				
				System.out.println("We cant have no or negative users participating! Try again.");
				
			}
			
		}
		
		for(r = 1; r <= nUsers; r++) {
			
			System.out.println("User " + r + ", please take this survey.");
			
			System.out.println("From 1 (least important) to 10 (most important), rate the following topics:");
			for(b = 0; b < 5; b++) {
				
				System.out.print("" + topics[b] + ": ");
				ans = sc.nextInt();
				
				if(ans < 1) {
					
					System.out.println("Answer is less than 1. We will assume you meant 1.");
					
					responses[b][0] += 1;
					
				}else if(ans > 10) {
					
					System.out.println("Answer is more than 10. We will assume you meant 10.");
					
					responses[b][9] += 1;

					
				}else {
					
					responses[b][ans - 1] += 1;
					
				}
				
			}
			
		}
		
		for(t = 0; t < 5; t++) {
			
			int div_sum = 0;
			
			for(k = 0; k < 10; k++) {
				
				avgs[t] += ((k + 1) * responses[t][k]);
				
				div_sum += responses[t][k];
				
			}
			
			avgs[t] = avgs[t] / div_sum;
			
		}
		
		//get score totals
		for(t = 0; t < 5; t++) {
			
			for(b = 0; b < 10; b++) {
				
				totals[t] += ((b + 1) * (responses[t][b]));
				
			}
			
		}
		
		//get heighest rated
		for(t = 0; t < 5; t++) {
			
			if(totals[t] > max) {
				
				max = totals[t];
				
				ma_ind = t;
				
			}
			
		}
		
		
		//get lowest rated
		for(t = 0; t < 5;t++) {
			
			if(totals[t] < min) {
				
				min = totals[t];
				mi_ind = t;
				
			}
			
		}
		
		System.out.println("Here are this run's results!");
		System.out.println("Topics\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\tAverage");
		for(b = 0; b < 5; b++) {
			
			System.out.print("" + topics[b] + "\t");
			for(k = 0; k < 10; t++) {
				
				System.out.print("\t" + responses[b][k]);
				
			}
			System.out.print("" + avgs[t] + "\n");
		}
		
		System.out.println("Highest total: " + topics[ma_ind] + "with " + max + " points");
		System.out.println("Lowest total: " + topics[mi_ind] + "with " + min + " points");
		
	}
	
}
