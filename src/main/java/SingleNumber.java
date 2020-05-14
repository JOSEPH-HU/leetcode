import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber{
	public static void main(String[] args) {
		int[] arr = {2,2,1};
		//int[] arr = {4,1,2,2,1};
		System.out.println(solution2(arr));
	}

	public static int solution(int[] arr){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();

		int result = 0;

		for(int i=0;i<arr.length;i++){
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}

		for(Integer key:map.keySet()){
			if(map.get(key)==1){
				result = key;
			}
		}
		return result;
	}

	public static int solution2(int[] nums){
		int result = 0;
		for(int i=0;i<nums.length;i++){
			result ^= nums[i];
		}
		return result;
	}
}
