package trees;

// In a given Generic Tree, replace each node with its depth value. You need to just update the data of each node, no need to return or print anything.
		
		

public class replace_node_wtih_depth {
	
	public static void replaceWithDepthValue(TreeNode<Integer> root){
		if(root == null){
            return;
        }
        replaceWithDepthValue(root, 0);
	}
	
    public static void replaceWithDepthValue(TreeNode<Integer> root, int depth){
        if(root == null){
            return;
        }
        root.data = depth;
        for(int i = 0;i < root.children.size();i++){
            replaceWithDepthValue(root.children.get(i), (depth + 1));
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
