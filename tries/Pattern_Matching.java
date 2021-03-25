package tries;
import java.util.ArrayList;
// Given a list of n words and a pattern p that we want to search. Check if the pattern p is present the given words or not. Return true if the pattern is present and false otherwise.

public class Pattern_Matching {

	private TrieNode root;
	public int count;
	public Pattern_Matching() {
		root = new TrieNode('\0');
	}

	public boolean search(String word){
		return search(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0){
			return true;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		return search(child, word.substring(1));
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

	public boolean patternMatching(ArrayList<String> vect, String pattern) {
        for(int i = 0;i < vect.size();i++){
            String str = vect.get(i);
            for(int j = 0;j < str.length() - 1;j++){
                add(root, str.substring(j));
            }
        }
        return search(pattern);
	}

}
