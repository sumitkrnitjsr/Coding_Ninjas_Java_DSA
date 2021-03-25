package bitmanipulation;

public class find_first_set_bit {

	public static int returnFirstSetBit(int n) {
        if(n == 0){
            return 0;
        }
    	int position = 1;
        int m = 1;
 
        while ((n & m) == 0) {
            m = m << 1;
            position++;
        }
        return (1 << (position - 1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
