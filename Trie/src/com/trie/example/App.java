package com.trie.example;

public class App {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("rahul",2);
		trie.insert("razdan",3);
		trie.insert("amman",4);
		trie.insert("joe",5);
		
		System.out.println(trie.searchAsMap("amman"));
		
	}
}
