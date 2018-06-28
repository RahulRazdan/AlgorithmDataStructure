package avlTrees;

public class AVLTrees<T extends Comparable<T>> implements Tree<T>{

	Node<T> root;
	
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

	private int getHeight(Node<T> node) {
		if(node==null)
			return -1;
		
		return node.getHeight();
	}
	
	private int getBalance(Node<T> node) {
		
		if(node==null)
			return 0;
		
		return getHeight( node.getLeftNode() ) - getHeight( node.getRightNode() );
	}
	
	private Node<T> rightRotation(Node<T> node) {
		
		System.out.println("Rotating to right side..");
		
		Node<T> _tempNode = node.getLeftNode();
		Node<T> _tempRightNode = _tempNode.getRightNode();
		
		_tempNode.setRightNode(node);
		node.setLeftNode(_tempRightNode);		
		
		_tempNode.setHeight(Math.max(getHeight(_tempNode.getLeftNode()),getHeight( _tempNode.getRightNode())));
		node.setHeight(Math.max(getHeight(node.getLeftNode()), getHeight(node.getRightNode())));
		
		return _tempNode;
	}
	
	private Node<T> leftRotation(Node<T> node) {
		
		System.out.println("Rotating to left side..");
		
		Node<T> _tempNode = node.getRightNode();
		Node<T> _tempRightNode = _tempNode.getLeftNode();
		
		_tempNode.setLeftNode(node);
		node.setRightNode(_tempRightNode);		
		
		_tempNode.setHeight(Math.max(getHeight(_tempNode.getLeftNode()),getHeight( _tempNode.getRightNode())));
		node.setHeight(Math.max(getHeight(node.getLeftNode()), getHeight(node.getRightNode())));
		
		return _tempNode;
	}
	
	@Override
	public void insert(T data) {
		root = insert(root,data);
		
	}

	private Node<T> insert(Node<T> node, T data) {
		if(node==null)
			return new Node<T>(data);
		
		if(data.compareTo(node.getData()) < 0) 
			node.setLeftNode(insert(node.getLeftNode(),data));
		
		else 
			node.setRightNode(insert(node.getRightNode(),data));
		
		node.setHeight(Math.max(getHeight(node.getLeftNode()),getHeight(node.getRightNode())) + 1);
		
		node = solveViolation(node,data);
				
		return node;
	}


	private Node<T> solveViolation(Node<T> node, T data) {
		int balance = getBalance(node);
		
		if(balance < -1 && (data.compareTo(node.getRightNode().getData()) > 0) )
			return leftRotation(node);
		
		if(balance > 1 && (data.compareTo(node.getLeftNode().getData()) < 0))
			return rightRotation(node);
		
		if(balance < -1 && (data.compareTo(node.getRightNode().getData()) < 0) ) {
			node.setRightNode(leftRotation(node.getRightNode()));
			return leftRotation(node);
		}
		
		if(balance > 1 && (data.compareTo(node.getLeftNode().getData()) > 0)) {
			node.setLeftNode(leftRotation(node.getLeftNode()));
			return rightRotation(node);
		}
			return node; 
	}


	@Override
	public T delete(T data) {
		// TODO Auto-generated method stub
		return null;
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
