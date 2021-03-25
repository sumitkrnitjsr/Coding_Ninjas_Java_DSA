package Test_2_Recursion;

/*
Given a string S and an integer k, you need to find and return all the possible strings that can be made of size k using only characters present in string S.
The characters can repeat as many times as needed.
*/

public class Strings_Of_Length_K {
	
public static String[] allStrings(String charSet, int len){
		
		// Write your code here 
        
        
        if(len <= 0){
            String[] result = {""};
            return result; 
        }
        
        
        String[] result = allStrings(charSet,len-1);
        int size = result.length * charSet.length();
        String[] final_result = new String[size];
        int k = 0;
        
        for(int i = 0; i < charSet.length();i++){
            
            char c = charSet.charAt(i);
            
            for(int j = 0; j < result.length; j++){
                final_result[k] = c + result[j];
                k++;
            }
            
        }
        
        return final_result;
        
        

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] results = allStrings("abc",2);
		for(int i=0; i<results.length;i++) {
			System.out.println(results[i]);
		}

	}

}
