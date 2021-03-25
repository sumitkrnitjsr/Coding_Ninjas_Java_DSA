package binary_search_tree;
import java.util.ArrayList;
/*
Given a BST and an integer k. Find and return the path from the node with data k and root (if a node with data k is present in given BST) in a list. Return empty list otherwise.
Note: Assume that BST contains all unique elements.
*/


public class Find_Path_BST {
	
	public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
        if(root == null){
            return null;
        }
        ArrayList<Integer> result = null;
        if(root.data == data){
            result = new ArrayList<>();
            result.add(data);
            return result;
        }
        
        if(root.data > data){
            result = getPath(root.left, data);
        }else{
            result = getPath(root.right,data);
        }
            
        if(result != null){
            result.add(root.data);
        }
        return result;
	}
	
	public static ArrayList<Integer> getPathBT(BinaryTreeNode<Integer> root, int data){
		
		if(root == null) {
			return null;
		}
		
		if(root.data == data) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(data);
			return list;
		}
		
		ArrayList<Integer> result = getPathBT(root.left, data);
		if(result != null) {
			result.add(root.data);
			return result;
		}
		
		result = getPathBT(root.right, data);
		if(result != null) {
			result.add(root.data);
			return result;
		}
		
		return null;
	}

}
