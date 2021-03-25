package binary_search_tree;


// Given a binary tree and data of two nodes, find 'LCA' (Lowest Common Ancestor) of the given two nodes in the binary tree.

public class lca_binary_tree {
	
	static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {

        if(root == null){
            return -1;
        }
        
        if(root.data == a || root.data == b){
            return root.data;
        }
        
        int lcaLeft = getLCA(root.left, a, b);
        int lcaRight = getLCA(root.right, a, b);
        if(lcaLeft == -1 && lcaRight == -1){
            return -1;
        }else if(lcaLeft == -1){
            return lcaRight;
        }else if(lcaRight == -1){
            return lcaLeft;
        }
		
        return root.data;
	}
	

}
