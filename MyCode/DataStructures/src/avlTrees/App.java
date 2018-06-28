package avlTrees;

public class App {

	public static void main(String[] args) {
		Tree<Integer> tree = new AVLTrees<Integer>();
		tree.insert(3);
		tree.insert(2);
		tree.insert(1);
		
		tree.traversal();
	}
}
