package redblacktrees;

/**
 * The Class Node.
 *
 * @param <T> the generic type
 */
public class Node<T extends Comparable<T>> {

	/** The data. */
	private T data;
	
	/** The next node. */
	private Node<T> leftNode;
	
	/** The riht node. */
	private Node<T> rightNode;
	
	/** The parent. */
	private Node<T> parent;
	
	/** The color. */
	private NodeColor color;

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public Node<T> getParent() {
		return parent;
	}

	/**
	 * Sets the parent.
	 *
	 * @param parent the new parent
	 */
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public NodeColor getColor() {
		return color;
	}

	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(NodeColor color) {
		this.color = color;
	}

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
	 * @param rightNode the new right node
	 */
	public void setRightNode(Node<T> rightNode) {
		this.rightNode = rightNode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [data=" + data + ", color = "+color+" ]";
	}

	/**
	 * Instantiates a new node.
	 *
	 * @param data the data
	 */
	public Node(T data) {
		this.data = data;
		this.color = NodeColor.RED;
	}
	 
}
