package Recursion;

public class Merge_Sort {
	
    static void merge(int[] input, int startIndex, int begin, int endIndex){
        
        int size_1 = begin-startIndex;
        int size_2 = endIndex-begin+1;
        
        if(size_1 <=0 || size_2 <= 0){
            return;
        }
        
        int merge[] = new int[size_1+size_2];
        
        int i = startIndex;
        int j = begin;
        int k = 0;
        
        while(i < begin && j <= endIndex){
        	
            if(input[i] <= input[j] ){
                merge[k] = input[i];
                i++;
                k++;
            }
            
            if(input[j] <= input[i]){
                merge[k] = input[j];
                k++;
                j++;
            }
            
        }
        
        while(i < begin){
            merge[k] = input[i];
            i++;
            k++;
        }
        
        while(j <= endIndex){
            merge[k] = input[j];
            k++;
            j++;
        }
        
        
        for( i = 0, j = startIndex; i < merge.length; i++, j++){
        	input[j] = merge[i];    
        }

        
    }
    
    
    
    static void mergeSort(int[] input, int startIndex,int endIndex){
    	
        if(startIndex >= endIndex){
            return;
        }
        
        int mid = (startIndex) + (endIndex - startIndex)/2;
       
        mergeSort(input,startIndex, mid);
        mergeSort(input,mid+1,endIndex);
        
        merge(input,startIndex,mid+1,endIndex);
    }
    
    
	public static void mergeSort(int[] input){
		// Write your code here
        mergeSort(input,0,input.length-1);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int input[] = {8,6,4,3,3,1,0,5,3,4,5};
		mergeSort(input);
		
		for(int i=0; i<input.length; i++) {
			System.out.println(input[i]);
		}

	}

}
