package dynamic_programming_2;

public class LCS {

	public static int lcs(String s, String t) {
		
	if(s.length() < 1 || t.length() < 1) {
		return 0;
	}
	
	if(s.charAt(0) == t.charAt(0)) {
		return 1 + lcs(s.substring(1), t.substring(1));
	}
	
	
	int ans1 = lcs(s, t.substring(1));
	int ans2 = lcs(s.substring(1),t);
	
	return Math.max(ans1,  ans2);
		
	}
	

	public static int lcsM(String s,String t) {
		
		int[][] storage = new int[s.length() + 1][t.length() + 1];
		
		for(int i = 0;i < s.length() + 1;i++) {
			for(int j = 0;j < t.length() + 1;j++) {
				storage[i][j] = -1;
			}
		}
		
		return lcsM(s,t,storage);
	}
	
	
	public static int lcsM(String s,String t,int[][] storage) {
		
		int m = s.length();
		int n = t.length();
		if(storage[m][n] != -1) {
			return storage[m][n];
		}
		
		if(m == 0 || n == 0) {
			storage[m][n] = 0;
			return storage[m][n];
		}
		
		if(s.charAt(0) == t.charAt(0)) {
			storage[m][n] = 1 + lcsM(s.substring(1), t.substring(1), storage);
			return storage[m][n];
		}
		
		int op1 = lcsM(s.substring(1),t);
		int op2 = lcsM(s,t.substring(1));
		
		storage[m][n] = Math.max(op1,  op2);
		
		return storage[m][n];
		
	}
	
	
	public static int lcsDP(String s,String t) {
		
		int[][] storage = new int[s.length() + 1][t.length() + 1];
		
		for(int i = 1;i <= s.length(); i++) {
			
			for(int j = 1; j <= t.length(); j++) {
				if(s.charAt(s.length() - i) == t.charAt(t.length() - j)) {
					storage[i][j] = 1 + storage[i - 1][j - 1];	
				}else {
					storage[i][j] = Math.max(storage[i - 1][j], storage[i][j - 1]);
				}
				
			}
		}
		
		return storage[s.length()][t.length()];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(lcs("dgeiageigeigei","begiageigeifgei"));
		System.out.println(lcsM("dgeiageigeigei","begiageigeifgei"));
		System.out.println(lcsDP("dgeiageigeigei","begiageigeifgei"));

	}

}
