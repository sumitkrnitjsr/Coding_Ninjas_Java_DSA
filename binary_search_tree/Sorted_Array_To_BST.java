package binary_search_tree;

/*
Given a sorted integer array A of size n, which contains all unique elements. You need to construct a balanced BST from this input array. Return the root of constructed BST.
Note: If array size is even, take first mid as root.
*/

public class Sorted_Array_To_BST {
	
	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
        return SortedArrayToBST(arr, 0, n-1);
	}

	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int start, int end){
        
        if(start > end){
            return null;
        }
        
        if(start == end){
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(arr[start]);
            return newNode;
        }
        
        int mid = start + ((end - start)/2);
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(arr[mid]);
        newNode.left = SortedArrayToBST(arr, start, mid-1);
        newNode.right = SortedArrayToBST(arr, mid + 1, end);
        
        return newNode;
    }

}
