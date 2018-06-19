package linkedList;

/**
 * The Class Node.
 *
 * @param <T> the generic type
 */
public class Node<T extends Comparable<T>> {

	/** The data. */
	T data;
	
	/** The next node. */
	Node<T> nextNode;
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * Gets the next node.
	 *
	 * @return the next node
	 */
	public Node<T> getNextNode() {
		return nextNode;
	}
	
	/**
	 * Sets the next node.
	 *
	 * @param nextNode the new next node
	 */
	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	/**
	 * Instantiates a new node.
	 *
	 * @param data the data
	 */
	public Node(T data) {
		this.data = data;
	}
	 
}
