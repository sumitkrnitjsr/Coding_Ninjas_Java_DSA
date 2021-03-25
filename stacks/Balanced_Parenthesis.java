package stacks;
import java.util.Stack;

// For a given a string expression containing only round brackets or parentheses, check if they are balanced or not. Brackets are said to be balanced if the bracket which opens last, closes first.

public class Balanced_Parenthesis {
	
	  public static boolean isBalanced(String expression) {
	        if(expression.length() == 0){
	            return true;
	        }        
	        if(expression.length() == 1){
	            return false;
	        }
	        Stack<Character> stack = new Stack<>();
	        
	        for(int i = 0;i < expression.length();i++){
	            char c ;
	            
	            switch(expression.charAt(i)){
	                case '{':
	                    
	                case '(':
	                    
	                case '[':
	                    stack.push(expression.charAt(i));
	                    break;
	                    
	                case '}' :
	                    if(stack.isEmpty()){ // forgot empty case
	                        return false;
	                    }
	                    c = stack.pop();
	                    if(c != '{'){
	                        return false;
	                    }
	                    break;
	                case ')':
	                    if(stack.isEmpty()){
	                        return false;
	                    }
	                    c = stack.pop();
	                    if(c != '('){
	                        return false;
	                    }
	                    break;
	                case ']':
	                    if(stack.isEmpty()){
	                        return false;
	                    }
	                    c = stack.pop();
	                    if(c != '['){
	                        return false;
	                    }                    
	                    break;
	            }
	            
	        }
	        
	        if(stack.isEmpty()){
	            return true;
	        }
	        
	        return false;
	    }
	  

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
