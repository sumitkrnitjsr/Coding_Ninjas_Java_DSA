package Object_Oriented_Programming;

public class Fraction_Use {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fraction f = new Fraction(20,30);
		f.print();
		
		f.setNumerator(12);
		int d = f.getDenominator();
		System.out.println(d);
		
		f.print();
		
		f.setNumerator(10);
		f.setDenominator(30);
		f.print();
		
		Fraction f2 = new Fraction(3,4);
		f.add(f2);
		f.print();
		f2.print();
		
		Fraction f3 = new Fraction(4,5);
		f3.multiply(f2);
		f3.print();
		f2.print();
		
		Fraction f4 = Fraction.add(f, f3);
		f.print();
		f3.print();
		f4.print();
		
		
		Fraction f5 = new Fraction(20,-10);
		f5.print();

	}

}
