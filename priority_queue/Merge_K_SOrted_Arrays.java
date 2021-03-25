package priority_queue;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;
/*
Given k different arrays, which are sorted individually (in ascending order). You need to merge all the given arrays such that output array should be sorted (in ascending order).
Hint : Use Heaps.
*/

class Triplet {
    int elem;
    int arr;
    int index;
}

class TripletComparator implements Comparator<Triplet>{
     public int compare(Triplet o1, Triplet o2){
        Integer first = o1.elem;
        Integer second = o2.elem;
        return first.compareTo(second);
    }
}


public class Merge_K_SOrted_Arrays {
	
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>(new TripletComparator());
        ArrayList<Integer> list = new ArrayList<Integer>();
  
        int i = 0;
        for(;i < input.size();i++){
            Triplet trp = new Triplet();
            if(input.get(i).size() == 0){
                continue;
            }
            trp.elem = input.get(i).get(0);
            trp.arr = i;
            trp.index = 0;
            pq.add(trp);
        }

        while(!pq.isEmpty()){
        	Triplet out = pq.remove();
            list.add(out.elem);
            int nextIndex = out.index + 1;
            if(nextIndex < input.get(out.arr).size()){
                Triplet temp = new Triplet();
                temp.elem = input.get(out.arr).get(nextIndex);
                temp.arr = out.arr;
                temp.index = nextIndex;
                pq.add(temp);
            }
        }
        
        return list;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
