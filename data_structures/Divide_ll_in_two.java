package data_structures;

/*
Write a function that takes one list and divides up its nodes to create two smaller lists A and B. The sub lists should be made from alternating elements in the original list.
Nodes should be in the reverse order of which they occurred in the source list.
Print both linked lists in different lines.
*/


public class Divide_ll_in_two {
	
	class ListNode<t> {
		public t data;
		 public ListNode<t> next;
		 public ListNode(t data)
		 {
			 this.data=data;
		 }
	}
	
public static void make2List(ListNode<Integer> head) {
        
		ListNode<Integer> list1 = null;
        ListNode<Integer> list2 = null;
        ListNode<Integer> temp = null;
        
        while(head != null){
            if(list1 != null){
                temp = head.next;
                head.next = list1;
                list1 = head;
                head = temp;
            }else{
                list1 = head;
                temp = head;
                head = head.next;
                temp.next = null;
            }
            
            if(head == null){
                break;
            }
            
            if(list2 != null){
                temp = head.next;
                head.next = list2;
                list2 = head;
                head = temp;
            }else{
                list2 = head;
                temp = head;
                head = head.next;
                temp.next = null;
            }
            
        }
        
		while(list1 != null){
            System.out.print(list1.data + " ");
            list1 = list1.next;
        }
        System.out.println();
        while(list2 != null){
            System.out.print(list2.data + " ");
            list2 = list2.next;
        }
        
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
