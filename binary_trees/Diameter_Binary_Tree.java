package binary_trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Diameter_Binary_Tree {

	private static int height(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	private static int diameter(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		
		int option1 = height(root.left) + height(root.right);
		int option2 = diameter(root.left);
		int option3 = diameter(root.right);
		
		return Math.max(option1, Math.max(option2, option3));
	}
	
	private static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root){
		
		if(root == null) {
			Pair<Integer, Integer> result = new Pair<>();
			result.height = 0;
			result.diameter = 0;
			return result;
		}
		
		Pair<Integer, Integer> left = heightDiameter(root.left);
		Pair<Integer, Integer> right = heightDiameter(root.right);
		int height = 1 + Math.max(left.height, right.height);
		int option1 = left.height + right.height;
		int option2 = left.diameter;
		int option3 = right.diameter;
		
		int diameter = Math.max(option1, Math.max(option2, option3));
		Pair<Integer, Integer> result = new Pair<>();
		result.height = height;
		result.diameter = diameter;
		return result;
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputLevel(sc);
		System.out.println(heightDiameter(root).diameter);
	}

}
