package Object_Oriented_Programming.abstract_classes;

public abstract class Vehicle implements CarInterface{
	
	public int getmaxSpeed() {
		return 10;
	}
	
	public void print() {
		System.out.println(getmaxSpeed());
	}

}
