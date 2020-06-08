public class WaysToChange{
	public static void main(String[] args) {
		int a1 = solution(5);
		assert a1 == 2;

		//int a2 = solution(10);
		//assert a2 == 4;


		int a11 = solution1(5);
		assert a11 == 2;

		int a22 = solution1(10);
		assert a22 == 4;
	}

	public static int solution(int n){
		int[] coins = {1,5,10,25};
		int[][] dp = new int[4][n+1];

		for(int i=0;i<4;i++){
			dp[i][0] = 1;
		}
		for(int j=1;j<=n;j++){
			dp[0][j] = 1;
		}
		for(int i=1;i<4;i++){
			for(int j=1;j<=n;j++){
				if(j-coins[i]<0){
					dp[i][j] = dp[i-1][j] % 1000000007;
				}else{
					dp[i][j] = (dp[i - 1][j] + dp[i][j - coins[i]]) % 1000000007;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[0].length;j++){
				sb.append(dp[i][j]).append("|");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		return dp[3][n];
	}

	public static int solution1(int n){
		int[] coins = {1,5,10,25};
		int[] dp = new int[n+1];
		dp[0] = 1;
		for(int coin:coins){
			for(int i=1;i<=n;i++){
				if(i-coin>=0){
					dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
				}
			}
		}
		return dp[n];
	}
}
