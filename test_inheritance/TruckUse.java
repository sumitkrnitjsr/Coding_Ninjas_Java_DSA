package test_inheritance;

import Inheritance.Vehicle;

public class TruckUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Truck tk = new Truck();
		tk.Truck();
		tk.setColor("Brown");
		//tk.print();
		
		Vehicle v;
		//Polymorphism
		int i = 0;
		if(i < 3) {
			v = new Vehicle();
		}else {
			v = new Truck();
		}
		
		
	}

}
