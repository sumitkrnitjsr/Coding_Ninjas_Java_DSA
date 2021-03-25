package Object_Oriented_Programming;

public class Complex_Numbers {
	// Complete this class
    
    private int real;
    private int imaginary;
    
    public Complex_Numbers(int real, int imaginary){    
        this.real = real;
        this.imaginary = imaginary;
    }
    
    public int getReal(){
        return real;
    }
    
    public int getImaginary(){
        return imaginary;
    }
    
    public void setReal(int real){
        this.real = real;
    }
    
    public void setImaginary(int imaginary){
        this.imaginary = imaginary;
    }
    
    public void print(){
        System.out.print(real + " ");
        if(imaginary != 0){
            System.out.print("+ i" + imaginary);
        }
        System.out.println();
    }
    
    public void plus(Complex_Numbers c){
        this.real += c.real;
        this.imaginary += c.imaginary;
    }
    
    public static Complex_Numbers plus(Complex_Numbers c1, Complex_Numbers c2){
        int real = c1.real + c2.real;
        int imaginary = c1.imaginary + c2.imaginary;
        
        return new Complex_Numbers(real, imaginary);
    }
    
    public Complex_Numbers conjugate(){
        
        if(imaginary != 0){
            return new Complex_Numbers(real, (-1 * imaginary));
        }
        
        return new Complex_Numbers(real, imaginary);
    }
    
    public void multiply(Complex_Numbers c){
        int real = (this.real * c.real) - (this.imaginary * c.imaginary);
        int imaginary = (this.real * c.imaginary) + (this.imaginary * c.real);
        this.real = real;
        this.imaginary = imaginary;
    }
    
    
	
}

