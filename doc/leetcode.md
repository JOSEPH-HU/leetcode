## 1010. 总持续时间可被 60 整除的歌曲

    在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
    返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足  i < j 且有
    (time[i] + time[j]) % 60 == 0。
    示例1:
    	输入：[30,20,150,100,40]
    	输出：3
    	解释：这三对的总持续时间可被 60 整数：
    	(time[0] = 30, time[2] = 150): 总持续时间 180
    	(time[1] = 20, time[3] = 100): 总持续时间 120
    	(time[1] = 20, time[4] = 40): 总持续时间 60
    示例2:
    	输入：[60,60,60]
    	输出：3
    	解释：所有三对的总持续时间都是 120，可以被 60 整数。
    提示:
    	1. 1 <= time.length <= 60000
    	2. 1 <= time[i] <= 500

> 解法一：
> 最暴力的手段来解决，用两层循环来遍历所有的情况，这种方式是最简单的，但是时间复杂度是 O(n2)

```java
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
```

> 解法二:
> 就是利用 hash 一次余数的个数记下来，提高命中率

```java
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
```

> 解法三：
> 就是用空间换时间，先声明一个 60 的数组，分别记录余数的个数

```java
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
```

> 这个题有许多变形，例如两个数的和等于多少;两个数的乘积等于多少，都可以用这种方式来计算
