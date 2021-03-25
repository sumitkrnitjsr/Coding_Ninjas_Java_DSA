package binary_search_tree;

// Given a BST, convert it into a sorted linked list. You have to return the head of LL.
class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
    	this.data = data;
	}
}

class Result{
    LinkedListNode head;
    LinkedListNode tail;
}

public class BST_to_sorted_LL {
	
	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
		return constructLinkedListHelper(root).head;
}

public static Result constructLinkedListHelper(BinaryTreeNode<Integer> root){
    
    if(root == null){
        Result res = new Result();
        res.head = null;
        res.tail = null;
        return res;
    }
    
    Result left = constructLinkedListHelper(root.left);
    Result right = constructLinkedListHelper(root.right);
    
    Result res = new Result();
    LinkedListNode current = new LinkedListNode(root.data);
    current.next = right.head;
    // Wrong null assignment res.tail = right.tail;
    if(right.tail == null){
        res.tail = current;
    }else{
        res.tail = right.tail;
    }
    if(left.tail != null){
        left.tail.next = current;
        res.head = left.head;
        return res;
    }
    
    res.head = current;
    
    return res;
}

}
