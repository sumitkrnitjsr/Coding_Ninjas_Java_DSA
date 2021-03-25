package dynamic_programming_2;

// Given a tetrahedron with verticies A, B, C and D. An ant is standing at vertex D. The ant won't sit idle. It will keep on moving from one vertex to another along some edge of the tetrahedron. Your task is to count the number of ways in which the ant can go from the initial vertex D to itself in exactly n steps. In other words, you are asked to find out the number of different cyclic paths with the length of n from vertex D to itself. As the number can be quite large, you should print it modulo 1000000007 (10^9 + 7).


public class Tetrahedron {
	
	public long solve(int n){
		
		// Write your code here.
        int b = 1;
        int adc  = 0;
        for(int i = 1; i <= n;i++){
            int nb = adc*3;
            int nadc = (adc*2) + b;
            
            b = nb;
            adc = nadc;
        }
        
        return b;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
