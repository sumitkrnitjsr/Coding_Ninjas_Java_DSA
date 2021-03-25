package binary_trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Given a binary tree, write code to create a separate linked list for each level. You need to return the array which contains head of each level linked list.


  class LinkedListNode<T> 
  { 
  		T data; 
  		LinkedListNode<T> next;
  		public LinkedListNode(T data) 	
  		{
   		this.data = data; 
   	} 
   }
 


public class Level_WIse_LinkedList {
	
	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
		if(root ==null){
            return null;
        }
        
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<LinkedListNode<Integer>> listNode = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedListNode<Integer> head = null;
            LinkedListNode<Integer> tail = null;
            while(size > 0){
                BinaryTreeNode<Integer> front = queue.poll();
                LinkedListNode<Integer> newNode = new LinkedListNode<>(front.data);
                if(head == null){
                    head = tail = newNode;
                }else{
                    tail.next = newNode;
                    tail = tail.next;
                }
                if(front.left != null){
                    queue.add(front.left);
                }
                if(front.right != null){
                    queue.add(front.right);
                }
                size--;
            }
            listNode.add(head);
        }
        
        return listNode;
	}
	

}
