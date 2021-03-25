package priority_queue;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Inbuilt_Max_PQ {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder()); // for In Built Max Comparator 
		MinPQComparator minComparator = new MinPQComparator();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(minComparator);
		
		PriorityQueue<String> pqS = new PriorityQueue<String>(new StringComparator());
		String[] str = {"uvta", "zsa", "xy", "w"};
		for(int i = 0;i < str.length;i++) {
			pqS.add(str[i]);
		}
		
		while(!pqS.isEmpty()) {
			System.out.print(pqS.remove() + " ");
		}
	}
}

class MaxPQComparator implements Comparator<Integer>{
	
	public int compare(Integer o1, Integer o2) {
		
		if(o1 > o2) {
			return -1;
		}else if(o1 < o2) {
			return 1;
		}
		return 0;
	}
}

class MinPQComparator implements Comparator<Integer>{
	
	public int compare(Integer o1, Integer o2) {
		
		if(o1 > o2) {
			return 1;
		}else if(o1 < o2) {
			return -1;
		}
		return 0;
	}
}

class StringComparator implements Comparator<String>{
	
	public int compare(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		return l1 - l2;
	}
}