package Object_Oriented_Programming;

public class Fraction {
	
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator,int denominator) {
		if(denominator == 0) {
			throw new ArithmeticException("Wrong denominator value");
		}
		
		if(numerator < 0 && denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
		
		if(denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
		
		this.numerator = numerator;
		this.denominator = denominator;
		simplify();
	}
	
	private int findHCF(int min,int max) {
		if(min < 2) {
			return 1;
		}
		
		int remainder = max%min;
		if(remainder == 0) {
			return min;
		}
		return findHCF(remainder,min);
		
	}
	
	private void simplify() {
		if(numerator < 0 && denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
		
		if(denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
		
		int num = Math.abs(numerator);
		int denom = Math.abs(denominator);
		
		int min = (num < denom)?num:denom;
		int max = (min == num)?denom:num;
		int gcm = findHCF(min,max);
		numerator = numerator/gcm;
		denominator = denominator/gcm;
	}
	
	
	public void setNumerator(int numerator) {
		this.numerator = numerator;
		this.simplify();
	}
	
	public void setDenominator(int denominator) {
		if(denominator == 0) {
			throw new ArithmeticException("Wrong denominator value");
		}
		this.denominator = denominator;
		this.simplify();
	}
	
	public void print() {
		System.out.print(numerator);
		if(denominator != 1) {
			System.out.print("/" + denominator);
		}
		System.out.println();
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public void add(Fraction f) {
		
		numerator = (this.numerator * f.getDenominator()) + (this.denominator * f.getNumerator());
		denominator *= f.getDenominator();
		simplify();
	}

	public void multiply(Fraction f) {
		
		numerator = (this.numerator * f.getNumerator());
		denominator *= f.getDenominator();
		simplify();
	}
	
	public static Fraction add(Fraction f1, Fraction f2) {

		int numerator = (f1.getNumerator() * f2.getDenominator()) + (f1.getDenominator() * f2.getNumerator());
		int denominator = f1.getDenominator() * f2.getDenominator();
		
		return new Fraction(numerator, denominator);
	}
	
}
