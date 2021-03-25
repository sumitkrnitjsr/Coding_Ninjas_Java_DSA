package binary_search_tree;

// Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height in the given binary tree. You have to return the height of largest BST.
 class Result_R{
    boolean isBST;
    int height;
    int min;
    int max;
}

public class largest_bst_in_bt {
	 private static Result_R largestBSTSubtreeHelper(BinaryTreeNode<Integer> root){
		 Result_R res = new Result_R();
	        if(root == null){
	            res.max = Integer.MIN_VALUE;
	            res.min = Integer.MAX_VALUE;
	            res.height = 0;
	            res.isBST = true;
	            return res;
	        }
	        
	        Result_R leftRes = largestBSTSubtreeHelper(root.left);
	        Result_R rightRes = largestBSTSubtreeHelper(root.right);
	        
	        if(root.data > leftRes.max && root.data <= rightRes.min && rightRes.isBST && leftRes.isBST){
	            res.isBST = true;
	            res.max = Math.max(rightRes.max, root.data);
	            res.min = Math.min(leftRes.min, root.data);
	            res.height = Math.max(leftRes.height, rightRes.height) + 1;
	            return res;
	        }
	            
	        res.isBST = false;
	        res.max = Math.max(rightRes.max, root.data);
	        res.min = Math.min(leftRes.min, root.data);
	        res.height = Math.max(leftRes.height, rightRes.height);
	        return res;
	    }
	    
		public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
			// Write your code here
	        return largestBSTSubtreeHelper(root).height;
		}

}
