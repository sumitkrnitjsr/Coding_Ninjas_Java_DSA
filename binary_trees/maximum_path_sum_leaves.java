package binary_trees;

/*
Given a binary tree of N nodes, find and return the maximum sum path between two leaves of the given tree.
Given binary tree contains positive values only.
Note: If there is only one leaf in the tree, then return 0 as answer.
*/

class Result{
    long sum;
    long max;
}


public class maximum_path_sum_leaves {
	
	public static long maximumSumLeafPath(BinaryTreeNode<Integer> root) {
		// Forgot to handle case when there is no leaf on one side
        if(root == null){
            return 0;
        }
        return maximumSumLeafPathR(root).max;
	}
    
    public static Result maximumSumLeafPathR(BinaryTreeNode<Integer> root){
        
        Result res = new Result();        
        if(root == null){
            res.sum = 0;
            res.max = 0;
            return res;
        }
        
        if(root.left == null && root.right == null){
            res.sum = root.data;
            res.max = 0;
            return res;
        }
        
        Result resLeft = maximumSumLeafPathR(root.left);
        Result resRight = maximumSumLeafPathR(root.right);
        
        res.sum = Math.max(resLeft.sum,resRight.sum) + root.data;
        if(root.left != null && root.right != null){
            long option = resLeft.sum + resRight.sum + root.data;
        	res.max = Math.max(option, Math.max(resLeft.max, resRight.max));    
        }else{
            res.max = Math.max(resLeft.max, resRight.max);
        }
        
        return res;

    }
    

}
