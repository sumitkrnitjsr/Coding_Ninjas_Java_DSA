package Test_BST;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

/*
Given a generic tree, return the level number, which is having maximum number of nodes(root is level 0).
Note : If there are multiple levels having maximum number of nodes, print the level which comes first.
*/

class TreeNode<T> {
	T data;
	ArrayList<TreeNode<T>> children;

	TreeNode(T data){
		this.data = data;
		children = new ArrayList<TreeNode<T>>();
	}
}


public class level_with_maximum_nodes {
	
public static int maxLevel(TreeNode<Integer> root){
		
		if(root == null){
            return 0;
        }
        
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(root);
        int max_size = 1;
        int max_level = 0;
        int level = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            if(size > max_size){
                max_size = size;
                max_level = level;
            }
            for(int i = 0;i < size;i++){
                TreeNode<Integer> front = queue.poll();
                ArrayList<TreeNode<Integer>> child = front.children;
                for(int j = 0;j < child.size();j++){
                    queue.add(child.get(j));
                }
            }
            
        }
        
        return max_level;
	}

}
