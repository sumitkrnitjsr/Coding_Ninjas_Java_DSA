package bitmanipulation;

public class clear_all_bits_msb {

	public static int clearAllBits(int n, int i) {
		int right = (1 << (i));
        right = right - 1;
        return right & n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
