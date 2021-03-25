package binary_search_tree;

/*
Given a binary tree with N number of nodes, check if that input tree is BST (Binary Search Tree). If yes, return true, return false otherwise.
Note: Duplicate elements should be kept in the right subtree.
*/


public class check_binary_tree_is_BST {
	
	public static boolean isBSTWrong(BinaryTreeNode<Integer> root) {

		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        
        if(root == null){
            return true;
        }
        
        if(root.left != null && root.left.data >= root.data){
            return false;
        }
        
        if(root.right != null && root.right.data < root.data){
            return false;
        }
        
        return (isBSTWrong(root.left) && isBSTWrong(root.right));
	}

	public static int minimum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		
		return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
	}
	
	public static int maximum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		
		return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
		
	}
	
	
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
		
		int lMax = maximum(root.left);
		int rMin = minimum(root.right);
		
		if(root.data <= lMax) {
			return false;
		}
		
		if(root.data > rMin) {
			return false;
		}
		
		boolean isLeftBST = isBST(root.left);
		boolean isRightBST = isBST(root.right);
		
		if(isLeftBST && isRightBST) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Pair<Boolean, Pair<Integer, Integer>> isBST2(BinaryTreeNode<Integer> root){
		
		if(root ==  null) {
			Pair<Boolean, Pair<Integer, Integer>> result = new Pair<>();
			result.first = true;
			result.second = new Pair<>();
			result.second.first = Integer.MAX_VALUE;
			result.second.second = Integer.MIN_VALUE;
			return result;
		}
		
		Pair<Boolean, Pair<Integer, Integer>> leftResult = isBST2(root.left);
		
		Pair<Boolean, Pair<Integer, Integer>> rightResult = isBST2(root.right);
		
		int min = Math.min(root.data, Math.min(leftResult.second.first, rightResult.second.first));
		int max = Math.max(root.data, Math.max(leftResult.second.second, rightResult.second.second));
		
		boolean isBST = (root.data > leftResult.second.second) && (root.data <= rightResult.second.first) && leftResult.first && rightResult.first;
	
		Pair<Boolean, Pair<Integer, Integer>> result = new Pair<>();
		result.first = isBST;
		result.second = new Pair<>();
		result.second.first = min;
		result.second.second = max;
		return result;
	}
	
	public static boolean isBSTBest(BinaryTreeNode<Integer> root,int min, int max) {
		
		if(root == null) {
			return true;
		}
		
		if(root.data < min || root.data > max) {
			return false;
		}
		
		boolean left = isBSTBest(root.left, min, root.data - 1);
		boolean right = isBSTBest(root.right, root.data , max);
		
		return (left && right);
		
	}
}
