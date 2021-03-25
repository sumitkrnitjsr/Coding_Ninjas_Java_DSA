package Test_BST;
import java.util.HashMap;
import java.util.ArrayList;

//  Given a binary tree, print all the diagonal elements in a binary tree belonging to same line with slope equal to -1.

class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode left;
	BinaryTreeNode right;

	BinaryTreeNode(T data){
		this.data = data;
	}
}

public class print_diagonal {
	
	 private static void printDiagonal(BinaryTreeNode<Integer> root, int dist, HashMap<Integer, ArrayList<Integer>> diagonal) {
		    
	        if(root == null){
	            return;
	        }
	        
	        ArrayList<Integer> list = diagonal.get(dist);
	        
	        if(list == null){
	            list = new ArrayList<>();
	            list.add(root.data);
	        }else{
	            list.add(root.data);
	        }
	        
	        diagonal.put(dist, list);
	        
	        printDiagonal(root.left, dist + 1, diagonal);
	        printDiagonal(root.right, dist, diagonal);
	    }
	    
	    
		public static void PrintDiagonal(BinaryTreeNode<Integer> root){
			HashMap<Integer, ArrayList<Integer>> diagonal = new HashMap<>();
	        printDiagonal(root, 0, diagonal);
	        
	        for(Integer level : diagonal.keySet()){
	            ArrayList<Integer> res = diagonal.get(level);
	            for(Integer val : res){
	                System.out.print(val + " ");
	            }
	            System.out.println();
	        }
		}

}
