package HashMap;
import java.util.*;

public class CustomMapUse {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Integer> map = new Map<>();
		for(int i=0; i<20; i++) {
			map.insert("abc"+i,i);
			//System.out.println("i = " + i + " lf = " + map.loadfactor());
		}
		
		map.removeKey("abc3");
		map.removeKey("abc7");
		
		for(int i=0; i<20; i++) {
			
			System.out.println("abc" + i + " : " + map.getValue("abc"+i));
		}
		
		
	}

}
