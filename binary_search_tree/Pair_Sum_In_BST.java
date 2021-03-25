package binary_search_tree;
import java.util.Stack;

// Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S. You can use extra space of the order of O(log n).

public class Pair_Sum_In_BST {
	
	 private static int nodes(BinaryTreeNode<Integer> root){
	        if(root == null){
	            return 0;
	        }
	        return nodes(root.left) + nodes(root.right) + 1;
	    }
	    
	    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int sum){    
	        if(root == null){
	            return;
	        }
	        
	        int count = nodes(root);
	        int itr = 0;
	        Stack<BinaryTreeNode<Integer>> inOrder = new Stack<>();
	        Stack<BinaryTreeNode<Integer>> revOrder = new Stack<>();
	        BinaryTreeNode<Integer> temp = root;
	        
	        while(temp != null){
	            inOrder.push(temp);
	            temp = temp.left;
	        }
	        
	        temp = root;
	        
	        while(temp != null){
	            revOrder.push(temp);
	            temp = temp.right;
	        }
	        
	        while(itr < count - 1){
	            
	            BinaryTreeNode<Integer> top1 = inOrder.peek();
	            BinaryTreeNode<Integer> top2 = revOrder.peek(); 
	            
	            if(top1.data + top2.data == sum){
	                System.out.println(top1.data + " " + top2.data);
	                temp = top1;
	                inOrder.pop();
	                itr++;
	                if(temp.right != null){
	                    temp = temp.right;
	                    while(temp != null){
	                        inOrder.push(temp);
	                        temp = temp.left;
	                    }
	                }
	                temp = top2;
	                revOrder.pop();
	                itr++;
	                if(temp.left != null){
	                    temp = temp.left;
	                    while(temp != null){
	                        revOrder.push(temp);
	                        temp = temp.right;
	                    }
	                }
	                
	            } else if (top1.data + top2.data > sum){
	                temp = top2;
	                revOrder.pop();
	                itr++;
	                if(temp.left != null){
	                    temp = temp.left;
	                    while(temp != null){
	                    revOrder.push(temp);
	                    temp = temp.right;
	                	}
	                }
	            } else{
	                 temp = top1;
	                inOrder.pop();
	                itr++;
	                if(temp.right != null){
	                    temp = temp.right;
	                    while(temp != null){
	                    inOrder.push(temp);
	                    temp = temp.right;
	                    }
	                }
	            }
	        }
	        
	    }

}
