package hashmaplineargeneric;

import hashmaplinear.Constants;

@SuppressWarnings("unchecked")
public class HashTable<Key, Value> {

	private Key[] key;
	private Value[] value;
	private int numOfItems;
	private int capacity;
	
	public HashTable() {
		this.key = (Key[]) new Object[Constants.TABLE_SIZE];
		this.value = (Value[]) new Object[Constants.TABLE_SIZE];
		this.numOfItems = 0;
		this.capacity = Constants.TABLE_SIZE;
	}
	
	public HashTable(int capacity) {
		this.key = (Key[]) new Object[capacity];
		this.value = (Value[]) new Object[capacity];
		this.numOfItems = 0;
		this.capacity = capacity;
	}
	
	public int size() {
		return this.numOfItems;
	}
	
	public boolean isEmpty() {
		return this.numOfItems == 0;
	}
	
	public void remove (Key key) {
		
		System.out.println("removing item : "+key);
		
		if(key == null)
			return;
		
		int hashIndex = hash(key);
		
		if(!this.key[hashIndex].equals(key)) {
			hashIndex = (hashIndex+1) % capacity;
		}
		
		this.key[hashIndex] = null;
		this.value[hashIndex] = null;
		
		hashIndex = (hashIndex+1) % capacity;
		numOfItems--;
		
		while(this.key[hashIndex] !=null) {
			
			Key tempKey = this.key[hashIndex];
			Value tempValue = this.value[hashIndex];
			
			this.key[hashIndex] = null;
			this.value[hashIndex] = null;
			
			numOfItems--;
			put(tempKey,tempValue);
			
			hashIndex = (hashIndex+1) % capacity;
			
		}
		
		if(numOfItems <= capacity/3) {
			System.out.println("Reducing to size half ...");
			resize(capacity/2);
		}
	}
	
	public void put(Key key,Value value) {
		
		if(key==null || value == null) 
			return;
		
		if(numOfItems >= capacity * 0.75) {
			System.out.println("Increasing size by double...");
			resize(2*capacity);
		}
		
		int hashIndex = hash(key);
		
		while( this.key[hashIndex] != null) {
			
			if(this.key[hashIndex].equals(key)) {
				this.value[hashIndex] = value;
				return;
			}
			
			System.out.println("Collisiion :'( ");
			hashIndex = (hashIndex+1) % capacity;
		}
		
		this.key[hashIndex] = key;
		this.value[hashIndex] = value;
		numOfItems++;
	}
	
	private void resize(int newCapacity) {
		
		HashTable<Key,Value> newHashTable = new HashTable<>(newCapacity);
		
		for(int i=0 ; i<capacity ; i++) {
			if(this.key[i]!=null)
				newHashTable.put(this.key[i],this.value[i]);
		}
		
		this.key = newHashTable.key;
		this.value = newHashTable.value;
		capacity = newHashTable.capacity;
		numOfItems = newHashTable.numOfItems;
		
		newHashTable = null;
	}

	public Value get(Key key) {
		
		if(key == null) return null;
		
		int internalHashKey = hash(key);
		
		while ( this.key[internalHashKey]!=null && !this.key[internalHashKey].equals(key)) {
			internalHashKey = (internalHashKey+1) % capacity;
		}
		
		if(this.key[internalHashKey] != null)
			return this.value[internalHashKey];
		
		System.out.println("No Key Found...");
		return null;
	}

	public void testHash(Key key) {
		System.out.println("key is " + hash(key));
	}
	private int hash(Key key) {
		return Math.abs(key.hashCode()) % capacity;
	}
}
