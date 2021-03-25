package binary_search_tree;
import java.util.ArrayList;


//  For a given Binary Tree of type integer and a number K, print out all root-to-leaf paths where the sum of all the node data along the path is equal to K.


public class path_sum_root_to_leaf {
	
	 private static void rootToLeafPathSumToK(BinaryTreeNode<Integer> root, int k, int sum, ArrayList<Integer> list){
	        
	        if(root == null){
	            return;
	        }
	        
	        list.add(root.data);
	        
	        if(root.data + sum == k && root.left == null && root.right == null){
	            for(Integer itr: list){
	                System.out.print(itr + " ");
	            }
	            System.out.println();
	        }
	        
	        if(root.left != null){
	        	rootToLeafPathSumToK(root.left, k, sum + root.data, list);    
	        }
	        if(root.right != null){
	            rootToLeafPathSumToK(root.right, k, sum + root.data, list);
	        }
	    
	        list.remove(list.size() - 1); // Wrong action list.remove(root.data)
	    }

		public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
	        ArrayList<Integer> list = new ArrayList<>();
			rootToLeafPathSumToK(root,k,0,list);
		}

}
