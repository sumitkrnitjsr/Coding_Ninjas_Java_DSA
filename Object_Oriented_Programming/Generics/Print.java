package Object_Oriented_Programming.Generics;

import Object_Oriented_Programming.abstract_classes.Car;
import Object_Oriented_Programming.abstract_classes.CarInterface;
import Object_Oriented_Programming.abstract_classes.Vehicle;

public class Print {
	
	static<T extends Vehicle> void print(T arr[]){
		
		for(int i = 0; i < arr.length; i++) {
			
			arr[i].print();
		}
	}
	
	static<T extends CarInterface> void printInterface(T arr[]){
		
		for(int i = 0; i < arr.length; i++) {
			
			arr[i].print();
		}
	}
	
	static<T extends StudentInterface> void printStudent(T arr[]){
		
		for(int i = 0; i < arr.length; i++) {
			
			arr[i].print();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car c[] = new Car[10];
		
		for(int i = 0; i < 10; i++) {
			c[i] = new Car();
		}

		print(c);
		
		System.out.println("------------------------");
		
		printInterface(c);
		
		
		Student s[] = new Student[10];
		
		for(int i = 0; i < 10; i++) {
			s[i] = new Student();
		}
		
		System.out.println("------------------------");
		
		printStudent(s);
	}

}
