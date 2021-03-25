package binary_search_tree;

/*
Given a Binary Search Tree and two integers k1 and k2, find and print the elements which are in range k1 and k2 (both inclusive).
Print the elements in increasing order.
*/

public class print_elements_in_range {
	
	public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
        
        if(root == null){
            return;
        }
        
        if(k1 < root.data){
            elementsInRangeK1K2(root.left, k1, k2);
        }
        
        if(k1 <= root.data && k2>= root.data){
        	System.out.print(root.data + " ");
        }
        
        if(k2 > root.data){
            elementsInRangeK1K2(root.right,k1,k2);
        }
		
	}

}
