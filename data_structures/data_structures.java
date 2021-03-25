package data_structures;

import java.util.ArrayList;

public class data_structures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>(5);
		System.out.println(list.size());
		
		list.add(15);
		list.add(20);
		list.add(25);
		
		System.out.println(list.size());
		
		System.out.println(list.get(2));
		
		list.add(2, 50);
		
		for(int i = 0;i < list.size();i++) {
			System.out.print(list.get(i) + " ");
		}
		
		list.remove(1);
		System.out.println();
		list.set(1, 100);
		for(int elm : list) {
			System.out.print(elm + " ");
		}

	}

}
