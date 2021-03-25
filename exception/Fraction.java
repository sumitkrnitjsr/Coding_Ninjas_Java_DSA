package exception;

public class Fraction {
	
	int numerator;
	int denominator;
	
	public void setDenominator(int d)throws Exception {
		
		if(d == 0) {
			Exception e = new Exception("Denominator can't be 0");
			throw e;
		}
		
		this.denominator = d;
	}
	
	public void setDenominator()throws ZeroDenominatorException {
		
		if(denominator == 0) {
			ZeroDenominatorException e = new ZeroDenominatorException();
			throw e;
		}
	}


}
