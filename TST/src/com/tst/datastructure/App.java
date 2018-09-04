package com.tst.datastructure;

public class App {

	public static void main(String[] args) {
		TST tst = new TST();
		
		tst.put("rahul", 1);
		tst.put("razdan", 2);
		
		System.out.println(tst.get("rahul"));
	}
	
}
