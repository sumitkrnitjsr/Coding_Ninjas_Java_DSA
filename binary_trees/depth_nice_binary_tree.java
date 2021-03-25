package binary_trees;

/*
The leaves of a nice binary tree are labeled by the letter ‘l’, and other nodes are labeled by the letter ‘n’.
Given the pre-order traversal of a nice binary tree as a string, you are required to find the depth of the tree.
*/

public class depth_nice_binary_tree {
	
	public static int depth(String str){
		return depth(str,0);
	}	
    
    public static int depth(String str, int index){
    	System.out.print("Index :" + index);
        if(index >= str.length() || str.charAt(index) == 'l'){
            return 0;
        }
        
        index++;
        int left = depth(str, index);
        index++;
        int right = depth(str,index);
        // System.out.println(" " + left + " " + right);
        return Math.max(left,right) + 1;
    }
    
    public static void main(String[] args) {
    	System.out.println("ans = " + depth("nnllnlnlnlnl"));
    }

}
