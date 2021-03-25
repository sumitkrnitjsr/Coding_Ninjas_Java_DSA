package binary_search_tree;
import java.util.Arrays;

// Given a binary tree and an integer S, print all the pair of nodes whose sum equals S.

public class Pair_Sum_Binary_Tree {
	
	 static int[] treeToArray(BinaryTreeNode<Integer> root){
	        if(root == null){
	            return new int[0];
	        }
	        int[] left = treeToArray(root.left);
	        int[] right = treeToArray(root.right);
	        int[] result = new int[ left.length + right.length + 1];
	        int index = 0;
	        for(int i = 0;i < left.length;i++, index++){
	            result[index] = left[i];
	        }
	        for(int j = 0;j < right.length;j++,index++){
	            result[index] = right[j];
	        }
	        result[index] = root.data;
	        return result;
	    }
	    


		static int pairSum(BinaryTreeNode<Integer> root, int sum) {
			if(root == null){
	            return 0;
	        }

	        int[] array = treeToArray(root);
	        Arrays.sort(array);

	        int left = 0;
	        int right = array.length - 1;
	        
	        while(left < right){
	            if(array[left] + array[right] > sum){
	                right--;
	            }else if(array[left] + array[right] < sum){
	                left++;
	            }else{
	                System.out.println(array[left] + " " + array[right]);
	                left++;
	            }
	            
	        }
	        return 0;
		}
		

}
