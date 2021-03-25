package data_structures;

import data_structures.Palindrome_Linked_List.LinkedListNode;

/*
Given a Linked list, swap every pair of nodes to form a new linked list. That is, swap first two nodes, then 2nd two nodes and so on. If the size of linked list is odd, then leave the last node as it is.
You should not create new memory, instead change the references of already created nodes. And swap the entire node, not just their data.
Return the head of updated linked list.
*/

public class Swap_Every_Pair {
	
	
public static LinkedListNode<Integer> swapEveryPair(LinkedListNode<Integer> head) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        if(head.next.next == null){
            head.next.next = head;
            head = head.next;
            head.next.next =  null;
            return head;
        }
        
        LinkedListNode<Integer> first_tail = null;
        LinkedListNode<Integer> second_head = head;
        LinkedListNode<Integer> second_tail = second_head.next;
        LinkedListNode<Integer> third_head = null;
		head = head.next; // wrong judgement head = head.next.next;
        
        while(second_tail != null){
            third_head = second_tail.next;
            second_tail.next = second_head;
            second_head.next = third_head;
            if(first_tail != null){
            first_tail.next = second_tail;
            }
            first_tail = second_head;
            second_head = third_head;
            second_tail = (third_head == null)?null:third_head.next; // Nullpointerexception
        }
        
        return head;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
