public class MyAtoi{
	public static void main(String[] args) {
		//String str = "4193 with words";		
		//String str = "-91283472332";
		//String str = "-";
		//String str = "-+1";
		String str = "r1";
		System.out.println(solution(str));
	}

	public static int solution(String str){
		if(str==null){
			return 0;
		}

		int len = str.length();
		int i = 0;
		boolean  flag = false;
		int result = 0;

		//去除空格
		while(i<len&&str.charAt(i)==' '){
			i++;
		}

		//i等于n说明都是空格
		if(i==len){
			return 0;
		}

		if(str.charAt(i)=='-'){
			flag = true;
			i++;
		}else if(str.charAt(i)=='+'){
			i++;
		}

		while(i<len){
			if(Character.isDigit(str.charAt(i))){
				if(flag){
					if(result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && (str.charAt(i)-'0')>8)){
						return Integer.MAX_VALUE+1;
					}
				}else{
					if(result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && (str.charAt(i)-'0')>7)){
						return Integer.MAX_VALUE;
					}
				}
			}else{
				break;
			}
			result = result*10 + (str.charAt(i)-'0');
			i++;
		}
		return flag?-1*result:result;
	}
}
