
public class EggDrop {

	private int solution[][] = new int [Constants.NUMOFEGG+1][Constants.NUMOFFLOOR+1];

	public int solve() {
		solution [0][0] = 1;
		solution [1][0] = 1;
		
		for(int i=0;i<=Constants.NUMOFFLOOR;i++)
			solution[1][i] = i;
		
		for(int n=2;n<=Constants.NUMOFEGG;n++) {
			for(int m=1;m<=Constants.NUMOFFLOOR;m++) {
				
				solution[n][m] = Integer.MAX_VALUE;
				
				for(int x=1;x<=m;x++) {
					
					int maxDrop = 1 + Math.max(solution[n-1][x-1], solution[n][m-x]);
					
					if(maxDrop < solution[n][m])
						solution[n][m] = maxDrop;
				}
			}
		}
		
		
		return solution[Constants.NUMOFEGG][Constants.NUMOFFLOOR];
	}

}
