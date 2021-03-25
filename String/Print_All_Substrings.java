package String;

public class Print_All_Substrings {

	
	static void printAllSubstrings(String str, int startIndex, int length) {
	
		if(startIndex >=length) {
			return;
		}
		
		for(int i=startIndex+1; i<=length; i++) {
			System.out.println(str.substring(startIndex,i));
		}
	
		printAllSubstrings(str,startIndex+1,length);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "xyz";
	
		//printAllSubstrings(str,0,str.length());
		
		for(int i=0; i<1000;i++) {
			System.out.print('a');
		}

	}

}
