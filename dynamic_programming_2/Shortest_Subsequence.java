package dynamic_programming_2;

// Gary has two string S and V. Now, Gary wants to know the length shortest subsequence in S, which is not a subsequence in V.


public class Shortest_Subsequence {
	
	public int solve(String S,String V){
        
		if(S.length() == 0){
	        return Integer.MAX_VALUE;
	    }
	    
	    if(V.length() == 0){
	        return 1;
	    }
	        
	    int op1 = solve(S.substring(1),V);
	    int i;
	    for(i = 0;i < V.length();i++){
	        if(S.charAt(0) == V.charAt(i)){
	            break;
	        }
	    }
	        
	    if(i == V.length()){ // Forgot to check for overflow case
	        return 1;
	    }
	        
	    int op2 = solve(S.substring(1), V.substring(i+1)); 
	        
	    op2 = (op2 != Integer.MAX_VALUE)?(op2+1):op2;
	    
	    return Math.min(op1,op2);
			
		}
	
	
	public int solveM(String S,String V){
        
        int[][] storage = new int[S.length() + 1][V.length() + 1];	  
			
        return solveM(S, V, storage, 0, 0);
	}
    
    public int solveM(String s, String v,int[][] storage,int index1,int index2){
        
        if(index1 == s.length()){
            storage[index1][index2] = Integer.MAX_VALUE;
            return storage[index1][index2];
        }
        
        if(index2 == v.length()){
            storage[index1][index2] = 1;
            return storage[index1][index2];
        }
        
        if(storage[index1][index2] != 0){
            return storage[index1][index2];
        }
        
        int op1 = solveM(s,v,storage,index1 + 1, index2);
        
        int i;
	    for(i = index2;i < v.length();i++){
	        if(s.charAt(index1) == v.charAt(i)){
	            break;
	        }
	    }
        
        if(i == v.length()){ // Forgot to check for overflow case
            storage[index1][index2] = 1;
	        return 1;
	    }
        
	    int op2 = solveM(s,v, storage, index1 + 1, i + 1);
	    op2 = (op2 != Integer.MAX_VALUE)?(op2+1):op2;
        
        storage[index1][index2] =  Math.min(op1,op2);
        
        return storage[index1][index2];
        
    }
    
	public int solveDP(String S,String V){
	    int[][] storage = new int[S.length() + 1][V.length() + 1];
	    for(int i = 0;i <= S.length();i++){
	        storage[i][0] = 1;
	    }
	        
	    for(int i = 0;i <= V.length();i++){
	        storage[0][i] = Integer.MAX_VALUE;
	    }
	        
	    for(int i = 1;i <= S.length();i++){
	        
	        for(int j = 1;j <= V.length(); j++){
	            int pos;
	            for(pos = j-1; pos >=0; pos--){
	                if(V.charAt(pos) == S.charAt(i - 1)){
	                    break;
	                }
	            }
	            if(pos == -1){
	                storage[i][j] = 1;
	            }else{
	                int value = storage[i - 1][pos];
	                value = (value == Integer.MAX_VALUE)?value:(value+1);
	                storage[i][j] = Math.min(storage[i-1][j],value);
	            }
	        }
	    }
	            return storage[S.length()][V.length()];
	}
	
	
    
    
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
