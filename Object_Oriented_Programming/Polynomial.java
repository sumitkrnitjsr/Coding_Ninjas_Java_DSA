package Object_Oriented_Programming;

class DynamicArray2 {
	
	private int size = 5;
	private int[] array ;
	
	public DynamicArray2() {
		array = new int[size]; 
	}
    
	private void restructure() {
		
		int[] temp = array;
		size *= 2;
		array = new int[size];
		for(int i = 0;i < temp.length; i++) {
			array[i] = temp[i];
		}
		
	}
	
	public int size() {
		return size;
	}
	
	public void set(int position, int n) {
		if(position < 0) {
			return;
		}
		
        if(position >= size()){
            while(position >= size()) { // Forgot to increment until the size can hold the maximum value
            restructure();
            }
            array[position] = n;
            return;
        }
        
		if(position < size) {
			array[position] = n;
			return;
		}
		
	}
	
	
	public int get(int position) {
		return array[position];
	}
    
    public void print(){
        
        for(int i = 0; i < size; i++){
        
            if(array[i] != 0){
                System.out.print(array[i]);
                if(i != 0){
                    System.out.print("x" + i);
                }
                System.out.print(" ");
            }
            
        }
        
        System.out.println();
        
    }

}



public class Polynomial {

	
	/* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
	 *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
	 *  is already present in the polynomial then previous coefficient is replaced by
	 *  new coefficient value passed as function argument
	*/
    
    DynamicArray2 da;
    
    public Polynomial(){
        da = new DynamicArray2();
    }
    
    public DynamicArray2 getArray(){
        return da;
    }
    
	public void setCoefficient(int degree, int coeff){
	da.set(degree, coeff); //TODO
	}
	
	// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
	public void print(){
        da.print();
	}

	
	// Adds two polynomials and returns a new polynomial which has result
	public Polynomial add(Polynomial p){
         Polynomial result = new Polynomial();

        int max = (p.getArray().size() > this.da.size())?(p.getArray().size()):(this.da.size());
        
        for(int i = 0;i < max;i++){
            int p1 = 0;
            int p2 = 0;
            
            if(this.da.size() > i){ // array index boundary check
                p1 = this.da.get(i);
            }
            
            
            if(p.getArray().size() > i){   // array index boundary check
                p2 = p.getArray().get(i);
            }
            
            result.getArray().set(i,p1  + p2 );
        }
        
        return result;
		
	}
	
	// Subtracts two polynomials and returns a new polynomial which has result
	public Polynomial subtract(Polynomial p){
        Polynomial result = new Polynomial();
        int max = (p.getArray().size() > this.da.size())?(p.getArray().size()):(this.da.size());

            
        for(int i = 0;i < max;i++){
            int p1 = 0;
            int p2 = 0;
        
            if(this.da.size() > i){ // array index boundary check
                p1 = this.da.get(i);
            }
            
            
            if(p.getArray().size() > i){ // array index boundary check
                p2 = p.getArray().get(i);
            }
            
            result.getArray().set(i, p1 - p2);
        }
        
			return result;
	}
	
	// Multiply two polynomials and returns a new polynomial which has result
	public Polynomial multiply(Polynomial p){
        
        DynamicArray2 da_1 = p.da;
        Polynomial result = new Polynomial();
        
        for(int i = 0; i < da_1.size(); i++){
            Polynomial temp = new Polynomial();
         
            if(da_1.get(i) != 0){
             
                for(int j = 0; j < da.size(); j++){
                    
                 if(da.get(j) != 0){
                     temp.setCoefficient((i + j),(da_1.get(i) * da.get(j)));
                 }   
                    
                }
            }
            
            Polynomial added = result.add(temp);
            result = added;
        }
        
        return result;
	}

}

