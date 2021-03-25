package binary_trees;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;


/*
Given a "complete" binary tree , print the following pattern using its all nodes.
root element
first element of second level
last element of  of second level
first element of the of the third level
last element of the third level
second element of the third level
second from last element of the third level
..... So on.
*/

public class Print_Specific_Tree_Pattern {
	
	 public static void printSpecificPattern(BinaryTreeNode<Integer>  root){
         if(root == null){
             return;
         }
         Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
         int size = 0;
         ArrayList<ArrayList<Integer>> level_list = new ArrayList<>();
         queue.add(root);
		 while(!queue.isEmpty()){
             size = queue.size();
             ArrayList<Integer> list = new ArrayList<>();
             while(size > 0){
              	BinaryTreeNode<Integer> front = queue.poll();
                 list.add(front.data);
                 if(front.left != null){
                     queue.add(front.left);
                 }
                 if(front.right != null){
                     queue.add(front.right);
                 }
                 size--;
             }
             level_list.add(list);
         }
         
         for(int  i = 0;i < level_list.size();i++){
             int low = 0;
             int high = level_list.get(i).size() - 1;
             int flag = 0;
             while(low <= high){
                 if(flag == 0){
                     System.out.print(level_list.get(i).get(low) + " ");
                     low++;
                 }else{
                    System.out.print(level_list.get(i).get(high) + " ");
                     high--;
                 }
                 flag = 1 - flag;
             }   
         	}
		 }
	 

}
