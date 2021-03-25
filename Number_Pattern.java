import java.util.Scanner; // Forgot to import

/*
    1
   23
  345
 4567
 
*/

public class Number_Pattern {
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
//      char[] output_line = new char[number]; Wrong beginning as 14 will count as two characters
//      String[] output_line = new String[number]; Array not needed, extra space, can print on runtime
        for(int i=1; i<= number; i++) {
        	int position = number-1-(i-1);
            int j = 0;
            for(; j<position; j++){
            	//output_line[j] = new String(" ");
            	System.out.print(" ");
            }
            int temp = i;
            for(;j<number;j++){
//            	output_line[j] = (char)('0' + temp); Wrong way of converting int to char
//              output_line[j] = Integer.toString(temp);
                System.out.print(Integer.toString(temp));
                temp++;
            }
            System.out.println();
        }
        
		
	}



}
