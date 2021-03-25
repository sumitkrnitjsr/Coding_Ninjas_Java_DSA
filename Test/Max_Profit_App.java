package Test;
import java.util.*;

/*
You have made a smartphone app and want to set its price such that the profit earned is maximised. There are certain buyers who will buy your app only if their budget is greater than or equal to your price.
You will be provided with a list of size N having budgets of buyers and you need to return the maximum profit that you can earn.
*/


		
public class Max_Profit_App {
	
	
	public static int maximumProfit(int budget[]) {
		// Write your code here
        
        if(budget == null || budget.length < 1){
            return 0;
        }
        
        
        Arrays.sort(budget);
        int max_profit = 0;
        
        for(int i=0; i<budget.length; i++){
            int current_profit = budget[i]*(budget.length-i);
            if(current_profit > max_profit){
                max_profit = current_profit;
            }
            
        }
        
        return max_profit;

	}


	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
