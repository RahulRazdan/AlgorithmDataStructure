
public class Knapsack {

	public static void main(String[] args) {
	
		
		int [] weightOfItems = {
				0,4,2,3
		};
		
		int [] valueOfItems = {
				0,10,4,7
		};
		
		Knapsack nap = new Knapsack(3, 5, weightOfItems, valueOfItems);
		nap.solve();
		nap.showResult();
	}
	
	private int numberOfItems;
	private int totalWeight;
	private int [][] knapsackTable;
	private int [] weights;
	private int [] values;
	private int totalBenefit;
	
	public Knapsack(int numberOfItems, int totalWeight, int[] weights, int[] values) {
		super();
		this.numberOfItems = numberOfItems;
		this.totalWeight = totalWeight;
		this.knapsackTable = new int[numberOfItems+1][totalWeight+1];
		this.weights = weights;
		this.values = values;
	}
	
	public void solve() {
		
		for(int i=1;i<numberOfItems+1;i++) {
			for(int w=1;w<totalWeight+1;w++) {
				int nottakingtheItem = knapsackTable[i-1][w];
				int takingItem = 0;
				
				if(weights[i] <= w) {
					takingItem = values[i] + knapsackTable[i-1][w-weights[i]];
				}
				
				knapsackTable[i][w] = Math.max(nottakingtheItem, takingItem);
			}
		}
		
		totalBenefit = knapsackTable[numberOfItems][totalWeight];
	}

	public void showResult() {
		System.out.println("Total Benefit : " + totalBenefit);
		
		for(int n=numberOfItems,w=totalWeight;n>0;n--) {
			if(knapsackTable[n][w]!=0 && knapsackTable[n][w] != knapsackTable[n-1][w]) {
				System.out.println("we are taking item : #"+n);
				w=w-weights[n];
			}
		}
	}
}
