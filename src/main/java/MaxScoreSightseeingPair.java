
public class MaxScoreSightseeingPair{
	public static void main(String[] args) {
		int[] A = {8,1,5,2,6};
		System.out.println(solution(A));
	}

	public static int solution(int[] A){
		int len = A.length;

		int pre_max = A[0] + 0;
		int result = 0;

		for(int j=1;j<len;j++){
			result = Math.max(result, pre_max + A[j]-j);
			pre_max = Math.max(pre_max, A[j]+j);
		}
		return result;
	}
}
