package dynamic_programming_2;

public class MCM {
	
	public static int mcm(int[] p){
		
		// return mcm(p,0, p.length - 1);
		
	    int[][] storage = new int[p.length + 1][p.length + 1];
	    for(int i = 0;i <= p.length; i++){
	        for(int j = 0;j <= p.length; j++){
	            storage[i][j] = -1;
	        }
	    }
	    
	    return mcm(p, 0, p.length - 1, storage);

		}
	    
	    public static int mcm(int[] p,int start,int end){
	        
	    	System.out.println("start" + start + " " + end);
	        if(start == end || start == end - 1){
	            return 0;
	        }
	        
	      
	        
	        int product = Integer.MAX_VALUE;// Wrong initialization int product = 0;
	        
	        
	        
	        for(int i = start + 1;i < end;i++){ // 	        for(int i = start + 1;i <= end;i++){
	        	 System.out.println(start + " " + i);
	            int first = mcm(p, start, i);
	            int second = mcm(p, i, end);
	            int third = (p[start] * p[i] * p[end]);
	            int answer =  first + second + third;
	            product = (product > answer)?answer:product;
	        }
	        
	        return product;
	    }
	    
	    public static int mcm(int[] p,int start,int end,int[][] storage){
	        
	        if(start == end || start >= end - 1){
	            storage[start][end] = 0;
	            return storage[start][end];
	        }
	        
	        if(storage[start][end] != -1){
	            return storage[start][end];
	        }
	        
	        int product = Integer.MAX_VALUE;
	        
	        for(int i = start + 1;i < end;i++){
	            
	            int first = mcm(p, start, i);
	            int second = mcm(p, i, end);
	            int third = (p[start] * p[i] * p[end]);
	            int answer =  first + second + third;
	            product = (product > answer)?answer:product;
	            storage[start][end] = product;
	        }
	        
	        return storage[start][end];
	    }
	    
	    public static int mcmDP(int[] p){
	        
	        int n = p.length;
	        int[][] storage = new int[n][n];
	        
	        for(int i = 0; i < n;i++){
	            storage[i][i] = 0;
	        }
	        
	        for(int l = 2;l < n; l++){
	            for(int i = 1;i < n-l+1;i++){
	                int j = l+i-1;
	                if(j == n){
	                    continue;
	                }
	                storage[i][j] = Integer.MAX_VALUE;
	                for(int k = i; k <= j-1; k++){
	                    int cost = storage[i][k] + storage[k+1][j] + p[i-1]*p[k]*p[j];
	                    if(cost < storage[i][j]){
	                        storage[i][j] = cost;
	                    }   
	                }   
	            }   
	        }
	        
	        return storage[1][n-1];
	    }


	    
	    
	    
	    
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int[] arr = {10, 15, 20, 25};
			System.out.println("answer = " + mcm(arr));

		}

}
