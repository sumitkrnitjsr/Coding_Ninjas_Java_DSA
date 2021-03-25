import java.util.Scanner;

/*
 * 
5 5 5 5 5 5 5 5 5 
5 4 4 4 4 4 4 4 5 
5 4 3 3 3 3 3 4 5 
5 4 3 2 2 2 3 4 5 
5 4 3 2 1 2 3 4 5 
5 4 3 2 2 2 3 4 5 
5 4 3 3 3 3 3 4 5 
5 4 4 4 4 4 4 4 5 
5 5 5 5 5 5 5 5 5 

*/
public class Number_Pattern_Square {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		int i = 1;

		int current_reduction = 0;
		int[] row = new int[number];
		
		for(; i<=number; i++) {
			int temp_reduction = 0;
			int entry = number;
			int k;
			int index = 0;
			
			for(k=1; k<= number; k++) {
				
				if(temp_reduction<=current_reduction) {
				entry = number-temp_reduction; // Wrong variable operation, confused name; entry = entry-temp_reduction;
				temp_reduction++;
				}
				System.out.print(entry + " "); // System.out.print(entry); Forgot spaces
				row[index] = entry;
				index++;
			}
			
			index = index-2;
			while(k <= (2*number)-1) {
				System.out.print(row[index] + " "); //  Forgot spaces
				k++;
				index--;
			}
			
		current_reduction++;	
		System.out.println(); // Forgot to put new line
		}

		
		current_reduction = current_reduction-2;
		
		for( i=1; i<number;i++) {
			int temp_reduction = 0;
			int entry = number;
			int k;
			int index = 0;
			
			for( k=1; k<= number;k++) {
				
				if(temp_reduction <= current_reduction) {
					entry = number-temp_reduction;
					temp_reduction++;
				}
				System.out.print(entry + " ");
				row[index] = entry;
				index++;
				
			}
			
			index = index-2;
			while( k<= (2*number-1)) {
				System.out.print(row[index] + " ");
				k++;
				index--;
			}
			current_reduction--;
			System.out.println();
		}
		
	}

}
