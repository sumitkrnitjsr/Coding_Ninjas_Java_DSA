package String;

public class String_Immutable_String_Pool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "abc";
		String b = "abcd";
		String c = "abc";
		String d = "abc";
		String e = "abc";
		String f = "abcd";
		String[] array = new String[10];
		array[0] = "abc";
		array[1] = "abcd";
	
		if(a == c) {
			System.out.println("a == c");
		}
		
		if(a == array[0]) {
			System.out.println("a == array[0]");
		}
		
		if(a == d) {
			System.out.println("a == d");
		}
		
		if(a == e) {
			System.out.println("a == e");
		}
		
		if(array[1] == f) {
			System.out.println("array[1] == f");
		}
		
		if(b == f) {
			System.out.println("b == f");
		}

	}

}
