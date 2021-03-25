package binary_search_tree;

public class binary_search_tree {
	
	 private BinaryTreeNode<Integer> root;
	    
	    private BinaryTreeNode<Integer> insert(int data, BinaryTreeNode<Integer> root){
	    	
	        if(root == null){
	            return new BinaryTreeNode<Integer>(data);
	        }
	        
	        if(root.data >= data){
	            root.left = insert(data, root.left);
	            return root;
	        }
	        
	        root.right = insert(data, root.right);
	        return root;
	    }
	    
	    
		public void insert(int data) {
			root = insert(data, root);
		}
	    
	    private BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> root, int data){
	        if(root == null){
	            return null;   
	        }
	        
	        if(root.data == data){
	            if(root.left == null){
	                return root.right;
	            }else if(root.right == null){
	                return root.left;
	            }else{
	                BinaryTreeNode<Integer> temp = root.right; // wrong initialization BinaryTreeNode<Integer> temp = root;
	                while(temp.left != null){
	                    temp = temp.left;
	                }
	                root.data = temp.data;
	                root.right = remove(root.right, root.data); // forgot to assign to left after deletion remove(root.left, root.data);
	            }
	        }else if(root.data > data){
	            root.left = remove(root.left, data);
	        }else{
	            root.right = remove(root.right, data);
	        }
	        return root;
	    }
	    
	    
		public void remove(int data) {
			root = remove(root,data);
		}
		
	    private void printTreeHelper(BinaryTreeNode<Integer> root){
			
	        if(root == null){
	            return;
	        }
	        System.out.print(root.data + ":");
	        if(root.left != null){
	            System.out.print("L:" + root.left.data + ",");
	        }
	        if(root.right != null){
	            System.out.print("R:" + root.right.data);
	        }
	        System.out.println();
	        printTreeHelper(root.left);
	        printTreeHelper(root.right);
	    }
	    
		public void printTree() {
			printTreeHelper(root);
		}
		
	    private boolean search(int data, BinaryTreeNode<Integer> root){
	        
	        if(root == null){
	            return false;
	        }
	        
	        if(root.data == data){
	            return true;
	        }
	        
	        if(root.data < data){
	            return search(data, root.right);
	        }
	        
	        return search(data, root.left);
	    }
	    
		public boolean search(int data) {
			return search(data, root);
		}
	

}
