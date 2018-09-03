package com.trie.example;

public class Trie {

	private Node root;

	public Trie() {
		super();
		this.root = new Node("",0);
	}
	
	public Trie(int value) {
		super();
		this.root = new Node("",value);
	}
	
	public void insert(String word,int value) {
		Node tempnode = root;
		
		for(int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			int ascii = c - 'a';
			
			if(tempnode.getChild(ascii) == null) {
				Node childNode = new Node(String.valueOf(c),value);
				tempnode.setChild(ascii, childNode);
				tempnode = childNode;
			}else 
				tempnode = tempnode.getChild(ascii);
		}
		
		tempnode.setLeaf(true);
	}
	
	public boolean search(String word) {
		
		Node tempnode = root;
		
		for(int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			int ascii = c - 'a';
			
			if(tempnode.getChild(ascii) == null)
				return false;
			else
				tempnode = tempnode.getChild(ascii);
		}	
		
		return true;
	}
	
	public Integer searchAsMap(String word) {
		
		Node tempnode = root;
		
		for(int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			int ascii = c - 'a';
			
			if(tempnode.getChild(ascii) != null)
				tempnode = tempnode.getChild(ascii);
			else
				return null;
		}	
		
		return tempnode.getValue();
	}
}
