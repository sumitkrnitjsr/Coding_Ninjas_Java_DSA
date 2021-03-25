package stacks;
import java.util.Stack;

// Given an infix expression S in the form of a string. You need to convert and print that input expression in postfix form. After that, evaluate and print the result of given expression in next line.


public class Infix_to_Postfix {
	
	  public static int precedence(char ch){
	        
	        switch(ch){
	            case '+' :
	            case '-' :
	                return 1;
	                
	            case '*' :
	            case '/' :
	                return 2;
	                
	            case '^' :
	                return 3;
	        }
	        
	        return -1;
	    }

		public static void evaluatePostfix(String input){
	        
	        String value = "";
	        Stack<Character> stack = new Stack<Character>();
	        
	        for(int i = 0;i < input.length();i++){
	            
	            char c = input.charAt(i);
	            
	            if(Character.isLetterOrDigit(c)){
	                value = value + c;
	            }else if(c == '('){
	                stack.push(c);
	            }else if(c == ')'){
	                
	                while(!stack.isEmpty() && stack.peek() != '('){
	                    value = value + stack.pop();
	                }
	                
	                stack.pop();
	            }else{
	                
	                while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek())){
	                    value = value + stack.pop();
	                }
	    
	             	stack.push(c);   
	            } 
	        }
	        
		
	        while(!stack.isEmpty()){
	            value = value + stack.pop();
	        }
	        
	        System.out.println(value);
	        
	        
	        for(int i = 0; i < value.length();i++){
	            
	            char c = value.charAt(i);
	            
	            if(Character.isDigit(c)){
	                stack.push(c);
	            }else{
	                char v1 = stack.pop();
	                char v2 = stack.pop();
	                int val1 =  v1 - '0';
	                int val2 = v2 - '0';
	                int v = 0;
	                switch(c){
	                    case '+' :
	                        v = (val1 + val2);
	                        stack.push((char)('0' + v));
	                        break;
	                    case '-' :
	                        v =  val2 - val1;
	                        stack.push((char)('0' + v));
	                        break;
	                    case '/' :
	                        v = val2/val1;
	                        stack.push((char)('0' + v));
	                        break;
	                    case '*' :
	                        v = val2*val1;
	                        stack.push((char)('0' + v));
	                        break;
	                }
	            }
	            
	            
	            
	            
	        }
			char result = stack.pop();
	        System.out.println((int)(result - '0'));
		}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
