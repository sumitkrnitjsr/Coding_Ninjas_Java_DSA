package data_structures;

// You have been given a singly linked list of integers along with two integers, 'i,' and 'j.' Swap the nodes that are present at the 'i-th' and 'j-th' positions.


public class Swap_I_J_Nodes {
	
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
    
        public LinkedListNode(T data) {
            this.data = data;
        }
    }
    
    
	
	 public static LinkedListNode<Integer> ithNode(LinkedListNode<Integer> head,int index){
	    	for(int i = 0;i < index - 1;i++){
	            head = head.next;
	        }    
	        return head;
	    }
	    
	    
		public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
			//Your code goes here
	        if(i == j){
	            return head;
	        }
	        int max = (i > j)?i:j;
	        int min = (i > j)?j:i;
	        
	        int dif = max-min;
	        boolean neighbour = (dif == 1)?true:false;
	        
	        if(min == 0 && !neighbour){
	            LinkedListNode<Integer> first = head;
	            LinkedListNode<Integer> second_prev = ithNode(head, max);
	            first.next = second_prev.next.next;
	            second_prev.next.next = first.next;
	            head = second_prev.next;
	            second_prev.next = first;
	            return head;
	        }
	        
	        
	        if(min == 0 && neighbour){
	            LinkedListNode<Integer>  second = head.next;
	            head.next = second.next;
	            second.next = head;
	            return second;
	        }
	        
	        if(neighbour){
	            
	            LinkedListNode<Integer> first = ithNode(head, min);
	            LinkedListNode<Integer> second = first.next;
	            LinkedListNode<Integer> third = second.next;
	            first.next = third;
	            second.next = third.next;
	            third.next = second;
	            return head;
	        }
	        
	        LinkedListNode<Integer> first = ithNode(head, min);
	        LinkedListNode<Integer> second = first.next;
	        LinkedListNode<Integer> second_next = second.next;
	        LinkedListNode<Integer> third = ithNode(head, max);
	        LinkedListNode<Integer> fourth = third.next; 
	        LinkedListNode<Integer> fourth_next = fourth.next;
	        
	        first.next = fourth;
	        fourth.next = second_next;
	        third.next = second;
	        second.next = fourth_next;

	        return head;
		}
		
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
