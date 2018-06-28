package hashmaplinear;

public class App {

	public static void main(String[] args) {
		
		HashTable hashTable = new HashTable();
		
		hashTable.put(1, 10);
		hashTable.put(2, 20);
		hashTable.put(3, 40);
		hashTable.put(4, 30);
		hashTable.put(5, 50);
		hashTable.put(6, 60);
		hashTable.put(7, 10);
		hashTable.put(8, 20);
		hashTable.put(9, 40);
		hashTable.put(10, 10);
		hashTable.put(11, 20);
		hashTable.put(12, 40);
		
		System.out.println(hashTable.get(6));
	}
}