package Test_BST;

//  Given a BST and an integer K, you need to find the Kth smallest element present in the BST. Return INT_MIN if that is not present in the BST.

public class kth_smallest_node_bst {
	
	 private static int rank = 0;
	 
	public static int kthSmallestNode(BinaryTreeNode<Integer> root,int K){
		if(root == null){
            return -1;
        }
		
        int res = kthSmallestNode(root.left, K);
        
        if(res != -1){
            return res;
        }
        
        rank++;
        
        if(rank == K){
            return root.data;
        }
        
        return kthSmallestNode(root.right, K);
	}

}
