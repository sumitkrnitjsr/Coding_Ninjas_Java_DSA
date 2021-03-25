package dynamic_programming;

// Given an array of n positive integers. The task is to count the number of Arithmetic Progression subsequences in the array. As the answer could be very large, output it modulo 100001.
// Note: Empty sequence or single element sequence is Arithmetic Progression.

public class Number_Of_Aps {

public static int numOfAP(int arr[], int N){
        
        if(N < 3){
            return N + 1; 
        }

        long mod = 100001;
        
        long[][] dif_ap_pos = new long[N][1001];
        long[][] dif_ap_neg = new long[N][1001];
        
        long count = N+1;
        int index = N-3;
        
        int dif = arr[N-1]-arr[N-2];
        
        if( dif < 0){
            dif = dif*(-1);
            dif_ap_neg[N-2][dif] = 1;
        }else{
        	dif_ap_pos[N-2][dif] = 1;
        }
        
        while(index >= 0){
            for(int i = index+1; i < N; i++) {
                dif = arr[i] - arr[index];
                
                if(dif > 0){
                dif_ap_pos[index][dif] = (dif_ap_pos[index][dif] + (dif_ap_pos[i][dif] + 1)%mod)%mod;
                }else{
                    dif = dif *(-1);
                dif_ap_neg[index][dif] = (dif_ap_neg[index][dif] + (dif_ap_neg[i][dif] + 1)%mod)%mod;                    
                }
            }
            index--;
        }
        

        
        for(int i = 0;i < N; i++){
            
            for(int j = 0;j < 1001; j++) {
                count = (count + dif_ap_pos[i][j] + dif_ap_neg[i][j])%mod;
                
            }
        }
        
        return (int)count;
  }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
