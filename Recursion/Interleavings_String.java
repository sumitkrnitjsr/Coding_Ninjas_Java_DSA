package Recursion;

public class Interleavings_String {
	

    static void interleavings(String first, String second, String output){
        
        	if(first.length() < 1 && second.length() < 1){
                System.out.println(output);
                return;
            }
        
        	if(first.length() < 1){
                System.out.println(output + second);
                return;
            }
        
        	if(second.length() < 1){
                System.out.println(output + first);
                return;
            }
        
        	String smallAns_1 = Character.toString(first.charAt(0));
            String smallAns_2 = Character.toString(second.charAt(0));
        
        	interleavings(first.substring(1), second, output + smallAns_1);
        	interleavings(first, second.substring(1), output + smallAns_2);
    
    }
    
    
    
    
	public static void interleavings(String first, String second){
		// Write your code here
		interleavings(first, second, "");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		interleavings("ab","cd");
	}

}
