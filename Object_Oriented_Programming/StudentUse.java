package Object_Oriented_Programming;
import java.util.Scanner;

public class StudentUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Student st = new Student();
		Student st_2 = new Student();
		
		st.name = "Sumit";
		st.rollnumber = "123";
		
		st_2.name = "Monu";
		st_2.rollnumber = "231";
		
		
		System.out.println(st.name);
		System.out.println(st_2.name);
		System.out.println(st);
	}

}
