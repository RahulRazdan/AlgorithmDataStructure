package stackArrayList;

import java.util.ArrayList;
import java.util.List;

public class Stack<T extends Comparable<T>> {

	private List<T> data = new ArrayList<>();
	
	public void push(T data) {
		this.data.add(0,data);
	}
	
	public T peek() {
		return this.data.get(0);
	}
	
	public T pop() {
		
		if(this.data!=null && this.data.size() > 0)
			return this.data.remove(0);
		
		return null;
	}

	public List<T> getData() {
		return this.data;
	}

	public int getSize() {
		return this.data.size();
	}

}
