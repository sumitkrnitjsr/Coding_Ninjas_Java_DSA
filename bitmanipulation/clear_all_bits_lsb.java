package bitmanipulation;

public class clear_all_bits_lsb {

	public static int clearAllBits(int n, int i) {
		int right = (1 << (i + 1));
        right = right - 1;
        right = ~right;
        return right & n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
