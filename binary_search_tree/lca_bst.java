package binary_search_tree;

// Given a binary search tree and data of two nodes, find 'LCA' (Lowest Common Ancestor) of the given two nodes in the BST.

public class lca_bst {
	static int getLCA(BinaryTreeNode<Integer> node, int a, int b) {

        if(node == null){
            return -1;
        }
        if(node.data == a || node.data == b){
            return node.data;
        }
        
        if(node.data > a && node.data > b){
            return getLCA(node.left, a, b);
        }else if(node.data < a && node.data < b){
            return getLCA(node.right, a, b);
        }
        
        int left = getLCA(node.left, a, b);
        int right = getLCA(node.right,a, b);
        
        if(left != -1 && right != -1){
            return node.data;
        }else if(left == -1){
            return right;
        }else if(right == -1){
            return left;
        }
        
        return -1;
	}

}
