package Amazon_Interview;
import java.util.HashMap;
import java.util.Map;

//  You have been given an integer array/list (ARR) of size N. Write a function that returns the total number of those subsequences of the array in which all the elements are equal.

public class Count_Subsequences {
	
	// make your own multiplication to cover integer overflow
	 private static long mul(long num, long pow){ 
	        if(pow == 0){
	            return 1;
	        }
	        long ans = 1;
	        long mod = (long)Math.pow(10,9) + 7; // cast compiler error lossy conversion int to long
	        while(pow > 0){
	            ans = ((ans * num))%mod;
	            pow--;
	        }
	        return ans - 1l;
	    }
	    
	    public static long countSubsequences(long[] arr) {
	        if(arr.length < 1){
	            return 0l;
	        }
	        HashMap<Long, Long> map = new HashMap<>();
	        for(int i = 0;i < arr.length;i++){
	            Long count= map.get(arr[i]);
	           // System.out.println(arr[i] + " " + count);
	            if(count == null){
	                map.put(arr[i], 1l);
	            }else{
	                map.replace(arr[i], count + 1);
	            }
	        }
	        long answer = 0;
	        long mod = (long)(Math.pow(10,9)) + 7;
	        for(Map.Entry<Long, Long> entry: map.entrySet()) { // entryset to traverse map
	            Long count = entry.getValue();
	            answer = (answer + (mul(2,count)))%mod;
	        }
	        return answer;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
