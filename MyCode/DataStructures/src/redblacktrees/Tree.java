package redblacktrees;

/**
 * The Interface Tree.
 *
 * @param <T> the generic type
 */
public interface Tree<T> {

	/**
	 * Traversal.
	 */
	public void traversal();
	
	/**
	 * Insert.
	 *
	 * @param data the data
	 */
	public void insert(T data);
	
	/**
	 * Delete.
	 *
	 * @param data the data
	 */
	public T delete(T data);
	
	/**
	 * Gets the max.
	 *
	 * @return the max
	 */
	public T getMax();
	
	/**
	 * Gets the min.
	 *
	 * @return the min
	 */
	public T getMin();
}
