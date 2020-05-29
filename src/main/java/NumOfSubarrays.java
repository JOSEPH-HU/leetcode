public class NumOfSubarrays{
	public static void main(String[] args) {
		int[] arr = {2,2,2,2,5,5,5,8};
		System.out.println(solution1(arr, 3, 4));
		//int[] arr = {1,1,1,1,1};
		//System.out.println(solution(arr, 1, 0));
		//int[] arr = {11,13,17,23,29,31,7,5,2,3};
		//System.out.println(solution1(arr, 3, 5));
	}

	public static int solution(int[] arr,int k,int threshold){
		if(arr==null || arr.length<k){
			return 0;
		}
		int result = 0;
		for(int i=0;i<arr.length;i++){
			int m = i;
			int tmp = 0;
			int n = 0;
			while(m<k+i&&m<arr.length){
				tmp += arr[m];
				m++;
				n++;
			}
			if(tmp>=k*threshold && k==n){
				result += 1;
			}
		}
		return result;
	}

	public static int solution1(int[] arr,int k,int threshold){
		if(arr==null || arr.length<k){
			return 0;
		}
		int result = 0;
		int[] prefixsum = new int[arr.length+1];
		for(int i=0;i<arr.length;i++){
			prefixsum[i+1] = prefixsum[i] + arr[i];
		}

		for(int i=0,j=i+k;j<prefixsum.length;i++,j++){
			if(prefixsum[j]-prefixsum[i]>=k*threshold){
				result++;
			}
		}
		

		return result;
	}
}
