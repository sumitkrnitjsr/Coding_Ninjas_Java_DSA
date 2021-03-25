package stacks;
import java.util.Stack;

/*
Afzal has been working with an organization called 'Money Traders' for the past few years. The organization is into the money trading business. His manager assigned him a task. For a given array/list of stock's prices for N days, find the stock's span for each day.
The span of the stock's price today is defined as the maximum number of consecutive days(starting from today and going backwards) for which the price of the stock was less than today's price.
For example, if the price of a stock over a period of 7 days are [100, 80, 60, 70, 60, 75, 85], then the stock spans will be [1, 1, 1, 2, 1, 4, 6].
*/

public class Stock_Span {
	
	
	public static int[] stockSpan(int[] price) {
		int[] span = new int[price.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0;i < price.length;i++){
            
            while(!stack.isEmpty() && price[stack.peek()] < price[i]){
                stack.pop();
            }
            
            int index = stack.isEmpty()?-1:stack.peek();
            
            span[i] = i - index;
            
            stack.push(i);
        }
        
        
        return span;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
