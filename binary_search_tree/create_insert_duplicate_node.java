package binary_search_tree;

/*
For a given a Binary Tree of type integer, duplicate every node of the tree and attach it to the left of itself.
The root will remain the same. So you just need to insert nodes in the given Binary Tree.
*/

	
public class create_insert_duplicate_node {
	
	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		if(root == null){
            return;
        }
        
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(root.data);
        newNode.left = root.left;
        root.left = newNode;
        insertDuplicateNode(root.left.left); // Unlimited calls StackOverFLow error insertDuplicateNode(root.left);
        insertDuplicateNode(root.right);
	}

}
