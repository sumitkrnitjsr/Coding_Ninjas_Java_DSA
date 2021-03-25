package HashMap;
import java.util.HashMap;

public class Pair_Sum_To_Zero_2 {


		public static void findPairsDifferenceK(int[] input, int k){
	        
	        if(input == null || input.length < 2){
	            return;
	        }
	        
	        HashMap<Integer, Integer> occurrence = new HashMap<Integer, Integer>();
	        
	        for(int i=0; i<input.length; i++){
	            
	            int number = input[i];
	            int pair_1 = number + k;
	            int pair_2 = number - k; //Forgot to search for two possble numbers
	            
	            System.out.println(pair_1 + " " + pair_2);
	            
	            if(occurrence.size() > 0 && occurrence.containsKey(pair_1)){
	                
	                int loop = occurrence.get(pair_1);
	                int min = (pair_1>number)?number:pair_1;
	                int max = (min == number)?pair_1:number;
	                
	                for(int j=0; j<loop; j++){
	                    System.out.println(min + " " + max);
	                }
	                
	            }
	            
	            if(occurrence.size() > 0 && occurrence.containsKey(pair_2) && (pair_1 != pair_2)){ //Forgot to check for && (pair_1 != pair_2)
	                
	                int loop = occurrence.get(pair_2);
	                int min = (pair_2>number)?number:pair_2;
	                int max = (min == number)?pair_2:number;
	                
	                for(int j=0; j<loop; j++){
	                    System.out.println(min + " " + max);
	                }
	                
	            }
	            
	            if(occurrence.size() > 0 && occurrence.containsKey(number)){
	                
	                int value = occurrence.get(number);
	                value++;
	                occurrence.put(number,value);
	            }else{
	                occurrence.put(number,1);
	            }
	    
	        }
	        
		}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {-334, 108, 35, -154, 58, -185, 8, -111, -91, 45 };
		findPairsDifferenceK(arr,243);
	}

}
