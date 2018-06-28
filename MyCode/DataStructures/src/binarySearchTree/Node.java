package binarySearchTree;

/**
 * The Class Node.
 *
 * @param <T> the generic type
 */
public class Node<T extends Comparable<T>> {

	/** The data. */
	T data;
	
	/** The next node. */
	Node<T> leftNode;
	
	/** The riht node. */
	Node<T> rightNode;
	
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
	 * Gets the left node.
	 *
	 * @return the left node
	 */
	public Node<T> getLeftNode() {
		return leftNode;
	}

	/**
	 * Sets the left node.
	 *
	 * @param leftNode the new left node
	 */
	public void setLeftNode(Node<T> leftNode) {
		this.leftNode = leftNode;
	}

	/**
	 * Gets the riht node.
	 *
	 * @return the riht node
	 */
	public Node<T> getRightNode() {
		return rightNode;
	}

	/**
	 * Sets the riht node.
	 *
	 * @param rihtNode the new riht node
	 */
	public void setRightNode(Node<T> rightNode) {
		this.rightNode = rightNode;
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
