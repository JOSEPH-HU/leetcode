public class DeleteAndEarn{
	public static void main(String[] args) {
		int[] a1 = {3, 4, 2};
		assert solution(a1) == 6;

		int[] a2 = {2, 2, 3, 3, 3, 4};
		assert solution(a2) == 9;
	}

	public static int solution(int[] nums){
		if(nums==null || nums.length == 0){
			return 0;
		}else if(nums.length==1){
			return nums[0];
		}
		//找到最大值
		int max = nums[0];
		for(int i=0;i<nums.length;i++){
			max = Math.max(max, nums[i]);
		}

		//把元素放到桶的位置
		int[] arrs = new int[max+1];
		for(int i=0;i<nums.length;i++){
			arrs[nums[i]]++;
		}
		//状态转移方程
		int[] dp = new int[max+1];
		dp[1] = arrs[1]*1;
		dp[2] = Math.max(dp[1], arrs[2]*2);
		for(int i=3;i<=max;i++){
			dp[i] = Math.max(dp[i-1], dp[i-2]+arrs[i]*i);
		}
		return dp[max];
	}
}
