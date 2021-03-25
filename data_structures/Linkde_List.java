package data_structures;
import java.util.Scanner;

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
    	this.data = data;
	}
}

public class Linkde_List {
	
	public static Node<Integer> takeInput(){
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		Node<Integer> head = null;
		Node<Integer> tail = null;
				
		while(data != -1) {
			Node<Integer> newNode = new Node<Integer>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}else {
				tail.next = newNode;
				tail = tail.next;
			}
			data = sc.nextInt();
		}
		
		return head;
		
	}
	
	public static Node<Integer> insert(Node<Integer> head, int data,int pos){
		
		Node<Integer> newNode = new Node<Integer>(data);
		
		if(pos == 0) {
			newNode.next = head;
			return newNode;
		}
		
		int i = 0;
		Node <Integer> temp = head;
		
		while(i < pos-1) {
			i++;
			temp = temp.next;
		}
		
		newNode.next = temp.next;
		temp.next = newNode;
		return head;
	}
	
	public static int length(Node<Integer> head){
        if(head == null){
            return 0;
        }
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        
        return count;
	}
	
	public static void printIthNode(Node<Integer> head, int i){
        if(head == null || i < 0){
            return;
        }
        while(head != null && i != 0){
            head = head.next;
            i--;
        }
        if(head != null){
        System.out.println(head.data);
        }
	}
	
	
	
	public static void print(Node<Integer> head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) {
		//Your code goes here
        if(pos == 0){
            return head.next;
        }
        
        LinkedListNode<Integer> temp = head;
        int i = 0;
        while(temp != null && i < pos - 1){
            temp = temp.next;
            i++;
        }
        
        if(i != pos - 1){
            return head;
        }
        
        if(temp.next != null){ // NullPointerException
        temp.next = temp.next.next;
        }else{
            temp.next = null;
        }
        
        return head;
	}
	
	public static int length(LinkedListNode<Integer> head){
        
        if(head == null){
            return 0;
        }
        
        return 1 + length(head.next);
	}
	
	public static LinkedListNode<Integer> insertR(LinkedListNode<Integer> head, int data, int pos){
        
		if(pos == 0){
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            newNode.next = head; // Forgot to update next node
            return newNode;
        }
		
        if(head == null){
            return head;
        }
        
        head.next = insertR(head.next, data, pos-1);
		return head;
	}
	

	public static Node<Integer> insertR(Node<Integer> head,int pos, int elem){
		
		if(pos == 0) {
			Node<Integer> newNode = new Node<Integer>(elem);
			newNode.next = head;
			return newNode;
		}
		
		if(head == null) {
			return head;
		}
		
		head.next = insertR(head.next, pos-1, elem);
		
		return head;
	}
	
	
	public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) {
    	
        if(head == null){  // Wrong Order
            return head;
        }
        
        if(pos == 0){
            return head.next;
        }
        
        head.next = deleteNodeRec(head.next, pos-1);
        
        return head;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node<Integer> node = new Node<>(10);
		Node<Integer> node_2 = new Node<>(20);
		Node<Integer> node_3 = new Node<>(30);
		node.next = node_2;
		node_2.next = node_3;
		Node<Integer> head = node;
		print(head);
		print(head);
		
		Node<Integer> head_node = takeInput();
		print(head_node);

	}

}
