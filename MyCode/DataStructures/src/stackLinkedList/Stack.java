package stackLinkedList;

public class Stack<T extends Comparable<T>> {

	private Node<T> root;
	private int count;
	
	public int getSize() {
		return count;
	}
	public T pop() {
		if(root==null)
			return null;
		else {
			--count;
			T itemPoped = this.root.getData();
			this.root = this.root.getNextNode();
			return itemPoped;
		}
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public void push(T data) {
		if(root==null)
			this.root = new Node<T>(data);
		else {
			++count;
			Node<T> newNode = new Node<>(data);
			newNode.setNextNode(this.root);
			this.root = newNode;
		}
	}
	
	public T peek() {
		return this.root.getData();
	}
}
