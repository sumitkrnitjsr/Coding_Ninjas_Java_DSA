package binary_trees;

// Given a binary tree having N nodes, print its boundary traversal.


public class boundary_traversal {
	
	 public static void solveLeft(BinaryTreeNode<Integer> node){
	        if(node == null){
	            return;
	        }
	        if(node.left != null){
	            System.out.print(node.data + " "); // Inside non null check to avoid duplicates
	            solveLeft(node.left);
	        }else if (node.right != null){
	            System.out.print(node.data + " ");
	            solveLeft(node.right);
	        }
	    }
	    
	    public static void solveRight(BinaryTreeNode<Integer> root){
	        if(root == null){
	            return;
	        }
	        
	        if(root.right != null){
	            solveRight(root.right);
	            System.out.print(root.data + " ");
	        }else if(root.left != null){
	            solveRight(root.left);
	            System.out.print(root.data + " ");
	        }
	          
	        
	    }
	    
	    public static void solveLeaves(BinaryTreeNode<Integer> root){
	    	if(root == null){
	            return;
	        }    
	        
	        solveLeaves(root.left);
	        if(root.left == null && root.right == null){
	            System.out.print(root.data + " ");
	        }
	        solveLeaves(root.right);
	        
	    }
	    
		public static void solve(BinaryTreeNode<Integer> root){
			if(root == null){
	            return;
	        }
	        
	        System.out.print(root.data + " ");
	        
	        solveLeft(root.left);
	        solveLeaves(root.left);
	        solveLeaves(root.right);
	        solveRight(root.right);
		}
		

}
