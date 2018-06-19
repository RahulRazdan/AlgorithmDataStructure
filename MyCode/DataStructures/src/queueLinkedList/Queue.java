package queueLinkedList;

public class Queue<T extends Comparable<T>> {

	private Node<T> firstNode;
	private Node<T> lastNode;
	private int size;
	
	public void enqueue(T data) {
		size++;
		Node<T> currentNode = this.lastNode;
		this.lastNode = new Node<>(data);
		this.lastNode.setNextNode(null);
		
		if(isEmpty())
			this.firstNode = this.lastNode;
		else {
			currentNode.setNextNode(this.lastNode);
		}
			
	}
	
	public T dequeue() {
		size--;
		
		T currentNode = this.firstNode.getData();
		this.firstNode = this.firstNode.getNextNode();
		
		if(isEmpty())
			this.lastNode = null;
		
		return currentNode;
		
	}
	
	public T peek() {
		return this.firstNode.getData();
	}
	
	public boolean isEmpty() {
		return this.firstNode == null;
	}

	public int size() {
		return size;
	}
}

