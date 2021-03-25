package binary_trees;

// For a given preorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.
		
		
public class construct_preorder_inorder {
	
	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        if(preOrder.length < 1 || inOrder.length < 1){
            return null;
        }
		
        return buildTree(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
	}
    
    private static BinaryTreeNode<Integer> buildTree(int[] pre,int[] in,int ps,int pe,int is, int ie){
        
        if(ps > pe || is > ie){
            return null;
        }
        
        int root = pre[ps];
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(root);	
        if(is == ie){   // Forgot no children case
            return newNode;
        }
        
        int rootIndex = is;
        int count = 1;
        while(in[rootIndex] != pre[ps]){
            rootIndex++;
            count++;
        }
        
        
        newNode.left = buildTree(pre,in,(ps + 1),(ps + count - 1),is,rootIndex - 1);
        newNode.right = buildTree(pre, in,(ps + count),pe, (rootIndex + 1),ie);  // Wrong index calculations
        return newNode;
    }
    

}
