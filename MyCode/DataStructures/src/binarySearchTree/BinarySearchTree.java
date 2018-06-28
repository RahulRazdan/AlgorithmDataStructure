package binarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{

	private Node<T> root;
	private int size;
	
	public void insert(T data) {
		++size;
		
		if(root==null)
			this.root = new Node<>(data);
		else 			
			insertNode(data,this.root);		
	}
	
	private void insertNode(T data, Node<T> currentNode) {
		if(data.compareTo(currentNode.getData()) < 0) {
			if(currentNode.getLeftNode()!=null)
				insertNode(data,currentNode.getLeftNode());
			else
				currentNode.setLeftNode(new Node<>(data));
	    } else {
			if(currentNode.getRightNode()!=null)
				insertNode(data,currentNode.getRightNode());
			else
				currentNode.setRightNode(new Node<>(data));
		}
	}
	
	private Node<T> deleteNode(Node<T> node , T data) {
		
		if(node ==null) return node;
		
		if(data.compareTo(node.getData()) < 0 )
			node.setLeftNode(deleteNode(node.getLeftNode(),data));
		else if (data.compareTo(node.getData()) > 0 )
			node.setRightNode(deleteNode(node.getRightNode(),data));
		
		else {
			
			System.out.println("Record found...");
			
			if(node.getRightNode()==null && node.getLeftNode() == null) {
				System.out.println("Removing leaf node ...");
				return null;
			}
			
			else if (node.getRightNode()==null) {
				System.out.println("Removing left child....");
				Node<T> _tempNode = node.getLeftNode();
				node = null;
				return _tempNode;
			}
			else if (node.getLeftNode()==null) {
				System.out.println("Removing rights child....");
				Node<T> _tempNode = node.getRightNode();
				node = null;
				return _tempNode;
			}
			
			System.out.println("Removing node with 2 child");
			
			Node<T> _tempNode = getPredecessor(node.getLeftNode());
			
			node.setData(_tempNode.getData());
			node.setLeftNode(deleteNode(node.getLeftNode(),_tempNode.getData()));
		}
		
		
		return node;
	}
	
	
	private Node<T> getPredecessor(Node<T> node) {
		
		if(node.getRightNode()!=null)
			return getPredecessor(node.getRightNode());
		
		return node;
	}

	public T delete(T data) {
		
		return deleteNode(this.root,data).getData();
		
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public int size() {
		return size;
	}

	@Override
	public void traversal() {
		if(this.root!=null)
			inorderTraversal(root);
	}

	
	private void inorderTraversal(Node<T> root) {
		
		if(root.getLeftNode()!=null)
			inorderTraversal(root.getLeftNode());
		
		System.out.print(root.getData()+"--->");
		
		if(root.getRightNode()!=null)
			inorderTraversal(root.getRightNode());
		
	}

	private T getNextRightNode(Node<T> currentNode) {
		
		if(currentNode.getRightNode()!=null)
			return getNextRightNode(currentNode.getRightNode());

		return currentNode.getData();
	}
	
	private T getNextLeftNode(Node<T> currentNode) {
		
		if(currentNode.getLeftNode()!=null)
			return getNextLeftNode(currentNode.getLeftNode());

		return currentNode.getData();
	}
	
	@Override
	public T getMax() {
		
		if(this.root == null)
			return null;
		else 
			return getNextRightNode(this.root);
	}

	@Override
	public T getMin() {
		if(this.root == null)
			return null;
		else 
			return getNextLeftNode(this.root);
	}
}
