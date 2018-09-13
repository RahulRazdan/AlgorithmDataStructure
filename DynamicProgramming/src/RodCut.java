
public class RodCut {

	private int[][] solution;
	private int lengthOfRod;
	private int [] prices;
	
	public static void main(String[] args) {
		int[] prices = {0,2,5,7,3};
		RodCut rod = new RodCut(5, prices);
		rod.solve();
		rod.showResults();
	}
	
	public RodCut(int lengthOfRod, int[] prices) {
		super();
		this.lengthOfRod = lengthOfRod;
		this.prices = prices;
		this.solution = new int[prices.length+1][lengthOfRod+1];
	}

	public void solve() {
		for(int i=1;i<prices.length;i++)
			for(int j=1;j<=lengthOfRod;j++) {
				if(i<=j)
					solution[i][j] = Math.max(solution[i-1][j] , prices[i] + solution[i-1][j-i]);
				else
					solution[i][j] = solution[i-1][j];
			}
	}
	
	public void showResults() {
		
		System.out.println("Optimal Profit : $"+ solution[prices.length-1][lengthOfRod]);
		 
		for(int i=prices.length,j=lengthOfRod;i>0;) {
			if(solution[i][j]!=0 && solution[i][j] != solution[i-1][j])
			{
				System.out.println("We took cut of : #"+i+"m");
				j=j-i;
			}else
				i--;
		}
	}
}
