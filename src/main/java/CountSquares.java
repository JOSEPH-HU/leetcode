
public class CountSquares{
	public static void main(String[] args) {

		//int[][] matrix = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
		int[][] matrix = {{1,0,1},{1,1,0},{1,1,0}};
		System.out.println(solution(matrix));

	}

	public static int solution(int[][] matrix){
		if(matrix.length==0 || matrix[0].length==0){
			return 0;
		}
		int row = matrix.length;
		int col = matrix[0].length;

		int result = 0;
		int[][] dp = new int[row][col];

		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(matrix[i][j]==1){
					if(i==0 || j ==0){
						dp[i][j] = 1;
					}else{
						dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j-1]), dp[i-1][j]) + 1;
					}
				}
			result += dp[i][j];
			}
		}
		return result;
	}
}
