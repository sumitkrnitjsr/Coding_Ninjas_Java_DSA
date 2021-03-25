package Test_2_Recursion;


// Given n pairs of parentheses, write a function to generate and print all combinations of well-formed parentheses. That is, you need to generate all possible valid set of parenthesis that can be formed with given number of pairs.

public class Generate_all_parenthesis {
	
static void printWellFormedParanthesis(int opening, int closing, String output){
        
        if( opening == 0){
            
            for(int i = 0;i < closing; i++){
                output = output + ")";
            }
            
            System.out.println(output);
            return;
        }
        
        printWellFormedParanthesis(opening-1, closing, output + "(");
        
        if(closing > opening){ // wrong check condition used  if(closing < opening){
             printWellFormedParanthesis(opening, closing-1, output + ")");
        }
        
        
        
    }
	
	public static void printWellFormedParanthesis( int n){
		
		// Write your code here
        printWellFormedParanthesis( n , n, "");

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printWellFormedParanthesis(3);

	}

}
