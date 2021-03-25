package BackTracking;

// Given a number n, find number of numbers that are greater than n using the same set of digits as n. n might have duplicate digits.


public class Numbers_Greater_Than {
	
	public static long numberOfNumbersWithDuplicates(long num){

		// Write your code here
        if(num < 10){
            return 0;
        }
		int length = (int)Math.log10(num) + 1;
        int number[] = new int[length];
        for(int k = length-1; k >=0; k--){
            number[k] = (int)(num%10);
            num /= 10;
        }
        
        long fact[] = new long[length+1];
        fact[0] = 1;
        
        for(int i = 1;i <= length; i++){
            fact[i] = i*fact[i-1];
        }
        
        return numberOfNumbersWithDuplicates(number,0,fact);
	}
    
    
	public static long numberOfNumbersWithDuplicates(int[] number,int index,long[] factorial){

		// Write your code here
        if(index >= number.length){
            return 0;
        }
        
        long count = 0;
        int[] frequency = new int[10];
        
        for(int i = index;i < number.length;i++){
            frequency[number[i]]++;
        }
        
        long fact[] = new long[10];
        fact[0] = 1;
        
        for(int i = 1;i <= 9; i++){
            fact[i] = i*fact[i-1];
        }
        
        
        long repeat = 1;
        
        for(int i = 0;i < 10;i++){
            repeat *= fact[frequency[i]];
        }
        
        int[] visited = new int[10];
        
        for(int i = index+1;i < number.length;i++){
            if(number[index] < number[i] && visited[number[i]] == 0) {
                long index_frequency = frequency[number[i]];
                count = count + ((factorial[number.length - index - 1] * index_frequency)/repeat);
            }
            visited[number[i]] = 1;
        }
        
        count +=  numberOfNumbersWithDuplicates(number,index+1,factorial);
        
        return count;

	}
		
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(numberOfNumbersWithDuplicates(23313));

	}

}
