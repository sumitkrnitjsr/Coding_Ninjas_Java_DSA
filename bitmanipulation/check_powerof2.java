package bitmanipulation;

public class check_powerof2 {

	public static boolean checkPowerOf2(int n) {
        boolean value = false;
        int temp = n;
        while(n%2 == 0) {
        	n = n/2;
        }
        
        if(n == 1) {
        	value = true;
        }else {
        	value = false;
        }
        
        value = ((temp & (temp-1)) == 0);
        		
        return value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
