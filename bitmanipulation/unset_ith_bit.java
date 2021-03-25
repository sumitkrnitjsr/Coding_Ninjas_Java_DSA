package bitmanipulation;

/*
You are given two integers N and i. You need to make ith bit of binary representation of N to 0 and return the updated N.
Counting of bits start from 0 from right to left.
*/

public class unset_ith_bit {
	
	public static int turnOffIthBit(int n, int i) {
		return (n & ~(1<<i));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
