package Amazon_Interview;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
/*
You have been given an array/list of strings. You are supposed to return the strings as groups of anagrams such that strings belonging to a particular group are anagrams of one another.
An anagram is a word or phrase formed by rearranging the letters of a different word or phrase. We can generalise this in string processing by saying that an anagram of a string is another string with the same quantity of each character in it, in any order.
Note: The Order In Which The Groups And Members Of The Groups Are Printed Does Not Matter.
*/

class Pair implements Comparable<Pair>{
    String str;
    int index;
    public Pair(String s,int t){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        str = new String(arr);
        index = t;
    }
    
    public int compareTo(Pair p){
        return str.compareTo(p.str);
    }
}

public class GroupAnagrams {
	
	public static ArrayList<ArrayList<String>> getGroupedAnagrams(ArrayList<String> inputStr, int n) {
		ArrayList<Pair> list = new ArrayList<>();
        int index = 0;
        for(String str: inputStr){
            list.add(new Pair(str,index ));
            index++;
        }
        Collections.sort(list);
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> l = new ArrayList<>();
        String current = list.get(0).str;
        for(Pair p:list){
            if(p.str.equals(current)){
                l.add(inputStr.get(p.index));
            }else{
                result.add(l);
                l = new ArrayList<>();
                current = p.str; // forgot to update current
                l.add(inputStr.get(p.index));
            }
        }
        result.add(l);
        return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
