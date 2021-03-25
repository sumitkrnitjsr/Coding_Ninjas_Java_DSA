package stacks;
import java.util.Stack;

// Given a stack, sort the elements inside that stack in ascending order using only push and pop operation. You can use one additional stack only.


public class Sort_A_Stack {
	
	
public static void sortStack(Stack<Integer> stack){
		
		Stack<Integer> temp = new Stack<>();
        
        while(!stack.isEmpty()){
            
            int val = stack.pop();
            
            while(!temp.isEmpty() && temp.peek() > val){
                stack.push(temp.pop());
            }
            
            temp.push(val);
        }
        
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
