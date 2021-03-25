package dynamic_programming_2;
import java.util.*;

// Given a 2D array, find the maximum sum rectangle in it. In other words find maximum sum over all rectangles in the matrix.

public class Max_Sum_Rectangle {

public static int kadane(int[] array, int row){
        
        int current  = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0;i < row;i++){
            current += array[i];
            max = (max < current)?current:max;
            current = (current < 0)?0:current;
        }
        
        return max;
    }
    
	public static void main(String[] args) {
		// Write your code here
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] storage = new int[row][col];
        int i,j;
        
        for(i = 0;i < row;i++){
            for(j = 0;j < col;j++){
                storage[i][j] = sc.nextInt();
            }
        }
        
        int sum  = Integer.MIN_VALUE;
        
        for(int left = 0;left < col;left++){
            int[] temp = new int[row];
            for(int right = left; right < col; right++){
                for(i = 0; i < row;i++){
                    temp[i] += storage[i][right];
            }   
                sum = Math.max(sum, kadane(temp, row));
        	}   
        }
        
        System.out.println(sum);
	}



}
