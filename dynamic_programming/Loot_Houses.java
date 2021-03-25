package dynamic_programming;


// A thief wants to loot houses. He knows the amount of money in each house. He cannot loot two consecutive houses. Find the maximum amount of money he can loot.


public class Loot_Houses {
	
	public static int maxMoneyLooted(int[] houses) {
		//Your code goes here
        
        if(houses.length < 1){
            return 0;
        }
        
        int max_array[] = new int[houses.length];
        
        max_array[0] = houses[0];
        max_array[1] = Math.max(max_array[0], houses[1]);
        
        for(int i = 2;i < houses.length;i++){
            
            max_array[i] = Math.max(max_array[i-1], max_array[i-2] + houses[i]);
        }
        
        
        return max_array[houses.length - 1];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
