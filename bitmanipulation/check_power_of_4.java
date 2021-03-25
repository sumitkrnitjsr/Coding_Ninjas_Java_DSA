package bitmanipulation;

public class check_power_of_4 {

	public static boolean isPowerOf4(int n) {
        int count = 0;
        int x = n & (n-1);
        if(n > 0 && x == 0){
            while(n > 1){
                n >>= 1;
                count++;
            }
            return ((count & 1) == 0);
        }
        return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
