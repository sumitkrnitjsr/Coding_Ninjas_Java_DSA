package data_structures;
import java.util.HashMap;

// Given a two Linked Lists, find out union of both given input lists and return the new Linked List.
		
public class union_of_ll {
	
public static ListNode<Integer> Union(ListNode<Integer> head1,ListNode<Integer> head2) {
        
        if(head1 == null){
            return head2;
        }
        
        if(head2 == null){
            return head1;
        }
        
        HashMap<Integer, Integer> list1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> list2 = new HashMap<Integer, Integer>();
        ListNode<Integer> itr = head1;
        
        while(itr != null){
            int count = list1.containsKey(itr.data)?list1.get(itr.data):0;
            list1.put(itr.data, count+1);
            itr = itr.next;
        }
        
        itr = head2;
        
        while(itr != null) {
            int count = list2.containsKey(itr.data)?list2.get(itr.data):0;
            list2.put(itr.data, count+1);
        	itr = itr.next;
        }
        
        for(int value:list2.keySet()) {
        	
        	if(list1.containsKey(value)) {
        	   list1.put(value, Math.max(list1.get(value), list2.get(value)));	
        	}else {
        		list1.put(value, list2.get(value));
        	}
        }
        
              
        ListNode<Integer> temp = head1;
        ListNode<Integer> prev = null;
        
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head2;
        
        temp = head1;
        
        while(temp != null) {
        	int value = list1.get(temp.data);
        	if(value < 1) {
        		prev.next = temp.next;
        		temp = temp.next;
        	}else {
        		list1.put(temp.data, value - 1);
        		prev = temp;
        		temp = temp.next;
        	}
        }
        return head1;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
