import java.util.Scanner;

/*
 * 
...1
..232
.34543
*
*/


public class Triangle_Of_Numbers {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		int mid = number; // Wrong mental calculation based on biased array index starting from 0
		int spaces = mid-1; // Forgot to handle spaces separately
		for(int i=1; i<= number; i++) {
			
			int j;
			for(j=1; j<=spaces ; j++) {
				System.out.print(" ");
			}
			
			int temp = i;
			for(; j<=mid ; j++) {
				System.out.print(temp);
				temp++;
			}
			
			temp = temp-2; // forgot to reverse the count with 2, first time reversed by 1 only
			
			while(temp >= i) {
				System.out.print(temp);
				temp--; // Forgot to control loop
			}
			System.out.println();
			spaces--; // Forgot to decrease spaces
			
		}
		
		
	}

}
