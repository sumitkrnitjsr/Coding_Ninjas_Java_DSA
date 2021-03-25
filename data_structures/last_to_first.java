package data_structures;

// Write a function that moves last element to front in a given singly Linked List

class ListNode<t> {
	public t data;
	 public ListNode<t> next;
	 public ListNode(t data)
	 {
		 this.data=data;
	 }
}

public class last_to_first {
	
	public static ListNode<Integer> lastToFront(ListNode<Integer> head) {
        if(head == null || head.next == null){
            return head;
        }
        
        if(head.next.next == null){
            ListNode<Integer> second = head.next;
            second.next = head;
            head.next = null;
            return second;
        }
        
		ListNode<Integer> tail = head;
        
        while(tail.next != null && tail.next.next != null){
         tail = tail.next;   
        }
        
        ListNode<Integer> last = tail.next;
		last.next = head;
        tail.next = null;
        return last;
        
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
