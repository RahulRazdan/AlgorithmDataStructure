
public class CoinChange {

	public static void main(String[] args) {
		
		int [] coins = {1,2,3};
		CoinChange c = new CoinChange();
		System.out.println(c.naiveCoinChange(5, coins, 0));
		c.dynamicCoinChange(coins, 5);
	}
	
	public int naiveCoinChange(int m, int[] v, int index) {
		
		if(m<0) return 0;
		if(m == 0) return 1;
		
		if(v.length == index) return 0;
		
		return naiveCoinChange(m-v[index], v, index) + naiveCoinChange(m, v, index+1);
	}
	
	public void dynamicCoinChange(int[] coins,int maxWeight) {
		
		int[][] solution = new int[coins.length+1][maxWeight+1];
		
		for(int i=1;i<=maxWeight;i++)
			solution[0][i] = 0;
		
		for(int i=1;i<=coins.length;i++)
			solution[i][0] = 1;
		
		for(int coinIndex=1;coinIndex<=coins.length;coinIndex++) {
			for(int weight=1;weight<=maxWeight;weight++) {
				
				if(coins[coinIndex-1] <= weight)
					solution[coinIndex][weight] = solution[coinIndex-1][weight] + solution[coinIndex][weight-coins[coinIndex-1]]; 
				else
					solution[coinIndex][weight] = solution[coinIndex-1][weight];
				
			}
		}
		
		System.out.println("Solution is :"+solution[coins.length][maxWeight]);
	}
}
