package trees;

// Given a tree, find and return the node for which sum of data of all children and the node itself is maximum. In the sum, data of node itself and data of immediate children is to be taken.
		
class Result{
    TreeNode<Integer> node;
    int sum;
}

public class node_with_max_child_sum {
	
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		if(root == null){
            return null;
        }
        return maxSumNodeR(root).node;
	}
    
    public static int sum(TreeNode<Integer> node){
        int sum = node.data;
        for(int i = 0;i < node.children.size();i++){
            sum += node.children.get(i).data;
        }
        return sum;
    }
    
    public static Result maxSumNodeR(TreeNode<Integer> root){
	
        Result res = new Result();
        res.node = root;
        res.sum = sum(root);
        
        for(int i = 0;i < root.children.size();i++){
            Result child = maxSumNodeR(root.children.get(i));
            if(child.sum > res.sum){
                res.node = child.node;
                res.sum = child.sum;
            }
        }
        
        return res;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
