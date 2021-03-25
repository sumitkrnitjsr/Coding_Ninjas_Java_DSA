package HashMap;

import java.util.HashMap;
import java.util.TreeMap;

public class HashMap_VS_TREEMAP {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> hashMap = new HashMap<>();
		
		hashMap.put("FIRST",1);
		hashMap.put("SECOND", 2);
		hashMap.put("THIRD", 3);
		hashMap.put("Fourth", 4);
		
		for(String key : hashMap.keySet()) {
			System.out.print(key + " " + hashMap.get(key) + " ");
		}
		
		System.out.println("\n");
				
		System.out.println("HashMap above without order and TreeMap below lexicographically ordered");
		
		System.out.println("\n");
		
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		
		treeMap.put("FIRST",1);
		treeMap.put("SECOND", 2);
		treeMap.put("THIRD",3);
		treeMap.put("FOURTH",4);
		
		for(String key : treeMap.keySet()) {
			
			System.out.print(key + " " + treeMap.get(key) + " ");
		}
		
		System.out.println("\n");
		
		HashMap<String,Long> testTime = new HashMap<>();
		
		System.out.println(" Inserting.......");
		long startime = System.currentTimeMillis();
		
		for(long i=0; i<=10000000; i++) {
			testTime.put("value_" + Long.toString(i), i);
		}
		
		long endtime = System.currentTimeMillis();
		
		System.out.println(" Finished......." + (endtime - startime));
		
		startime = System.currentTimeMillis();
		
		System.out.println("\n");
		
		if(testTime.containsKey("value_10000000")) {
			endtime = System.currentTimeMillis();
			System.out.println("contains key 10000000 in " + (endtime - startime));
		}
		
		long starttime = System.currentTimeMillis();
		
		if(testTime.containsValue(10000000l)) {
			endtime = System.currentTimeMillis();
			System.out.println("contains value 10000000 in " + (endtime - starttime));
		}

	}

}
