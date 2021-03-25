import java.util.Scanner;

/*
1    2   3    4   5
11   12  13   14  15
21   22  23   24  25
16   17  18   19  20
6    7    8   9   10
*/



public class Number_Pattern_Spiral {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		int mid = (number%2==0)?(number/2):((number+1)/2);
		int i;
		int counter;
		for( i=0; i<mid; i++) {
			counter = (2*i*number)+1; //counter = (2*number)+1; forgot i to control n
			
			for(int j=1; j<=number; j++) {
				System.out.print(counter+" ");
				counter++;
			}
			System.out.println();
		}
		
		//i--; Wrong handling of mid
		
		i = (number%2==0)?i:i-1;
		
		while(i>0) {
			counter = ((2*i)-1)*number + 1;
			
			for(int j=1; j<=number; j++) {
				System.out.print(counter+" ");
				counter++;
			}
			i--;
			System.out.println();
		}
		
	}
	
}
