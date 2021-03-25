package dynamic_programming;

// Whis and  Beerus are playing a new game today. They form a tower of N coins and make a move in alternate turns. Beerus plays first. In one step, the player can remove either 1, X, or Y coins from the tower. The person to make the last move wins the game. Can you find out who wins the game?
		

public class Coin_Tower {
	
	public static String findWinner(int n, int x, int y) {
		//Your code goes here
        
        boolean[] tower = new boolean[n+1];
        
        tower[1] = true;
        tower[x] = true;
        tower[y] = true;
        
        for(int i = 2;i <= n; i++){
            
            if(i == x || i == y){
                continue;
            }
            
            boolean result = !tower[i-1];
            
            if(i - x > 0){
                result = result || !tower[i-x];
            }
            
            if(i - y > 0){
                result = result || !tower[i-y];
            }
            
            tower[i] = result;
            
        }
        
        if(tower[n]){
            return "Beerus";
        }
        
        return "Whis";
	}


	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
