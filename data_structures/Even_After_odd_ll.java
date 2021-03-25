package data_structures;

// For a given singly linked list of integers, arrange the elements such that all the even numbers are placed after the odd numbers. The relative order of the odd and even terms should remain unchanged.


public class Even_After_odd_ll {
	
	public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> temp = head;
        LinkedListNode<Integer> ohead = null;
        LinkedListNode<Integer> otail = null;
        LinkedListNode<Integer> ehead = null;
        LinkedListNode<Integer> etail = null;
        
        while(temp != null){
            if(temp.data%2 == 0){
                
                if(ehead == null){
                    ehead = temp;
                    etail = temp;
                }else{
                    etail.next = temp;
                    etail = temp;
                }
                
            }else{
                
                if(ohead == null){
                    ohead = temp;
                    otail = temp;
                }else{
                    otail.next = temp;
                    otail = temp;
                }
                
            }
            temp = temp.next;
        }
        
        if(etail != null){
            etail.next = null;
        }
        
        if(otail != null){
            otail.next = null;
        }
        
        if(ohead == null){
            return ehead;
        }
        
        otail.next = ehead;
        return ohead;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
