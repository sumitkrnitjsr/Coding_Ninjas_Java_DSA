package trees;
import java.util.ArrayList;

public class TreeNode<T> {

	public T data;
	public ArrayList<TreeNode<T>> children;
	
	public TreeNode(T element) {
		this.data = element;
		children = new ArrayList<>();
	}
	
}
