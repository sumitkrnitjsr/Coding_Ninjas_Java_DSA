package dynamic_programming;

 // Miss. Noor Rashid is a teacher. She wants to give some chocolates to the students in her class. All the students sit in a line, and each of them has a score according to performance. Noor wants to give at least one chocolate to each student. She distributes chocolates to them such that If two students sit next to each other, then the one with the higher score must get more chocolates. Miss. Noor wants to save money, so she wants to minimize the total number of chocolates.


public class Min_Number_Of_Chocolates {

	public static int getMin(int arr[], int N){
        
        if(N < 1){
            return 0;
        }
 
        int[] choco = new int[N];
        choco[0] = 1;
        
        for(int i = 1;i < N;i++){
 		 if(arr[i] <= arr[i - 1]){
             choco[i] = 1;
        }else{
            choco[i] = choco[i-1]+1;
        }    
        }
    
        
        for(int i = N-2;i >= 0; i--){
            if(arr[i] > arr[i+1] && choco[i] <= choco[i+1]){
                choco[i] = choco[i+1] + 1;
            }
        }
        
        int sum = 0;
        
        for(int i = 0;i < N;i++){
            sum = sum + choco[i];
        }
        
        return sum;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
