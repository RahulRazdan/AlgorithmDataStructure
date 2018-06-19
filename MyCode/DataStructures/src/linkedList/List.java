package linkedList;

/**
 * The Interface List.
 *
 * @param <T> the generic type
 */
public interface List<T> {
	
	/**
	 * Insert.
	 *
	 * @param data the data
	 */
	public void insert(T data);
	
	/**
	 * Remode.
	 *
	 * @param data the data
	 */
	public void remove(T data);
	
	/**
	 * Traverse list.
	 */
	public void traverseList();
	
	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size();
}
