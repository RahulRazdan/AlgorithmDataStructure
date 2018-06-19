package linkedList;

public class LinkedList<T extends Comparable<T>> implements List<T>{

	private int sizeOfList;
	private Node<T> root;
	
	@Override
	public void insert(T data) {
		++sizeOfList;
		if(root == null) {
			root = new Node<>(data);
		}else {
			insertDataAtBeginning(data);
		}
		
	}

	private void insertDataAtBeginning(T data) {
		Node<T> node = new Node<>(data);
		node.setNextNode(root);
		this.root = node;
	}

	@SuppressWarnings("unused")
	private void insertDataAtEnd(T data,Node<T> node) {
		if(node.getNextNode()!=null)
			insertDataAtEnd(data, node);
		else {
			Node<T> _node = new Node<>(data);
			node.setNextNode(_node);
		}
	}
	
	@Override
	public void remove(T data) {
		
		if(root==null) 
			return;
		
		--this.sizeOfList;
		
		if(this.root.getData().compareTo(data) == 0) {
			this.root = this.root.getNextNode();
		}else
			remove(data,root,root.getNextNode());
		
	}

	private void remove(T data, Node<T> previousNode, Node<T> actualNode) {
		while(actualNode!=null) {
			
			if(actualNode.getData().compareTo(data) == 0) {
				previousNode.setNextNode(actualNode.getNextNode());
				actualNode = null;
				return;
			}
			
			previousNode = actualNode;
			actualNode = actualNode.getNextNode();
		}	
	}

	@Override
	public void traverseList() {
		if(this.root == null)
			return;
		
		Node<T> actualNode = this.root;
		
		while(actualNode!=null) {
			System.out.println(actualNode+"");
			actualNode = actualNode.getNextNode();
		}
		
	}

	@Override
	public int size() {
		return sizeOfList;
	}

}
