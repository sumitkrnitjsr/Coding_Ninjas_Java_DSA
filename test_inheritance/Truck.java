package test_inheritance;

import Inheritance.Vehicle;

public class Truck extends Vehicle{
	
	Truck(){
		System.out.println("Truck");
		// super(); error
	}
	
	int loadingCapacity;
	
	public void print() {
		super.print();
		setName("Truck");
		System.out.println("color : " + color);
	}
	
	void Truck() {
		System.out.print("Audi");
	}
	
	public void setColor(String c) {
		color = c;
	}

}
