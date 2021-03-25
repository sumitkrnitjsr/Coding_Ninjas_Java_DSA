package dynamic_programming_2;


// Given two strings s and t of lengths m and n respectively, find the edit distance between the strings.

public class Edit_Distance {
	
	public static int editDistance(String s1, String s2){

        if(s1.length() == 0 && s2.length() == 0){
            return 0;
        }
        
        if(s1.length() == 0 || s2.length() == 0){
            if(s1.length() == 0){
                return s2.length();
            }
            return s1.length();
        }
        
        if(s1.charAt(0) == s2.charAt(0)){
            return editDistance(s1.substring(1), s2.substring(1));
        }
        
        int ans1 = editDistance(s1.substring(1),s2);
        int ans2 = editDistance(s1.substring(1),s2.substring(1));
        int ans3 = editDistance(s1,s2.substring(1));
        
        return 1 + Math.min(ans1,Math.min(ans2,ans3));

	}
	
	

	public static int editDistanceM(String s, String t) {
		//Your code goes here
        
        int[][] storage = new int[s.length() + 1][t.length() + 1];
        
        for(int i = 0;i <= s.length();i++){
            
            for(int j = 0;j <= t.length();j++){
                
                storage[i][j] = -1;
            }
        }
        
        return editDistanceM(s,t,storage);
    }
    
    public static int editDistanceM(String s1, String s2, int[][] storage){

        if(s1.length() == 0 && s2.length() == 0){
            storage[s1.length()][s2.length()] = 0;
            return storage[s1.length()][s2.length()];
        }
        
        if(s1.length() == 0 || s2.length() == 0){
            if(s1.length() == 0){
                storage[s1.length()][s2.length()] = s2.length();
            }else{
                storage[s1.length()][s2.length()] = s1.length();
            }
            return storage[s1.length()][s2.length()];
        }
        
        if(s1.charAt(0) == s2.charAt(0)){
            int ans =  editDistance(s1.substring(1), s2.substring(1));
            storage[s1.length()][s2.length()] = ans;
            return storage[s1.length()][s2.length()];
        }
        
        int ans1 = editDistance(s1.substring(1),s2);
        int ans2 = editDistance(s1.substring(1),s2.substring(1));
        int ans3 = editDistance(s1,s2.substring(1));
        
        int ans =  1 + Math.min(ans1,Math.min(ans2,ans3));
        storage[s1.length()][s2.length()] = ans;
		return storage[s1.length()][s2.length()];

	}


    public static int editDistanceDP(String s, String t){
        
        int[][] storage = new int[s.length() + 1][t.length() + 1];
        
        for(int i = 0;i <= s.length();i++){
            storage[i][0] = i;
        }
        
        for(int i = 0;i <= t.length();i++){
            storage[0][i] = i;
        }
        
        for(int i = 1;i <= s.length();i++){
            for(int j = 1;j <= t.length(); j++){
                if(s.charAt(s.length() - i ) == t.charAt(t.length() - j)){
                    storage[i][j] = storage[i-1][j-1];
                }else{
                    storage[i][j] = 1 + Math.min(storage[i-1][j-1], Math.min(storage[i-1][j], storage[i][j-1]));
                }
            }
            
            
        }
        
        
        return storage[s.length()][t.length()];
    }
    
    
    
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
