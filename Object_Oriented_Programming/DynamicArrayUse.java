package Object_Oriented_Programming;

public class DynamicArrayUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DynamicArray da = new DynamicArray();
		
		for(int i = 0; i < 100;i++) {
			da.add(i + 10);
		}
		
		System.out.println(da.size());
		
		da.set(4,10);
		
		System.out.println(da.get(3));
		System.out.println(da.get(4));
		
		while(!da.isEmpty()) {
		
			System.out.print(da.removelast() + " ");
			System.out.println("size = " + da.size());
		}
		
		

	}

}
