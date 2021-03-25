package trees;

// Given a generic tree, find and return the node with second largest value in given tree. Return NULL if no node with required value is present.
		
class Result_2{
    TreeNode<Integer> max;
    TreeNode<Integer> secondmax;
}
		
public class second_largest_element_tree {
	
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        if(root == null || root.children.size() == 0){
            return null;
        }
        return secondLargest(root).secondmax;
	}
    
    public static Result_2 compare(Result_2 f, Result_2 s){
    	TreeNode<Integer> n1 = f.max;
        TreeNode<Integer> n2 = f.secondmax;
        TreeNode<Integer> m1 = s.max;
        TreeNode<Integer> m2 = s.secondmax;
        
        Result_2 final_r = new Result_2();
        
        if(n1 == null){
            return s;
        }else if(m1 == null){
            return f;
        }
        if(n1.data > m1.data){
            final_r.max = n1;
        }else{
            final_r.max = m1;
        }
        
        if(final_r.max.data == n1.data && final_r.max.data != m1.data){
            if(n2 == null){
                final_r.secondmax = m1;
            }else{
                final_r.secondmax = (n2.data > m1.data)?n2:m1;
            }
        }else if(final_r.max.data == m1.data && final_r.max.data != n1.data){
            if(m2 == null){
                final_r.secondmax = n1;
            }else{
                final_r.secondmax = (m2.data > n1.data)?m2:n1;
            }
        }else{
            if(m2 == null){
                final_r.secondmax = n2;
            }else if(n2 == null){
                final_r.secondmax = m2;
            }
        }
        
        return final_r;
    }
    
    
    public static Result_2 secondLargest(TreeNode<Integer> root){
        
    	Result_2 result = new Result_2();
        result.max = root;
        
        for(int i = 0;i < root.children.size();i++){
        	Result_2 child = secondLargest(root.children.get(i));
            result = compare(result,child);
        }
        
        return result;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
