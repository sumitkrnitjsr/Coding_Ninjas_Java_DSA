package binary_search_tree;

/*
You are given a Binary Tree of type integer, a target node, and an integer value K.
Print the data of all nodes that have a distance K from the target node. The order in which they would be printed will not matter.
*/

public class print_nodes_At_distance_k {
	
	 public static void print(BinaryTreeNode<Integer> root, int dist){
	        if(root == null){
	            return;
	        }
	        if(dist == 0){
	            System.out.println(root.data + " ");
	            return;
	        }
	        print(root.left, dist-1);
	        print(root.right, dist-1);
	    }
	    
	    public static int nodeAtDistanceK(BinaryTreeNode<Integer> root, int data, int k){
	         
	        if(root == null){
	        	return -1;
	         }
	        
	        if(root.data == data){
	            print(root,k);
	            return k - 1;
	        }
	        
	        int left = nodeAtDistanceK(root.left, data, k);
	        int right = nodeAtDistanceK(root.right, data, k);
	        
	        if(left != -1){
	            if(left == 0){
	                System.out.println(root.data);
	                return -1;
	            }else{
	                print(root.right, left - 1);
	                return left - 1;
	            }
	        }else{
	            
	            if(right != -1){
	                if(right == 0){
	                    System.out.println(root.data);
	                    return -1;
	                }else{
	                    print(root.left, right - 1);
	                    return right  - 1;
	                }
	            }
	        }
	        
	        return -1;
	    }
		public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
				nodeAtDistanceK(root, node, k);
		}

}
