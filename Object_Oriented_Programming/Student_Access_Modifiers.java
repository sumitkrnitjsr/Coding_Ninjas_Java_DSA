package Object_Oriented_Programming;

public class Student_Access_Modifiers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Private_Student ps = new Private_Student("abc", 1);
		System.out.println(ps);
		System.out.println(Private_Student.getNumberOfStudent());
		ps.print();
		try {
			ps.setName("Sumit");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ps.getName());
		ps.setRollNumber(-1);

	}

}
