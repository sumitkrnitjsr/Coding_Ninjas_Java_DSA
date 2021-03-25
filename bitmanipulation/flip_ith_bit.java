package bitmanipulation;

public class flip_ith_bit {
	
	public static int flipIthBit(int n, int i) {
    	return (n ^ (1 << (i)));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(flipIthBit(15,3));
	
	}

}
