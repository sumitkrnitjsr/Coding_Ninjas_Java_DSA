package String;

public class String_Use {
	
	public static void print(String s) {
		
		for(int i=0; i<s.length(); i++) {
			System.out.println(s.charAt(i));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abcdef";
		System.out.println(s + " " + s.length());
		
		System.out.println(s.substring(s.length())); //strange
		
		System.out.println(s.substring(0)); 
		
		System.out.println(s.substring(2,2)); //strange
		
		System.out.println(s.substring(0,s.length())); //strange
		
		print(s);
		
		System.out.println(s.charAt(s.length()) + s.charAt(s.length() - 1));
	}

}
