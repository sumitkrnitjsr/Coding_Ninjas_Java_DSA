package String;

public class Reverse_String_Word_Wise {
	
	static String ReverseStringWordWise(String str, int startIndex,int endIndex) {
		
		if(startIndex >= endIndex) {
			return "";
		}
		
		int wordEndIndex = startIndex;
		
		while(wordEndIndex < endIndex && str.charAt(wordEndIndex) != ' ') {  //while(str.charAt(wordEndIndex) != ' ') StringIndexOutOfBoundsException
			wordEndIndex++;
		}
		
		int temp = wordEndIndex;
		
		while(temp < endIndex && str.charAt(temp) == ' ') {
			temp++;
		}
		
		String get = ReverseStringWordWise(str,temp,endIndex);
		
		
		//System.out.print(str.substring(startIndex,wordEndIndex) + " ");
		
		return get.concat(str.substring(startIndex,wordEndIndex) + " ");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Welcome to Coding Ninjas";
		String value = ReverseStringWordWise(str,0,str.length());
	
		System.out.println(value);
		
		int array[][] = new int[6][3];
		System.out.println(array[0].length);
	}

}
