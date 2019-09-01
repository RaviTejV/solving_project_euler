package solutions;

public class SolutionFor76 implements Solution {

	@Override
	public void solve() throws Exception {
		
		int MAX = 101;
		
		int[][] arr = new int[MAX][MAX];
		
		for(int i = 0 ; i < MAX; i ++){
			for(int j = 0; j < MAX; j++){
				arr[i][j] = 0;
			}
		}
		
		//initalize base
		for(int i = 0; i < MAX; i++){
			arr[0][i] = 1;
		}
		
		for(int i = 1; i < MAX; i++){
			for(int j = 1; j < MAX; j++){
				
				if(j == 1){
					arr[i][j] = 1;
				}
				else if(j > i){					
					arr[i][j] = arr[i][j-1];
				}
				else {
					arr[i][j] = arr[i][j-1] + arr[i-j][j];
				}
			}
		}
		
//		for(int i = 0 ; i < MAX; i ++){
//			for(int j = 0; j < MAX; j++){
//				System.out.print(arr[i][j]);
//				System.out.print(" ");
//			}
//			
//			System.out.println();
//		}
		
		System.out.println(arr[100][99]);
		
		//5 possiblities = 1 coins only + 2 coins at max only + 3 coins at max only
		
	}

}
