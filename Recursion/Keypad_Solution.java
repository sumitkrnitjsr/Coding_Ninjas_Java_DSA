package Recursion;

/*
Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
Return empty string for numbers 0 and 1.
Note : 1. The order of strings are not important.
2. Input and output has already been managed for you. You just have to populate the output array and return the count of elements populated in the output array.
*/		

public class Keypad_Solution {

	  static String[] characterArray(int n){
		    String[] result_3 = new String[3];
		    String[] result_4 = new String[4];
		        switch(n){
		            case 2 : 
		                
		                result_3[0] = "a";
		                result_3[1] = "b";
		                result_3[2] = "c";
		                return result_3;
		               
		            case 3 :
		    
		                result_3[0] = "d";
		                result_3[1] = "e";
		                result_3[2] = "f";
		                return result_3;
		                
		            case 4:
		                
		                result_3[0] = "g";
		                result_3[1] = "h";
		                result_3[2] = "i";
		                return result_3;
		               
		            case 5: 
		                
		                result_3[0] = "j";
		                result_3[1] = "k";
		                result_3[2] = "l";
		                return result_3;
		               
		            case 6:
		                
		                result_3[0] = "m";
		                result_3[1] = "n";
		                result_3[2] = "o";
		                return result_3;
		               
		            case 7: 
		               
		                result_4[0] = "p";
		                result_4[1] = "q";
		                result_4[2] = "r";
		                result_4[3] = "s";
		                return result_4;
		               
		            case 8 :
		                
		                result_3[0] = "t";
		                result_3[1] = "u";
		                result_3[2] = "v";
		                return result_3;
		        
		            case 9:
		                
		                result_4[0] = "w";
		                result_4[1] = "x";
		                result_4[2] = "y";
		                result_4[3] = "z";
		                return result_4;
		      
		        }
		        
		        return null;
		    }
		    
		    
		    
			public static String[] keypad(int n){
				// Write your code here
		        
		        if(n == 0){
		            String result[] = {""};
		            return result;
		        }
		        
		        String[] smallAns = keypad(n/10);
		        String[] merge = characterArray(n%10);
		        
		        String[] final_result = new String[merge.length * smallAns.length];
		        int k = 0;
		        for(int i = 0; i < smallAns.length ; i++){
		            
		            for(int j = 0; j < merge.length; j++){
		                
		                final_result[k] = smallAns[i] + merge[j];
		                k++;
		            }
		            
		            
		        }

		        return final_result;
			}
			
			 static void printKeypad_Top_To_Bottom_Recursion(int input, String str){
			        
			        if(input == 0){
			            System.out.println(str);
			            return;
			        }
			        
			        int digit = input%10;
			        String[] array = characterArray(digit);
			        for(int i = 0; i < array.length; i++) {
			        
			        	printKeypad_Top_To_Bottom_Recursion(input/10,array[i] + str);
			        }
			        
			    }
			 
			
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] result = keypad(435);
		for(int i = 0; i < result.length ; i++) {
			System.out.println(result[i]);
		}

	}

}
