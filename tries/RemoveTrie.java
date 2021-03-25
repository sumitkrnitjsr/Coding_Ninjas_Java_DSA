package tries;


public class RemoveTrie {

	private TrieNode root;
	private int numWords;

	public RemoveTrie() {
		root = new TrieNode('\0');
		numWords = 0;
	}
	

	public void remove(String word){
		if(remove(root, word)) {
			numWords--;
		}
	}
	
	public void removeI(String word) {
		removeI(root, word);
	}
	
	private void removeI(TrieNode root, String word) {
		if(word.length() == 0) {
			root.isTerminating = false;
			return;
		}
		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null) {
			return;
		}
		remove(child, word.substring(1));
		
		// Remove child node only if it is non-terminating and number of children is zero
		if(!child.isTerminating) {
			int countChildren = 0;
			for(int i = 0;i < 26;i++) {
				if(child.children[i] != null) {
					countChildren++;
				}
			}
			if(countChildren == 0) {
				root.children[childIndex] = null;
				child = null;
			}
		}
	}

	private boolean remove(TrieNode root, String word) {
		if(word.length() == 0){
			if(root.isTerminating) {
				root.isTerminating = false;
				return true;
			}
			else {
				return false;
			}
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		boolean ans = remove(child, word.substring(1));
		// We can remove child node only if it is non terminating and its number of children are 0	

		if(!child.isTerminating && child.childCount == 0){
			root.children[childIndex] = null;
			child = null;
			root.childCount--;
		}
		return ans;
	}

	private boolean add(TrieNode root, String word){
		if(word.length() == 0){
			if(root.isTerminating) {
				return false;
			}
			else {
				root.isTerminating = true;
				return true;
			}
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		return add(child, word.substring(1));
	}

	public void add(String word){
		if(add(root, word)) {
			numWords++;
		}
	}
	
	public int countWords() {
		return numWords;
	}
	
}
