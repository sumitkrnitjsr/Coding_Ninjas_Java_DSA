package binary_trees;
import java.util.ArrayList;

// Given a binary tree, return the longest path from leaf to root. Longest means, a path which contain maximum number of nodes from leaf to root.
		
		
public class longest_leaf_to_root_path {
	
	public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
        if(root == null){
            return new ArrayList<Integer>();
        }
        
        ArrayList<Integer> rightPath = longestRootToLeafPath(root.right);
        ArrayList<Integer> leftPath = longestRootToLeafPath(root.left);
		
        if(rightPath.size() > leftPath.size()){
            rightPath.add(root.data);
        }else{
            leftPath.add(root.data);
        }
        
        return (rightPath.size() > leftPath.size())?rightPath:leftPath;
	}
	

}
