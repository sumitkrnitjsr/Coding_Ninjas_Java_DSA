package HashMap;
import java.util.HashMap;
import java.util.ArrayList;

public class Remove_Duplicates {

	
	static ArrayList<Integer> removeDuplicates(int[] a) {
	ArrayList<Integer> result = new ArrayList<>();
	HashMap<Integer,Boolean> track = new HashMap<>();
	
	for(int i=0; i<a.length; i++) {
		
		if(track.containsKey(a[i])) { // to maintain order of appearance
			continue;
		}
		
		track.put(a[i],true);
		result.add(a[i]);
	}
	
	return result;
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = {1,2,3,4,5,1000000,5,4,3,2,1};
		
		ArrayList<Integer> result = removeDuplicates(a);
		
		for(Integer i: result) {
			System.out.println(i);
		}
	}

}
