package Inheritance;

public class Use {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle v = new Vehicle();
		v.print();
		
		Car_With_Inheritance c = new Car_With_Inheritance();
		c.numGears = 10;
		c.color = "Black";
		c.print();
		

	}

}
