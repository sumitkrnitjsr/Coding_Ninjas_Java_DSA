package bitmanipulation;

public class check_ith_bit {

	public static int checkIthBit(int n, int i) {
    	return (n & (1 << (i)));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkIthBit(15,3)); // non zero
		System.out.println(checkIthBit(15,4)); // zero
	}

}
