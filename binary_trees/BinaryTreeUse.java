package binary_trees;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUse {
	
	private static BinaryTreeNode<Integer> takeInput(Scanner sc) {
		int rootData;
		System.out.println("Enter root data");
		rootData = sc.nextInt();
		
		if(rootData == -1) {
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		root.left = takeInput(sc);
		root.right = takeInput(sc);
		
		return root;
	}
	
	private static int countNodes(BinaryTreeNode<Integer> root) {
		if(root == null) {  // Base Case not edge case
			return 0;
		}
		
		return (countNodes(root.left) + countNodes(root.right) + 1);
		
	}
	
	private static BinaryTreeNode<Integer> takeInputLevel(Scanner sc){
		
		System.out.println("Enter root data");
		int rootData = sc.nextInt();
		if(rootData == -1) {
			return null;
		}
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> front = queue.poll();
			System.out.println("Enter left child for " + front.data);
			int childData = sc.nextInt();
			BinaryTreeNode<Integer> childNode = null;
			if(childData != -1) {
				childNode = new BinaryTreeNode<>(childData);
				queue.add(childNode);
				front.left = childNode;
			}

			System.out.println("Enter right child for " + front.data);
			childData = sc.nextInt();
			BinaryTreeNode<Integer> rchildNode = null;
			if(childData != -1) {
				rchildNode = new BinaryTreeNode<>(childData);
				queue.add(rchildNode);
				front.right = rchildNode;
			}
		}
		
		return root;
		
	}
	
	
	private static void print(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		String printString = root.data + " - ";
		if(root.left != null) {
			printString = printString + "L : " + root.left.data + ",";
		}
		
		if(root.right != null) {
			printString = printString + "R : " + root.right.data;
		}
		
		System.out.println(printString);
		
		print(root.left);
		print(root.right);
		
	}
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if(root == null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> front = queue.poll();
            String text = front.data + ":L:";
            if(front.left == null){
                text = text + "-1";
            }else{
                text = text + front.left.data;
                queue.add(front.left);
            }
            text = text +  ",R:";
            if(front.right == null){
                text = text + "-1";
            }else{
                text = text + front.right.data;
                queue.add(front.right);
            }
            System.out.println(text);
        }
		
	}
	
	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
	    if(root == null){
            return false;
        }
        
        if(root.data == x){
            return true;
        }
        
        return(isNodePresent(root.left,x) || isNodePresent(root.right,x));
	}
	
	public static int height(BinaryTreeNode<Integer> root) {
		if(root == null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
	}
	
	
	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
		
        if(root == null){
            return;
        }
        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
	}
	
	public static void preOrder(BinaryTreeNode<Integer> root) {
		if(root == null){
            return;
        }
        
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
	}
	
	public static void postOrder(BinaryTreeNode<Integer> root) {
		if(root == null){
            return;
        }
        
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
	}
	

	public static void inOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
		root.left = node1;
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
		root.right = node2;
		Scanner sc = new Scanner(System.in);
		BinaryTreeNode<Integer> rootNode = takeInputLevel(sc);
		printLevelWise(rootNode);
		sc.close();
	}

}
