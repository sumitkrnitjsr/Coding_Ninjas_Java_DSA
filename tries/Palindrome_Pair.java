package tries;
import java.lang.StringBuilder;
import java.util.ArrayList;
/*
Given 'n' number of words, you need to find if there exist any two words which can be joined to make a palindrome or any word, which itself is a palindrome.
The function should return either true or false. You don't have to print anything.
*/


public class Palindrome_Pair {

	private TrieNode root;
	public int count;

	public Palindrome_Pair() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];

		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}

		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0) {
			return root.isTerminating;
		}

		int childIndex=word.charAt(0) - 'a';
		TrieNode child=root.children[childIndex];

		if(child == null) {
			return false;
		}

		return search(child,word.substring(1));

	}

	public boolean search(String word) {
		return search(root,word);
	}

	private void print(TrieNode root, String word) {
		if (root == null) {
			return;
		}
		
		if (root.isTerminating) {
			System.out.println(word);
		}
		
		for (TrieNode child : root.children) {
			if (child == null) {
				continue;
			}
			String fwd = word + child.data;
			print(child, fwd);
		}
	}
	
	public void print() {
		print(this.root, "");
	}





	/*..................... Palindrome Pair................... */


    private boolean isPalindrome(String str) 
    { 
        int i = 0, j = str.length() - 1; 

        while (i < j) { 

            if (str.charAt(i) != str.charAt(j)) 
                return false; 
            i++; 
            j--; 
        } 
  
        return true; 
    } 

    
    public boolean isPalindromePair(ArrayList<String> words) {
        for(String word: words){
            add(word); // Add should not be mixed with searching loop, may miss some search cases
        }
        
		for(String word: words){
            StringBuilder rev = new StringBuilder(word);
            StringBuilder rev2 = new StringBuilder(word.substring(1));
            StringBuilder rev3 = new StringBuilder(word.substring(0, word.length() - 1));
            if(isPalindrome(word) || search(rev.reverse().toString()) || 
               search(rev2.reverse().toString()) || search(rev3.reverse().toString())){
                return true;
            }
 			int end = word.length();
            int start = 0;
            while(start < end){
                if(isPalindrome(word.substring(start, end))){
                    StringBuilder reverse = new StringBuilder(word.substring(0, start)); 
                    if(search(reverse.reverse().toString())){
                        return true;
                    }
                }
                start++;
            }
            
        	end = word.length();
            start = 0;
            while(start < end){
                if(isPalindrome(word.substring(start, end))){
                    StringBuilder reverse = new StringBuilder(word.substring(end, word.length())); 
                    if(search(reverse.reverse().toString())){
                        return true;
                    }
                }
                end--;
            }   
        }
        return false;
	}


	
} 