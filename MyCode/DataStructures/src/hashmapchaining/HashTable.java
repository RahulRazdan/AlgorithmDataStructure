package hashmapchaining;

public class HashTable {

	private HashItem[] hashTable;
	
	
	public HashTable() {
		this.hashTable = new HashItem[Constants.TABLE_SIZE];
	}

	public void put(int key,int value) {
		int hashIndex = hash(key);
		
		if( hashTable[hashIndex] == null) {
			System.out.println("No Collision for key ..."+key);
			hashTable[hashIndex] = new HashItem(key,value);
		}else {
			System.out.println("Key collided ..."+key);
			HashItem existingNextItem = hashTable[hashIndex];
			
			while ( existingNextItem.getNextHashItem() !=null ) {
				existingNextItem = existingNextItem.getNextHashItem();
			}
			
			System.out.println("Found place to insert key "+key);
			existingNextItem.setNextHashItem(new HashItem(key,value));
		}
	}
	
	public int get(int key) {
		
		int internalHashKey = hash(key);
		
		HashItem existingNextItem = hashTable[internalHashKey];
		
		while(existingNextItem != null && existingNextItem.getKey()!=key)
			existingNextItem = existingNextItem.getNextHashItem();
		
		if(existingNextItem !=null)
			return existingNextItem.getValue();
					
		System.out.println("No Key Found...");
		return -1;
	}
	
	private int hash(int key) {
		return key % Constants.TABLE_SIZE;
		//return 1;
	}
}
