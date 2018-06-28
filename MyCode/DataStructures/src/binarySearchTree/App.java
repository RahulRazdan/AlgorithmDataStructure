package binarySearchTree;

public class App {

	public static void main(String[] args) {
		
		Tree<Integer> intBinary = new BinarySearchTree<>();
		
		intBinary.insert(10);
		intBinary.insert(5);
		intBinary.insert(15);
		intBinary.insert(3);
		intBinary.insert(7);
		intBinary.insert(1000);
		
		System.out.println("Max : "+intBinary.getMax());
		System.out.println("Min : "+intBinary.getMin());
		
		intBinary.traversal();
		
		intBinary.delete(5);
		
		intBinary.traversal();
	}
}
