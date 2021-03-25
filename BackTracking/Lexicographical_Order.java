package BackTracking;


// Given a number n, print numbers from 1 to n in dictionary(lexicographical) order.


public class Lexicographical_Order {
	
	public static void lexicographicalOrder(int num){
		// Write your code here
        lexicographicalOrder(num, 0);
	}
    
    public static void lexicographicalOrder(int num,int sum){
        
        if(sum > num){
            return;
        }
        /*
        if((sum*10 > num) || (sum == num)) {
            System.out.println(sum);
            return;
        }
        */
        int begin = 1;
        if(sum != 0){
            begin = 0;
        }
    	
        int end = 9;
        for(int i = begin; i <= end; i++){
            
            int calc = ((sum*10) + i);
            
            if(calc > num){
                break;
            }
            System.out.println(calc);
            lexicographicalOrder(num, calc);
            
        }
        
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lexicographicalOrder(20);

	}

}
