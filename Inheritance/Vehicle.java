package Inheritance;

public class Vehicle {
	
	public Vehicle(){
		System.out.println("Vehicle");
	}
	
	protected String color;
	int maxSpeed;
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println("Vehicle color : " + color);
		System.out.println("Vehicle maxSpeed : " + maxSpeed);
	}

}
