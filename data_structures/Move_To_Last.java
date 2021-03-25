package data_structures;

// Given a linked list and a key in it, the task is to move all occurrences of given key to end of linked list, keeping order of all other elements same.
// Return the updated head of LL.

public class Move_To_Last {
	
public static Node<Integer> func(Node<Integer> head,int n) {
        
        if(head == null || head.next == null){
            return head;
        }
        
		Node<Integer> keybegin = head;
        Node<Integer> temp = head;
        Node<Integer> tail = head;
        while(keybegin.next != null){
            keybegin = keybegin.next;
        }
        tail = keybegin;
        Node<Integer> result = head;
        Node<Integer> prev = head;
       	while(temp != keybegin){
            
            if(temp.data == n){
                if(temp == head){
                    tail.next = temp;
                    head = head.next;
                    temp = temp.next;
                    tail.next.next = null;
                    tail = tail.next;
                    result = head;
                    prev = head;
                }else{
                    tail.next = temp;
                    prev.next = temp.next;
                    temp.next = null;
                    temp = prev.next;
                    tail = tail.next;
                }
            }else{
                prev = temp;
                temp = temp.next;
            }
        }
        
        return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
