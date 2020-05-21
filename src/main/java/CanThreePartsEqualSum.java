
public class CanThreePartsEqualSum{
	public static void main(String[] args) {
		//int[] A = {6,1,1,13,-1,0,-10,20};
		//int[] A = {0,2,1,-6,6,7,9,-1,2,0,1};
		//int[] A = {0,2,1,-6,6,-7,9,1,2,0,1};
		int[] A = {1,-1,1,-1};
		System.out.println(solution(A));

	}

	public static boolean solution(int[] A){
		int sum = 0;
		for(int a:A){
			sum += a;
		}
		if(sum%3!=0){
			return false;
		}
		int len = A.length;
		int avg = sum/3;
		System.out.println(avg);
		int curr = 0;
		int i = 0;
		while(i<len){
			curr += A[i];
			i++;
			if(curr == avg){
				break;
			}
		}
		if(curr!=avg){
			return false;
		}
		int j = i ;
		curr = 0;
		while(j<len){
			curr += A[j];
			j++;
			if(curr==avg){
				break;
			}
		}
		System.out.println(i+"="+j + "=" + len);
		if(curr==avg && (j != len)){
			return true;
		}
		return false;
	}
}
