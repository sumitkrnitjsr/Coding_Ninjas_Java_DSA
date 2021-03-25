package trees;

// Given a generic tree and an integer n. Find and return the node with next larger element in the Tree i.e. find a node with value just greater than n.
		
public class next_larger_element {
	
	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
		
		if(root == null){
            return null;
        }
        
        TreeNode<Integer> current = root;
        TreeNode<Integer> max = null;
        if(current.data > n){
            max = current;
        }
        
        for(int i = 0;i < root.children.size();i++){
            TreeNode<Integer> larger = findNextLargerNode(root.children.get(i), n);
            if(larger != null && (max == null || larger.data < max.data)){ // NullPointerException Max case
                max =  larger;
            }
        }
		return max;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
