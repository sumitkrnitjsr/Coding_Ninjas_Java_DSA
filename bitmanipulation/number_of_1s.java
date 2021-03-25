package bitmanipulation;

public class number_of_1s {
	
	public static int numberof1s(int n) {
		int count = 0;
		int temp = n;
		while(n > 0) {
			n = n&(n-1);
			count++;
		}
		count = 0;
		while(temp > 0) {
			int x = temp%2;
			if(x == 1) {
				count++;
			}
			temp /= 2;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
