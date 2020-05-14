import java.util.HashMap;
import java.util.Map;

public class NumPairsDivisibleBy60{
	public static void main(String[] args) {
	 //int []time = {60,60,60};
	 int []time = {30,20,150,100,40};
	 System.out.println(solution3(time));
	}
/*
 *最简单的方式是两层循环,时间的复杂度o(n2)
 */
	public static int  solution(int[]time){
		int count = 0;
		for(int i=0;i<time.length;i++){
			for(int j=i+1;j<time.length;j++){
				int sum = time[i] + time[j];
				if(sum%60==0){
					count++;
				}
			}
		}
		return count;
	}

	public static int solution2(int[] time){
		int count = 0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<time.length;i++){
			int remainder = time[i]%60;
			//查看余数是否在map里，如果有，说明两个数相加可以被60整除
			if(map.containsKey(remainder)){
				count += map.get(remainder);
			}
			
			//对于余数为零的单独添加map中
			if(remainder==0){
				map.put(0, map.getOrDefault(0, 0)+1);
			}else{
				int target = 60 -remainder;
				//记录配对余数
				map.put(target, map.getOrDefault(target, 0)+1);
			}
		}
		return count;
		
	}


	public static int solution3(int[] time){
		int count = 0;
		int[] arr = new int[60];//存放余数的次数

		for(int i=0;i<time.length;i++){
			int remainder = time[i] % 60;
			count += arr[remainder];

			int target = remainder == 0 ? 0 :60-remainder;
			arr[target]++;
		}
		return count;
	}
}
