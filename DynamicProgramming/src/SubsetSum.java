
public class SubsetSum {


	private boolean [][] solution;
	private int [] sets;
	private int sum;
	
	public static void main(String[] args) {
		int [] numbers = {5,2,3,1};
		SubsetSum set = new SubsetSum(numbers, 9);
		set.solve();
		set.showResult();
	}
	public SubsetSum(int[] sets, int sum) {
		super();
		this.sets = sets;
		this.sum = sum;
		this.solution = new boolean[sets.length+1][sum+1];
	}
	
	
	public void solve() {
		
		for(int i=0;i<sets.length;i++)
			solution[i][0] = true;
		
		for(int rowIndex=1;rowIndex<=sets.length;rowIndex++)
		{
			for(int columnIndex=1;columnIndex<=sum;columnIndex++) {
				
				if(columnIndex < sets[rowIndex-1]) {
					solution[rowIndex][columnIndex] = solution[rowIndex-1][columnIndex]; 
				}else {
					if(solution[rowIndex-1][columnIndex])
						solution[rowIndex][columnIndex]=true;
					else
						solution[rowIndex][columnIndex] = solution[rowIndex-1][columnIndex - sets[rowIndex-1]];
				}
					
			}
		}
		
		
	}
	
	public void showResult() {
		
		boolean solved = solution[sets.length][sum];
		System.out.println("Solution is : "+ solved);
		
		int colIndex = sum;
		int rowIndex = sets.length;
		
		if(solved) {
			while(colIndex > 0 || rowIndex > 0  ) {
				if(solution[rowIndex][colIndex] == solution[rowIndex-1][colIndex]) {
					rowIndex = rowIndex - 1;
				}
				else {
					System.out.println("We use : "+sets[rowIndex-1]);
					rowIndex = rowIndex - 1;
					colIndex = colIndex - sets[rowIndex];
					
				}
					
			}
		}
			
	}
}
