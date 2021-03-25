package stacks;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

}


public class Stack_LL {

	private Node head;
    private int size;
    
    public Stack_LL() {
        //Implement the Constructor
        head = null;
        size = 0;
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        //Implement the getSize() function
        return size;
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        return (getSize() == 0);
    }

    public void push(int element) {
        //Implement the push(element) function
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        size++; // forgot to update size
    }

    public int pop() {
        //Implement the pop() function
        if(head == null){
            return -1;
        }
        
        int temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    public int top() {
        //Implement the top() function
        if(head == null){
            return -1;
        }
        
        return head.data;
    }
    
}
