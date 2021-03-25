

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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
