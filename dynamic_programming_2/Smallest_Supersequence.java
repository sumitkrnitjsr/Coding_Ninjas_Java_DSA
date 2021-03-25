package dynamic_programming_2;

/*
Given two strings S and T with lengths M and N. Find and return the length of their shortest 'Super Sequence'.
		 The shortest 'Super Sequence' of two strings is defined as the smallest string possible that will have both the given strings as its subsequences.
*/		 

public class Smallest_Supersequence {
	
public static int smallestSuperSequence(String str1, String str2) {
        
        if(str1.length() == 0){
            return str2.length();
        }
        
        if(str2.length() == 0){
            return str1.length();
        }
        
        int[][] storage = new int[str1.length() + 1][str2.length() + 1];
        
        for(int i = 0;i <= str1.length();i++){
            storage[i][0] = i;
        }
        
        for(int j = 0;j <= str2.length();j++){
            storage[0][j] = j;
        }
        
        for(int i = 1;i <= str1.length(); i++){
            for(int j = 1;j <= str2.length();j++){
                if(str1.charAt(str1.length() - i) == str2.charAt(str2.length() - j)){
                    storage[i][j] = 1 + storage[i-1][j-1]; // Forgot to add 1
                }else{
                    storage[i][j] = 1 + Math.min(storage[i-1][j], storage[i][j-1]);
                }
            }
        }
        
        return storage[str1.length()][str2.length()];
    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
