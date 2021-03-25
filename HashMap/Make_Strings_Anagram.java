package HashMap;
import java.util.HashMap;
/*
Given two strings S1 and S2, find and return the minimum number of deletions to be made (total count of deletions in both strings) in order to make the strings anagram.
Anagram of a string is a string which is its permutation.
For example "bbaa" and "abab" are anagrams of each other but "bbaa" and "aaab" are not.
*/

public class Make_Strings_Anagram {
	
	public static int makeAnagram(String s1,String s2){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        
        if( s1== null && s2 == null){
            return 0;
        }
        
        if(s1 == null){
            return s2.length();
        }
        
        if(s2 == null){
            s1.length();
        }
        
        HashMap<Character, Integer> s1_map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> s2_map = new HashMap<Character, Integer>();
        
        
        for(int i=0; i<s1.length(); i++){
            
            int count = 0;
            if(s1_map.size() > 0 && s1_map.containsKey(s1.charAt(i))){
            	    count = s1_map.get(s1.charAt(i));
            }
            count++;
            s1_map.put(s1.charAt(i), count);
            
        }
        
        for(int i=0; i<s2.length(); i++){
            
            int count = 0;
            if(s2_map.size() > 0 && s2_map.containsKey(s2.charAt(i))){
            	    count = s2_map.get(s2.charAt(i));
            }
            count++;
            s2_map.put(s2.charAt(i), count);
            
        }
        
        int count = 0;
        for(char c = 'a'; c<= 'z'; c++){
            int c1 = 0;
            if(s1_map.containsKey(c)){
                c1 = s1_map.get(c);
            }
            int c2 = 0;
            
            if(s2_map.containsKey(c)){
                c2 = s2_map.get(c);
            }
            
            count += Math.abs(c1-c2);
        }
        
        return count;
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeAnagram("abbab","aba");
	}

}
