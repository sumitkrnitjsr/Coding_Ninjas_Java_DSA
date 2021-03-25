package String;

public class Count_Words {
	
	public static int countWords(String str){
		
		/* Your class should be named Solution
	 	* Don't write main().
	 	* Don't read input, it is passed as function argument.
	 	* Return output and don't print it.
	 	* Taking input and printing output is handled automatically.
		*/

        if(str == null || str.length() < 1){
            return 0;
        }
        
        int spaces = 0;
    	int i;
        
        for(i=0; i<str.length(); i++){  // forgot length() is a function inside string not variable for(i=0; i<str.length; i++){
            if(str.charAt(i) == ' '){
                spaces++;
            }
        }
        
        return spaces+1;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abc dc b a";
		
		String p = null ;
		
		String err = "";
		
		System.out.println(countWords(s));
		
		System.out.println(countWords(p));
		
		System.out.println(countWords(err));

	}

}
