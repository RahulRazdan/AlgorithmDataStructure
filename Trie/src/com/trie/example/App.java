package com.trie.example;

public class App {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("raul",2);
		trie.insert("razdan",3);
		trie.insert("ramesh",4);
		trie.insert("rakesh",5);
		
		System.out.println(trie.longestCommonPrefix());
		
	}
}
