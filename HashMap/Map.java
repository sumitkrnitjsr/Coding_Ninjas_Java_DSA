package HashMap;
import java.util.ArrayList;
import HashMap.MapNode;


public class Map<K, V> {  // Generic on Key, Value
	
	ArrayList<MapNode<K, V>> buckets;
	int size;
	int numBuckets;
	
	public Map() {
		numBuckets = 5;
		size = 0;
		buckets = new ArrayList<>();
		for(int i=0; i<numBuckets; i++) {
			buckets.add(null);
		}
	}
	
	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		return hashCode%numBuckets; // Compression Function
		
	}
	
	public void insert(K key, V value) {
		
		int bucketIndex = getBucketIndex(key);
		
		MapNode<K,V> head = buckets.get(bucketIndex);
		while(head != null) {
			
			if(head.value.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		head = buckets.get(bucketIndex);
		MapNode<K, V> newNode = new MapNode<>(key, value);
		newNode.next = head;
		buckets.set(bucketIndex, newNode);
		size++;
		
		double loadfactor = (1.0)*size/numBuckets; //to avoid having int division result
		
		if(loadfactor > 0.7) {
			rehash();
		}
	}
	
	private void rehash() {
		
		System.out.println("rehashing: buckets  " + numBuckets + " size = " + size);
		ArrayList<MapNode<K, V>> temp = buckets;
		buckets = new ArrayList<>();
		
		for(int i=0; i<2*numBuckets; i++) {
			buckets.add(null);
		}
		
		size = 0;
		numBuckets = 2*numBuckets;
		
		for(int i=0; i<temp.size() ; i++) {
			
			MapNode<K, V> head = temp.get(i);
			
			while(head != null) {
				K key = head.key;
				V value = head.value;
				insert(key,value);
				head = head.next;
			}
			
		}
		
		
	}
	
	public double loadfactor() {
		return (1.0* size)/numBuckets;
	}

	public V getValue(K key) {
		
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		while(head != null) {
			
			if(head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		
		return null;
	}
	
	public V removeKey(K key) {
		
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		MapNode<K, V> prev = null;
		
		while(head != null) {
			if(head.key.equals(key)) {
				
				if(prev == null) {
					buckets.set(bucketIndex, head.next);
					
				}else {
					
					prev.next = head.next;
				}
				
				size--;
				return head.value;
				
			}
			prev = head;
			head = head.next;
			
		}
		
		return null;
		
	}
	
	public int size() {
		return size;
	}
}
