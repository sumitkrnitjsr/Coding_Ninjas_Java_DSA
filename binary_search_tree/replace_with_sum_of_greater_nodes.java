package binary_search_tree;

/*
Given a binary search tree, you have to replace each node's data with the sum of all nodes which are greater or equal than it. You need to include the current node's data also.
That is, if in given BST there is a node with data 5, you need to replace it with sum of its data (i.e. 5) and all nodes whose data is greater than or equal to 5.
Note: You don't need to return or print, just change the data of each node.
*/


public class replace_with_sum_of_greater_nodes {
	
	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		replaceWithLargerNodesSumR(root, 0);
	}
    
    public static int replaceWithLargerNodesSumR(BinaryTreeNode<Integer> root,int sum){
        if(root == null){
            return sum;
        }
     
        int result = replaceWithLargerNodesSumR(root.right, sum);
        root.data += result;
        return replaceWithLargerNodesSumR(root.left, root.data);
    }

}
