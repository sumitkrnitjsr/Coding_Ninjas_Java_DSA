package exception;
import java.io.File;
import java.io.FileNotFoundException;

public class Try_Use {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fraction f = new Fraction();
		
		try {
		f.setDenominator();
		}catch(ZeroDenominatorException ex) {
			System.out.println( "Wrong denominator");
			
		}
		
		String s = "";
		
		File file;
		try {
			file = new File(s);
			
			// file.close();
		}catch(Exception ex) {
			// file.close();
		}finally {
			//file.close();
		}
	}

}
