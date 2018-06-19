package linkedList;

public class App {

	public static void main(String[] args) {
		
		LinkedList<Integer> intList = new LinkedList<>();
		intList.insert(10);
		intList.insert(-3);
		intList.insert(100);
		intList.insert(2);
		
		intList.traverseList();
		
		intList.remove(10);
		
		intList.traverseList();
	}
}
