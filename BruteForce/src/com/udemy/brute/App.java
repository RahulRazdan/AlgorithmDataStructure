package com.udemy.brute;

public class App {

	public static void main(String[] args) {
		System.out.println(search("this is just a test!","just"));
	}
	private static int search(String word,String pattern) {
		
		int lengthOfWord = word.length();
		int lengthOfPattern = pattern.length();
		
		for(int i=0;i<= lengthOfWord - lengthOfPattern;i++) {
			int j;
			for(j=0;j<lengthOfPattern;j++) {
				if(word.charAt(i+j) != pattern.charAt(j))
					break;
			}
			
			if(j==lengthOfPattern) return i;
		}
		
		return lengthOfWord;
	}
}
