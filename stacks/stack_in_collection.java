package stacks;
import java.util.Stack;

public class stack_in_collection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		
		int[] arr = {1,2,3,4,5,6};
		
		for(int i = 0;i < arr.length; i++) {
			stack.push(arr[i]);
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

}
