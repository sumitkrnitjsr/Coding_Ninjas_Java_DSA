package binary_trees;

// For a given postorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.
		
public class construct_postorder_inorder {
	
	public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
		if(postOrder.length < 1){
            return null;
        }
        
        return buildTree(postOrder, inOrder, 0, postOrder.length - 1, 0, inOrder.length - 1);
	}
    
    private static BinaryTreeNode<Integer> buildTree(int[] post,int[] in, int ps,int pe,int is,int ie){
        if(ps > pe || is > ie){
            return null;
        }
        
        int rootData = post[pe];
        int index = is;
        int count = 0;
        while(in[index] != rootData){
            count++;
            index++;
        }
        
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        
        root.left = buildTree(post,in, ps, (ps + count - 1), is, (is + count - 1));
        root.right = buildTree(post,in, (ps + count), pe - 1, (is + count + 1), ie);
        
        return root;
    }


    

}
