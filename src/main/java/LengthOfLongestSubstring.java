import java.util.LinkedHashSet;

public class LengthOfLongestSubstring{
	public static void main(String[] args) {
		//String s = "abcabcbb";
		//String s = "bbbbb";
		//String s = "pwwkew";
		String s = " ";
		System.out.println(solution(s));

	}

	public static int solution(String s){
		//存放字符串
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		//子串的长度
		int result = 0;
		//右指针的位置
		int rk = 0;
		int len = s.length();
		for(int i=0;i<len;i++){
			if(i!=0){
				set.remove(s.charAt(i-1));
			}
			while(rk<len&&!set.contains(s.charAt(rk))){
				set.add(s.charAt(rk));
				++rk;
			}
			result = Math.max(result, set.size());
		}
		return result;
	}
}
