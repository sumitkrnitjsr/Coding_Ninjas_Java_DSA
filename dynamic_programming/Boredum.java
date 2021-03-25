package dynamic_programming;

/*
Gary is bored and wants to play an interesting but tough game . So he figured out a new board game called "destroy the neighbours" . In this game there are N integers on a board. In one move, he can pick any integer x from the board and then all the integers with value x+1 or x-1 gets destroyed .This move will give him x points.
He plays the game until the board becomes empty . But as he want show this game to his friend Steven, he wants to learn techniques to maximise the points to show off . Can you help Gary in finding out the maximum points he receive grab from the game ?
*/		
		
public class Boredum {

	public int solve(int n,int A[])
	{
        int[] frequency = new int[1001];
        
        for(int i = 0;i < A.length;i++){
            frequency[A[i]]++;
        }
        
        int[] max_sum = new int[1001];
        max_sum[0] = 0;
        max_sum[1] = frequency[1]; //  max_sum[1] = 1; wrong assumption
        
        
        for(int i = 2;i < 1001;i++){
            max_sum[i] = Math.max(max_sum[i-1], (i*frequency[i] + max_sum[i-2]));
        }

        return max_sum[1000];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
