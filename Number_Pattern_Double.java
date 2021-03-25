import java.util.Scanner;
/*

1        1
12      21
123    321
1234  4321
1234554321

*/
public class Number_Pattern_Double {

	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int space = 2*(number-1);
		for(int i=1; i<= number; i++) {
			int counter,j;
			
			for(j=1; j<= i; j++) {				// for(j=1; j<= number; j++) { Wrong loop check condition
				System.out.print(j);
			}
			j--;
			
			
			int temp = space;
			for(; space>0; space-- ) {
				System.out.print(" ");
			}
			
			space = temp-2;
			
			while( j> 0) {
				System.out.print(j);
				j--;
			}
			
			System.out.println();
			
		}
	}
	
	
}
