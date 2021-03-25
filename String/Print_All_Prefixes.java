package String;

public class Print_All_Prefixes {
	
	static void printPrefix(String str, int startIndex, int endIndex, int length) {
		
		if(endIndex > length) {
			return;
		}
		
		System.out.println(str.substring(startIndex,endIndex));
		
		printPrefix(str,startIndex,endIndex+1,length);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "abcde";
		
		printPrefix(str,0,1,str.length());

	}

}
