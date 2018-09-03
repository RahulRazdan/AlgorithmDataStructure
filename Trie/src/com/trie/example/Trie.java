package com.trie.example;

import java.util.ArrayList;
import java.util.List;

public class Trie {

	private Node root;	
	private int index;	
	
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
	
	public List<String>  allWorldsWithPrefix(String prefix){
		Node tempNode = root;
		
		List<String> allwords = new ArrayList<>();
		
		for(int i=0;i<prefix.length();i++) {
			
			char c = prefix.charAt(i);
			int ascii = c - 'a';
			
			if(tempNode!=null)
				tempNode = tempNode.getChild(ascii);
		}
		
		collect(tempNode,prefix,allwords);
		
		return allwords;
	}

	public String longestCommonPrefix() {
		Node tempNode = root;
		String lcp = "";
		
		
		while( countNumberOfChildren(tempNode) == 1 & !tempNode.isLeaf()) {
			tempNode = tempNode.getChild(index);
			lcp += String.valueOf((char) (index+'a'));
		}
		
		return lcp;
	}
	
	private int countNumberOfChildren(Node tempNode) {

		int numberOfChildren = 0 ;
		
		for(int i=0;i<tempNode.getChildren().length;i++) {
			if(tempNode.getChild(i) !=null) {
				numberOfChildren++;
				index = i;
			}
		}
		
		return numberOfChildren;
	}

	private void collect(Node tempNode, String prefix, List<String> allwords) {
		
		if(tempNode == null) return;
		
		if(tempNode.isLeaf())
			allwords.add(prefix);
		
		for(Node childNode : tempNode.getChildren()) {
			if(childNode==null) continue;
			String childCharacter = childNode.getCharacter();
			collect(childNode,prefix+childCharacter,allwords);
		}
	}
}
