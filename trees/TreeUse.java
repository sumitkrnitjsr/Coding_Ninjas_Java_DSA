package trees;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class TreeUse {

	public static TreeNode<Integer> takeInput(Scanner sc){
		
		
		System.out.println("Enter next node data");
		int data = sc.nextInt();
		TreeNode<Integer> root 	= new TreeNode<>(data);
		System.out.println("Enter number of children for " + data);
		int childCount = sc.nextInt();
		
		for(int i = 0;i < childCount;i++) {
			TreeNode<Integer> child = takeInput(sc);
			root.children.add(child);
		}
		
		return root;
	}
	
	public static void print(TreeNode<Integer> root) {
		
		String s = root.data + ":";
		
		for(int i = 0;i < root.children.size();i++) {
			s = s + root.children.get(i).data + ",";
		}
		
		System.out.println(s);
		
		for(int i = 0;i < root.children.size();i++) {
			print(root.children.get(i));
		}
	}
	
	public static TreeNode<Integer> takeInputLevel(Scanner sc){
		
		System.out.println(" Enter root data");
		int root_data = sc.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(root_data);
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode<Integer> current = queue.poll();
			System.out.println("Enter number of children for " + current.data);
			int numOfChildren = sc.nextInt();
			for(int i = 0;i < numOfChildren;i++) {
				System.out.println("Enter " + (i + 1) + "th child of " + current.data );
				int childData = sc.nextInt();
				TreeNode<Integer> children = new TreeNode<Integer>(childData);
				current.children.add(children);
				queue.add(children);
			}
			
		}
		
		return root;
	}
	
	public static void printLevelWise(TreeNode<Integer> root){
		
        if(root == null){
            return;
        }
        
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
		System.out.println(root.data);
        for(int j = 0;j < root.children.size();j++){
            TreeNode<Integer> child = root.children.get(j);
            queue.add(child);
        }
        while(true){
            int level_length = queue.size();
            if(level_length == 0){
                return;
            }
            for(int i = 0;i < level_length;i++){
                TreeNode<Integer> current = queue.poll();
                System.out.print(current.data + " ");
            	int numChild = current.children.size();
                for(int j = 0;j < numChild;j++){
                TreeNode<Integer> child = current.children.get(j);
                queue.add(child);
            	}
            }
            System.out.println();
        }
	}
	
	
	public static int numOfNodes(TreeNode<Integer> root) {
	
		if(root == null) {
			return 0;
		}
		
		int count = 1;
		
		for(int i = 0;i < root.children.size();i++) {
			count += numOfNodes(root.children.get(i));
		}
		
		return count;
	}
	
	public static int sumOfAllNode(TreeNode<Integer> root){
        
        if(root == null){
            return 0;
        }
        
        int sum = root.data;
        
        for(int i = 0;i < root.children.size();i++){
            sum += sumOfAllNode(root.children.get(i));
        }
		
        return sum;
	}
	
	public static int numNodeGreater(TreeNode<Integer> root,int x){
        if(root == null){
            return 0;
        }

        int data = root.data;
        int num = (data > x)?1:0;
        
        for(int i = 0;i < root.children.size();i++){
            num += numNodeGreater(root.children.get(i), x);
        }
        
        return num;
	}
	
	public static int largestNode(TreeNode<Integer> root) {
		if(root ==null) {
			return Integer.MIN_VALUE;
		}
		
		int min = root.data;
		
		for(int i = 0;i < root.children.size();i++) {
			int smallAns = largestNode(root.children.get(i));
			min = (min < smallAns)?smallAns:min;
		}
		
		return min;
	}
	
	public static int getHeight(TreeNode<Integer> root){
		if(root == null){
            return 0;
        }
        
        int maxHeight = 0;
        
        for(int i = 0;i < root.children.size();i++){
            int smallHeight = getHeight(root.children.get(i));
            maxHeight = (maxHeight < smallHeight)?smallHeight:maxHeight;
        }
        
        return (maxHeight + 1);
	}
	
	public static int countLeafNodes(TreeNode<Integer> root){

        if(root == null){
            return 0;
        }
        
        int childCount = root.children.size();
        if(childCount == 0){
            return 1;
        }
        
        int totalCount = 0;
        for(int i = 0;i < childCount;i++){
            totalCount += countLeafNodes(root.children.get(i));
        }
		return totalCount;
	}
	
	public static void printDepth(TreeNode<Integer> root, int depth) {
		if(depth < 0) {
			return;
		}
		if(depth == 0) {
			System.out.print(root.data + " ");
			return;
		}
		for(int i = 0;i < root.children.size();i++) {
			printDepth(root.children.get(i), depth - 1);
		}
	}
	
	public static void printPostOrder(TreeNode<Integer> root){
		if( root == null){
            return;
        }
        
        for(int i = 0;i < root.children.size();i++){
            printPostOrder(root.children.get(i));
        }
        
        System.out.print(root.data + " ");
	}
	
	public static void printPreOrder(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		
		for(int i = 0;i < root.children.size();i++) {
			printPreOrder(root.children.get(i));
		}
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(4);
		TreeNode<Integer> e1 = new TreeNode<Integer>(2);
		TreeNode<Integer> e2 = new TreeNode<Integer>(3);
		TreeNode<Integer> e3 = new TreeNode<Integer>(5);
		TreeNode<Integer> e4 = new TreeNode<Integer>(6);
		
		root.children.add(e1);
		root.children.add(e2);
		root.children.add(e3);
		e2.children.add(e4);
		
		Scanner sc = new Scanner(System.in);
		//TreeNode<Integer> root1 = takeInput(sc);
		//print(root1);
		
		TreeNode<Integer> root2 = takeInputLevel(sc);
		print(root2);
		printDepth(root2, 2);

	}

}
