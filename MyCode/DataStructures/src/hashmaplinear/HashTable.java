package hashmaplinear;

public class HashTable {

	private HashItem[] hashTable;
	
	
	public HashTable() {
		this.hashTable = new HashItem[Constants.TABLE_SIZE];
	}

	public void put(int key,int value) {
		
		if(!isFull()) {
			int hashIndex = hash(key);
			
			while( hashTable[hashIndex] != null) {
				System.out.println("Collisiion :'( ");
				hashIndex = (hashIndex+1) % Constants.TABLE_SIZE;
			}
			hashTable[hashIndex] = new HashItem(key,value);
		}
		else
			System.out.println("Hash Table is FULL for key : "+key);
	}
	
	private boolean isFull() {
		
		for(HashItem item : hashTable) {
			if(item==null)
				return false;
		}

		return true;
	}

	public int get(int key) {
		
		int internalHashKey = hash(key);
		
		while ( hashTable[internalHashKey]!=null && hashTable[internalHashKey].getKey() != key) {
			internalHashKey = (internalHashKey+1) % Constants.TABLE_SIZE;
		}
		
		if(hashTable[internalHashKey] != null)
			return hashTable[internalHashKey].getValue();
		
		System.out.println("No Key Found...");
		return -1;
	}
	
	private int hash(int key) {
		return key % Constants.TABLE_SIZE;
		//return 1;
	}
}
