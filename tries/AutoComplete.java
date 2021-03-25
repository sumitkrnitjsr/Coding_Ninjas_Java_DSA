package tries;
import java.util.ArrayList;

/*
Given n number of words and an incomplete word w. You need to auto-complete that word w.
That means, find and print all the possible words which can be formed using the incomplete word w.
Note : Order of words does not matter.
*/


public class AutoComplete {
	private TrieNode root;
	public int count;
	public AutoComplete() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}
	
	
    private TrieNode findPattern(TrieNode root, String word){
        if(root == null){
            return null;
        }
        
        if(word.length() == 0){
            return root;
        }
        
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        return findPattern(child, word.substring(1));
    }
    
    private void print(TrieNode prefix, String word){
        if(prefix.isTerminating){
            System.out.println(word);
        }
        if(word.length() == 0){
            return;
        }
        
        for(int i = 0;i < 26;i++){
            TrieNode child = prefix.children[i];
            if(child != null){
                char c = ((char)('a' + i));
                String character = Character.toString(c);
                print(child, word + character);
            }
        }
    }
    	
	public void autoComplete(ArrayList<String> input, String word) {

        for(String str: input){
            add(str);
        }
        
        TrieNode prefix = findPattern(root, word);
		if(prefix == null){
            return;
        }
        print(prefix, word);
    }

}