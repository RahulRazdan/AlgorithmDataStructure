package redblacktrees;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;
	
	@Override
	public void traversal() {
		
		if(root!=null)
			inOrderTraversal(root);
	}

	private void inOrderTraversal(Node<T> node) {
		if(node.getLeftNode() !=null)
			inOrderTraversal(node.getLeftNode());
		
		System.out.println(node.getData());
		
		if(node.getRightNode()!=null)
			inOrderTraversal(node.getRightNode());
		
	}

	@Override
	public void insert(T data) {
		
		Node<T> newNode = new Node<>(data);
		
		root = insertIntoNode(root,newNode);
		
		fixViolation(newNode);
		
	}

	private void fixViolation(Node<T> node) {

		Node<T> parentNode = null;
		Node<T> grandParentNode = null;
		
		while(node!=root && node.getColor() != NodeColor.BLACK && node.getParent().getColor() == NodeColor.RED) {
			
			parentNode = node.getParent();
			grandParentNode = node.getParent().getParent();
			
			if(parentNode == grandParentNode.getLeftNode()) {
				
				Node<T> uncle = grandParentNode.getRightNode();
				
				if(uncle!=null && uncle.getColor() ==  NodeColor.RED) {
					grandParentNode.setColor(NodeColor.RED);
					parentNode.setColor(NodeColor.BLACK);
					uncle.setColor(NodeColor.BLACK);
					node = grandParentNode;
				}
				else {
					if(node == parentNode.getRightNode()) {
						 LeftRotation(parentNode);
						 node = parentNode;
						 parentNode = node.getParent();
					}
					
					// this take care of heavy right situation..
					rightRotation(grandParentNode);
					NodeColor color = parentNode.getColor();
					parentNode.setColor(grandParentNode.getColor());
					grandParentNode.setColor(color);
					node = parentNode;
				}
			}
			else {
				Node<T> uncle = grandParentNode.getLeftNode();
				
				if(uncle!=null && uncle.getColor() ==  NodeColor.RED) {
					grandParentNode.setColor(NodeColor.RED);
					parentNode.setColor(NodeColor.BLACK);
					uncle.setColor(NodeColor.BLACK);
					node = grandParentNode;
				}
				else {
					if(node == parentNode.getLeftNode()) {
						rightRotation(parentNode);
						 node = parentNode;
						 parentNode = node.getParent();
					}
					
					// this take care of heavy left situation..
					LeftRotation(grandParentNode);
					NodeColor color = parentNode.getColor();
					parentNode.setColor(grandParentNode.getColor());
					grandParentNode.setColor(color);
					node = parentNode;
				}
			}
		}
		
		if(root.getColor() == NodeColor.RED)
			root.setColor(NodeColor.BLACK);
	}

	// node arguement is parent of inserted element..
	private void rightRotation(Node<T> node) {
		
		System.out.println("Rotating right side of node ["+node + "]..");
		
		Node<T> tempLeftNode = node.getLeftNode();
		node.setLeftNode(tempLeftNode.getRightNode());
		
		if(node.getLeftNode() !=null)
			node.getLeftNode().setParent(node);
		
		tempLeftNode.setParent(node.getParent());
		
		if(tempLeftNode.getParent() ==null)
			root = tempLeftNode;
		else if (node == node.getParent().getLeftNode())
			node.getParent().setLeftNode(tempLeftNode);
		else 
			node.getParent().setRightNode(tempLeftNode);

		tempLeftNode.setRightNode(node);
		node.setParent(tempLeftNode);
	}
	
	// node arguement is parent of inserted element..
		private void LeftRotation(Node<T> node) {
			
			System.out.println("Rotating left side of node ["+node+ "]");
			
			Node<T> tempRightNode = node.getRightNode();
			node.setRightNode(tempRightNode.getLeftNode());
			
			if(node.getRightNode() !=null)
				node.getRightNode().setParent(node);
			
			tempRightNode.setParent(node.getParent());
			
			if(tempRightNode.getParent() ==null)
				root = tempRightNode;
			else if (node == node.getParent().getLeftNode())
				node.getParent().setLeftNode(tempRightNode);
			else 
				node.getParent().setRightNode(tempRightNode);

			tempRightNode.setLeftNode(node);
			node.setParent(tempRightNode);
		}
		
		
	private Node<T> insertIntoNode(Node<T> root2, Node<T> newNode) {

		if ( root2 == null ) return newNode;
		
		if(newNode.getData().compareTo(root2.getData()) < 0 ) {
			root2.setLeftNode(insertIntoNode(root2.getLeftNode(), newNode));
			root2.getLeftNode().setParent(root2);
		}
		else if(newNode.getData().compareTo(root2.getData()) > 0 ) {
			root2.setRightNode(insertIntoNode(root2.getRightNode(), newNode));
			root2.getRightNode().setParent(root2);
		}
		
		return root2;
	}

	@Override
	public T delete(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getMin() {
		// TODO Auto-generated method stub
		return null;
	}

}
