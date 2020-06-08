public class MaxSubArray{
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

		int result = solution(nums);
		System.out.println(result);
		assert result == 6;

		int[] nums1 = {-2,1};
		int a1 = solution(nums1);
		System.out.println(a1);
		assert a1 == 1;

		int[] nums2 = {-2,-1};
		int a2 = solution(nums2);
		System.out.println(a2);
		assert a2 == -1;
	}

	public static int solution(int[] nums){
		int len = nums.length;
		if(len==1){
			return nums[0];
		}

		int[] dp = new int[len+1];
		dp[0] = nums[0];

		int result = dp[0];

		for(int i=1;i<len;i++ ){
			if(dp[i-1]>0){
				dp[i] = dp[i-1] + nums[i];
			}else{
				dp[i] = nums[i];
			}
			result = Math.max(result, dp[i]);
		}
		return result;
	}
}
