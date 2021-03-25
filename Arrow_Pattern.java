import java.util.Scanner;
/*
*
 * *
   * * *
     * * * *
   * * *
 * *
*
*/
public class Arrow_Pattern {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		int i = 1;
		int space = 0; // int space = -1; Space was not visible, so wrong assumption
		int j;
		int alternate = 0;
		for(; i<= (number+1)/2; i++) {
			alternate = 0; 
			for(j=1; j<= space; j++) {
				System.out.print(" ");
			}
			
			for(int k=1; k<=((2*(i-1)) +1); k++) {
				if(alternate == 1) {
					System.out.print(" ");
				}else {
				System.out.print("*");
				}
				alternate = 1-alternate;
			}
			
			space++;
			System.out.println(" "); // Forgot to insert new line & could not see space at the end of line
		}
		
		space = space-2; //space--; wrong judgement of restoration
		i = i-2;
		alternate = 0;
		while(i>0) {
			alternate = 0; // forgot to reset alternate variable
			for(j=1; j<= space; j++) {
				System.out.print(" ");
			}
			
			for(int k=1; k<=(2*(i-1) +1); k++) {
				if(alternate == 1) {
					System.out.print(" ");
				}else {
				System.out.print("*");
				}
				alternate = 1-alternate;
			}
			
			i--;
			space--;
			System.out.println(" "); // Forgot to insert new line
		}
		
		
	}
}
