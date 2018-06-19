package dijkstraAlgo;

import java.util.Stack;

public class Algorithm {

	Stack<String> operationStack;
	Stack<Double> valueStack;
	
	public Algorithm() {
		operationStack = new Stack<>();
		valueStack = new Stack<>();
	}
	
	public void evaluateExpression(String expression) {
		String [] variables = expression.split(" ");
		
		for(String variable : variables) {
			switch(variable) {
				case "+" : this.operationStack.push(variable);
						break;
				case "*" : this.operationStack.push(variable);
						break;
				case ")" : 
					String operation = this.operationStack.pop();
					
					switch(operation) {
					case "+" :
						this.valueStack.push(this.valueStack.pop() + this.valueStack.pop());
							break;
					case "*" : this.operationStack.push(variable);
					this.valueStack.push(this.valueStack.pop() * this.valueStack.pop());
							break;
					}
					
				break;
				case "(" : 
					break;
				default :
					this.valueStack.push(Double.parseDouble(variable));
			}
		}
	}
	
	public Double getResult() {
		return this.valueStack.peek();
	}
}
