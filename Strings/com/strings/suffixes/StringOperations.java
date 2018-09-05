package com.strings.suffixes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Class StringOperations.
 */
public class StringOperations {

	/**
	 * Longest common prefix.
	 *
	 * @param text the text
	 * @param text2 the text 2
	 * @return the string
	 */
	public static String longestCommonPrefix(String text,String text2) {
		
		int commonLength = Math.min(text.length(),text2.length());
		
		for(int index = 0 ; index < commonLength ; index++) {
			if(text.charAt(index) != text2.charAt(index))
				return text.substring(0, index);
		}
		
		return text.substring(0,commonLength);
	}
	
	/**
	 * Longest repeated sub string.
	 *
	 * @param text the text
	 * @return the string
	 */
	public static String longestRepeatedSubString(String text) {
		int lengthOfText = text.length();
		
		List<String> suffixes = getSuffixes(text);
		
		Collections.sort(suffixes);
		
		String longestSubString = "";
		
		for(int i=0 ; i < lengthOfText -1 ;i++) {
			String tempString = longestCommonPrefix(suffixes.get(i), suffixes.get(i+1));
			
			if(tempString.length() > longestSubString.length())
				longestSubString = tempString;
		}
		
		return longestSubString;
		
	}

	/**
	 * Gets the suffixes.
	 *
	 * @param text the text
	 * @return the suffixes
	 */
	public static List<String> getSuffixes(String text) {
		
		int lengthOfText = text.length();
		
		List<String> listOfSuffixes = new ArrayList<>();
		
		for(int index = lengthOfText ; index >= 0 ; index--) {
			listOfSuffixes.add(text.substring(index,lengthOfText));
		}
		return listOfSuffixes;
	}
}
