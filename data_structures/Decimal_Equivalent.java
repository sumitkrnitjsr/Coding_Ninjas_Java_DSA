package data_structures;

// Given a singly linked list of 0s and 1s, find and return its decimal equivalent.

public class Decimal_Equivalent {
	
	
	public static int decimal(Node<Integer> head) {
        if(head == null){
            return 0;
        }
        
		int length = 1;
        Node<Integer> temp = head;
        while(temp.next != null){
            temp = temp.next;
            length++;
        }
        length = length - 1; // length - 1 wrong judgement
        int decimal = 0;

        temp = head;
        while(temp != null){
            decimal = decimal + (temp.data * ((int)Math.pow(2, length)));
            length--;
            temp = temp.next;
        }
        
        return decimal;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
