package bitmanipulation;

/*
You are given an integer Ni. You need to make first set bit of binary representation of N to 0 and return the updated N.
Counting of bits start from 0 from right to left.
*/

public class turn_off_first_set_bit {

	public static int turnOffFirstSetBit(int n) {
		return (n & (n-1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
