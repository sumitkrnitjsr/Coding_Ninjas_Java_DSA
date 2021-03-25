package binary_search_tree;

public class search_element_bst {
	
	public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
        
        if(root == null){
            return false;
        }
        
        if(root.data == k){
            return true;
        }
        
        if(root.data > k){
            return searchInBST(root.left,k);
        }
        
        if(root.data < k){
            return searchInBST(root.right,k);
        }
		return false;
	}

}
