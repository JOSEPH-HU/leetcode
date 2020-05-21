public class ShipWithinDays{
	public static void main(String[] args) {
		int[] weights = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(solution(weights, 5));
		
	}

	public static int solution(int[] weights,int D){
		int start = 0 ;
		int end = 0;

		for(int weight:weights){
			start = Math.max(start,weight);
			end += weight;
		}

		while(start<end){
			int mid = start + (end - start)/2;
			int currDay = 1;
			int currWeight = 0;
			for(int weight:weights){
				currWeight += weight;
				if(currWeight>mid){
					currWeight = weight;
					currDay += 1;
				}
			}
			if(currDay>D){
				start = mid + 1;
			}else{
				end = mid;
			}
		}
		return end;
	}
}
