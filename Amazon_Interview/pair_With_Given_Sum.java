package Amazon_Interview;
import java.util.*;


class Pair<T, V> {
T first;
V second;

public Pair(T first, V second) {
	this.first = first;
	this.second = second;
}
}


public class pair_With_Given_Sum {
	
	static ArrayList<Pair<Integer, Integer>> twoSumTimeLimitExceeded(ArrayList<Integer> list, int target, int N) {
		ArrayList<Pair<Integer, Integer>> res = new ArrayList<>();
        
        if(N < 2){
            Pair pair = new Pair(-1, -1);
            res.add(pair);
            return res;
        }
        
        HashMap<Integer, Integer> occ = new HashMap<>();
        
        for(int elem : list){
            int num = elem;
            Integer freq = occ.get(num);
            freq = (freq == null)?0:freq;
            freq++;
            occ.put(num, freq);
        }
        
        for(int elem: list){
            int sup = target - elem;
            Integer freq_sup = occ.get(sup);
            Integer freq_elem = occ.get(elem);
            if(freq_sup != null && freq_elem != null){
                if(elem != sup){
                int min_freq = (freq_sup > freq_elem)?freq_elem:freq_sup;
                for(int  i = 1;i <= min_freq;i++){
                    Pair pair = new Pair(elem, sup);
                    res.add(pair);
                }
                occ.remove(elem);
                occ.remove(sup);
            }else{  // Forgot to handle duplicate numbers case
                    int min_freq = freq_elem;
                    if(min_freq > 1){
                    for(int  i = 1;i <= min_freq/2;i++){
                    Pair pair = new Pair(elem, sup);
                    res.add(pair);
                }
                occ.remove(elem);
                    }
                }
            }
        }
        
        if(res.size() == 0){
            Pair pair = new Pair(-1, -1);
            res.add(pair);
        }
        return res;
	}
	
	static ArrayList<Pair<Integer, Integer>> twoSum(ArrayList<Integer> list, int target, int N) {
		ArrayList<Pair<Integer, Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> occ = new HashMap<>();
       for(int i = 0;i < N;i++){
           int rem = target - list.get(i);
           if(occ.containsKey(rem)){
               int count = occ.get(rem);
               Pair pair = new Pair(list.get(i), rem);
               res.add(pair);
               count--;
               if(count > 0){
                   occ.put(rem, count);
               }else{
                   occ.remove(rem);
               }
           }else{
                 Integer count = occ.get(list.get(i));
               	 count = (count == null)?1:count+1;
                 occ.put(list.get(i), count);
           }
       } 
        
        if(res.size() == 0){
            Pair pair = new Pair(-1, -1);
            res.add(pair);
        }
       
        return res;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = -1000000000;
		System.out.println(num);

	}

}
