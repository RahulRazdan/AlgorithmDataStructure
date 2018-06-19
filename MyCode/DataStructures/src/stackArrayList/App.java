package stackArrayList;

public class App {

	public static void main(String[] args) {
		Stack<String> intStack = new Stack<String>();
		
		intStack.push("10");
		intStack.push("100");
		intStack.push("10000");
		
		System.out.println(intStack.peek());
		
		System.out.println(intStack.pop());
		System.out.println(intStack.pop());
		System.out.println(intStack.pop());
		System.out.println(intStack.pop());
	}
}
