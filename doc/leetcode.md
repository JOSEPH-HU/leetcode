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

## 136. 只出现一次的数字

    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    说明：
    	你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
    示例1：
    	输入: [2,2,1]
    	输出: 1
    示例2:
    	输入: [4,1,2,1,2]
    	输出: 4

> 解法一：
> 借助 map 数字为 key，相同的累计加一，最后在遍历 map 为 1 的就是该要的结果，这种不符合要求
> 解法二：
> 异或的公式异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b

```java
public static int solution2(int[] nums){
		int result = 0;
		for(int i=0;i<nums.length;i++){
			result ^= nums[i];
		}
		return result;
	}
```

> 改题变形，例如缺失数字,找不同的数字

## 2. 两数相加

    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节
    点只能存储 一位 数字。
    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    示例一:
    	输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    	输出：7 -> 0 -> 8
    	原因：342 + 465 = 807

> 这个题目主要考察链表相关的问题，要知道链表的声明和赋值遍历等，就是要注意有进位就可以;

```java
public class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}
public class AddTwoNumbers{
	public static void main(String[] args) {
		ListNode l1 = new ListNode(4);
		ListNode l1_2 = new ListNode(5);
		ListNode l1_3 = new ListNode(6);
		l1.next = l1_2;
		l1_2.next = l1_3;

		ListNode l2 = new ListNode(5);
		ListNode l2_2 = new ListNode(4);
		ListNode l2_3 = new ListNode(7);
		l2.next = l2_2;
		l2_2.next = l2_3;
		ListNode result = solution(l1,l2);
		while(result!=null){
			System.out.println(result.val);
			result = result.next;
		}
	}

	public static ListNode solution(ListNode l1,ListNode l2){
		ListNode result = new ListNode(0);
		ListNode p = l1;
		ListNode q = l2;
		ListNode current = result;
		int carry = 0;

		while(p!=null || q!=null){
			int x = p==null? 0 : p.val;
			int y = q==null?0 : q.val;
			System.out.println(x + "=" + y);
			int sum = carry + x + y;
			carry = sum / 10;
			current.next = new ListNode(sum%10);
			current = current.next;
			if(p!=null){
				p = p.next;
			}
			if(q!=null){
				q = q.next;
			}
		}
		if(carry>0){
			current.next = new ListNode(carry);
		}
		return result.next;
	}
}
```

> 扩展题，加减乘除

## 3. 无重复字符的最长子串

    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    示例一:
    	输入: "abcabcbb"
    	输出: 3
    	解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例二:
    	输入: "bbbbb"
    	输出: 1
    	解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例三:
    	输入: "pwwkew"
    	输出: 3
    	解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    	请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
