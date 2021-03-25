package Object_Oriented_Programming;

public class Private_Student {
	
	private String name;
	private int rollNumber;
	private final String studentCode;
	private static int numberOfStudent; 
	public Private_Student(String name, int roll) {
		System.out.println(this);
		this.name = name;
		this.rollNumber = rollNumber;
		studentCode = name.substring(0,3) + roll + Long.toString(System.currentTimeMillis()).substring(0,5);
		numberOfStudent++;
	}
	
	public int getRollNumber() {
		return rollNumber;
	}
	
	public void setRollNumber(int n) {
		if(n < 0) {
			throw new ArithmeticException("Trying to set wrong value to roll number");
		}
		rollNumber = n;
	}
	
	public static int getNumberOfStudent() {
		return numberOfStudent;
	}

	
	public void setName(String name) throws Exception {
		if(name.contains("sentiment")) {
			throw new Exception("Trying to set wrong value to name");
		}
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void print() {
		System.out.println(name + " : " + rollNumber);
	}
	
	public String getStudentCode() {
		return studentCode;
	}
}
