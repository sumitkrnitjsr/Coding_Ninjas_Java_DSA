package HashMap;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Vector;
import java.util.Map;

/*
Given a binary tree, print that binary tree in vertical order.Print the nodes which are at same vertical order in same line separated by space. Print different levels in different lines.
Order of different levels in different lines is not important. But in one level, print the element in pre-order format.
*/


public class Verical_Order_Binary_Tree {
	
	 class BinaryTreeNode<T> {
			T data;
			BinaryTreeNode<T> left;
			BinaryTreeNode<T> right;

			public BinaryTreeNode(T data) {
				this.data = data;
			}
		}
	 
	
	static void traversePreOrder(BinaryTreeNode<Integer> root, Map<Integer, Vector<Integer>> nodes_order, int height) {
		
		
        if(root == null){  //forgot base case
            return;
        }
        
        
		Vector<Integer> level = nodes_order.get(height);
		if(level == null) {
			level = new Vector<Integer>();
		}
		
		level.add(root.data);
		
		nodes_order.put(height, level);
		
		traversePreOrder(root.left, nodes_order, height-1);
		traversePreOrder(root.right, nodes_order, height+1);
		
	}
	 
	 
	public static void printBinaryTreeVerticalOrder(BinaryTreeNode<Integer> root){
		
		Map<Integer, Vector<Integer>> nodes_order = new TreeMap<Integer, Vector<Integer>>();
		
		traversePreOrder(root, nodes_order,0);
		
		for(Integer level : nodes_order.keySet()) {
			
			Vector<Integer> nodes = nodes_order.get(level);
			
			for(Integer value : nodes) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
