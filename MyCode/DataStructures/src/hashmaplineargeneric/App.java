package hashmaplineargeneric;

public class App {

	public static void main(String[] args) {
		
		HashTable<String,Integer> hashTable = new HashTable<>();
		
		hashTable.testHash("a");
		hashTable.testHash("k");
		
		hashTable.put("a", 10);
		hashTable.put("b", 20);
		hashTable.put("c", 40);
		hashTable.put("d", 30);
		hashTable.put("e", 50);
		hashTable.put("ff", 60);
		hashTable.put("gg", 10);
		hashTable.put("hhh", 20);
		hashTable.put("iiii", 40);
		hashTable.put("jjjj", 10);
		hashTable.put("kkkkk", 20);
		hashTable.put("lllll", 40);
		
		System.out.println(hashTable.size());
		
		System.out.println(hashTable.get("e"));
		
		hashTable.remove("c");
		System.out.println(hashTable.size());
		hashTable.remove("d");
		System.out.println(hashTable.size());
		hashTable.remove("e");
		System.out.println(hashTable.size());
		hashTable.remove("ff");
		System.out.println(hashTable.size());
		hashTable.remove("gg");
		System.out.println(hashTable.size());
		hashTable.remove("hhh");
		System.out.println(hashTable.size());
		hashTable.remove("iiii");
		System.out.println(hashTable.size());
		hashTable.remove("jjjj");
		System.out.println(hashTable.size());
		hashTable.remove("kkkkk");
		System.out.println(hashTable.size());
		hashTable.remove("lllll");
		
		System.out.println(hashTable.get("b"));
		
	}
}