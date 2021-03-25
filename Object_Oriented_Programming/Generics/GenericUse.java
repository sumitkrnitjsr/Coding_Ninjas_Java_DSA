package Object_Oriented_Programming.Generics;

public class GenericUse {
	
	
	static<T> void print(T array[]) {
		
		for(int i = 0;i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		
		GenericPair<Integer, String> c = new GenericPair<>(1,"ab");
		
		c.setFirst(2);
		c.setSecond("cd");
		
		GenericPair c1 = new GenericPair(1,2);
		
		int a1 = 10;
		int a2 = 20;
		int a3 = 30;
		
		GenericPair<Integer, Integer> pair = new GenericPair<>(a1,a2);
		
		GenericPair<GenericPair<Integer, Integer>, Integer> test = new GenericPair<>(pair,a3);
		
		System.out.println(test.getFirst().getFirst());
		System.out.println(test.getFirst().getSecond());
		System.out.println(test.getSecond());
		
		Integer[] ga1 = {10,9,8,7,6,5,4,3,2,1};
		String[] ga2 = {"b","c","d","e","f","g","h","i","j","k","l","m"};
		
		print(ga1);
		print(ga2);
		
	}

}
