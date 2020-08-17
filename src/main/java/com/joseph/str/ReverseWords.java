package com.joseph.str;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *

 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class ReverseWords {
    public static void main(String[] args) {

        String a1 = solution("a good   example");
        assert a1 == "example good a";

        String a2 = solution("  hello world!  ");
        assert a2 == "world! hello";

        String a3 = solution("the sky is blue");
        assert a3 == "blue is sky the";

        String a4 = solution("a good   example");
        assert a4 == "example good a";

    }

    public static String solution(String s){

        int left = 0,right = s.length()-1;

        while(left<=right && s.charAt(left)==' '){
            ++left;//去除头部的空格
        }

        while (left<=right&&s.charAt(right)==' '){
            --right;//去除尾部的空格
        }

        Deque<String> d = new ArrayDeque();//双端队列
        StringBuilder sb = new StringBuilder();

        while (left<=right){
            char c = s.charAt(left);
            if(sb.length()!=0 && c==' '){
                d.offerFirst(sb.toString());
                sb.setLength(0);
            }else if(c!=' '){
                sb.append(c);
            }
            left++;
        }

        d.offerFirst(sb.toString());


        return String.join(" ",d);
    }
}
