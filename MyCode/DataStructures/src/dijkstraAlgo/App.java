package dijkstraAlgo;

public class App {

	public static void main(String[] args) {
		
		Algorithm algo = new Algorithm();
		algo.evaluateExpression("( ( 2 + 2 ) * ( 2 + 1 ) )");
		System.out.println(algo.getResult());
	}
}
