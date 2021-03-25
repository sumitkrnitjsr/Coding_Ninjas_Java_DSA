package test_ll_queue;
import java.util.HashMap;

// Given a linked list that contain some random integers from 1 to n with many duplicates. You need to replace each duplicate element that is present in the linked list with the values n+1, n+2, and so on (starting from left to right in given LL).
/*
 * 
For eg. if input linked list is
1 3 1 4 4 2 1 -1
updated linked list should be -
1 3 5 4 6 2 7
 * 
 * 
 * 
 * 
 * 
 */
public class replace_duplicate_values {
	
public static void changeLL(LinkedListNode<Integer> head) {
		
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        LinkedListNode<Integer> temp = head;
        
        int max = 0;
        
        while(temp != null){
            Integer occur = map.get(temp.data);
            if(occur == null){
                map.put(temp.data, 1);
            }else{
                map.put(temp.data, occur + 1);
            }
            
            if(max < temp.data){
                max = temp.data;
            }
            
            temp = temp.next;
        }
                    
        while(head != null){
            if(map.get(head.data) > 1){
                map.put(head.data, -1);
            }else if(map.get(head.data) == -1){
                head.data = ++max;
            }
            head = head.next;
        }            
                    

	}

}
