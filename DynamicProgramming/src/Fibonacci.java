import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	Map<Integer,Integer> memory;
	
	public Fibonacci() {
		super();
		this.memory = new HashMap<>();
		this.memory.put(0, 0);
		this.memory.put(1, 1);
	}
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		//System.out.println(f.naiveFibonnaci(1500));
		System.out.println(f.dpFibonnaci(1500));
	}
	
	public int dpFibonnaci(int n) {
		if(memory.containsKey(n)) return memory.get(n);
		
		memory.put(n-1, dpFibonnaci(n-1));
		memory.put(n-2, dpFibonnaci(n-2));
		
		int calculated = memory.get(n-1) + memory.get(n-2);
		
		memory.put(n, calculated);
		
		return calculated;
	}
	
	public int naiveFibonnaci(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		
		return naiveFibonnaci(n-1) + naiveFibonnaci(n-2);
	}
}
