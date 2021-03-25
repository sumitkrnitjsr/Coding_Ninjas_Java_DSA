package stacks;
import java.util.Stack;

/*
For a given expression in the form of a string, find the minimum number of brackets that can be reversed in order to make the expression balanced. The expression will only contain curly brackets.
If the expression can't be balanced, return -1.
*/


public class Minimum_Bracket_Reversal {
	
	

public static int countBracketReversals(String input) {
        
        if(input.length()%2 != 0){
            return -1;
        }
        
		Stack<Character> stack = new Stack<>();
        
        for(int i = 0;i < input.length();i++){
            char c = input.charAt(i);
            if(c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty() || stack.peek() == '}'){
                    stack.push(c);
                }else{
                    stack.pop();
                }
            }
        }
        
        int count = 0;
        while(!stack.isEmpty()){
            char c1 = stack.pop();
            char c2 = stack.pop();
            if(c1 == c2){
                count++;
            }else{
                count = count + 2;
            } 
            
        }
        return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
