package dynamic_programming_2;
import java.util.*;


/*
We are Given N number of cabinets and every cabinet has a certain amount of files. We want to go through each and every file in these cabinets and for that, we have x number of workers. Distribute the work amongst x workers such that the difference between the number of files that two worker goes through is minimized and the amount that one worker does is maximized.
The constraint is - a worker can go through only cabinets that are adjacent.
Return the maximum amount of work (Work is defined as the amount of files a worker has to go through) a worker is doing in such an arrangement.
*/


public class Fair_Work_Load {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int[] arr = new int[n];
	        int low = Integer.MIN_VALUE;
	        int high = 0;
	        for(int i = 0;i < n;i++){
	            arr[i] = sc.nextInt();
	            high += arr[i];
	            low = (arr[i] > low)?arr[i]:low;
	        }
	       int w = sc.nextInt();
	        while(low < high){
	            int max = low + (high - low)/2;
	            int req = 1;
	            int current = 0;
	            for(int i = 0;i < n;i++){
	                if(current + arr[i] > max){
	                    current = 0;
	                    req++;
	                }
	                current += arr[i];
	            }
	            if(req <= w){
	                high = max;
	            }else{
	                low = max + 1;
	            }
	        }
	        System.out.println(low);   
		}

}
