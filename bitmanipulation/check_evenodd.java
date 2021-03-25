package bitmanipulation;

public class check_evenodd {

	public static boolean checkEven(int n) {
        boolean value = false;
        value = ((n & 1) == 0);  
        return value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
