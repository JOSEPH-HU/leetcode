public class ReverseKGroup{
	public static void main(String[] args) {

	}

	 public ListNode reverseKGroup(ListNode head, int k) {
		 if(head==null) return null;
         ListNode cur = head;
         int i = k;
         // 先遍历找到下一段的开头
         while(i>0&&cur!=null){
             cur = cur.next;
             i--;
         }
         // 如果没有到k个，那么原顺序返回
         if(i>0) return head;
         // 关键在于这个位置，返回值拼接到当前段翻转后的尾结点即可
         // 而尾结点就是原链表在当前段的头
         ListNode pre = reverseKGroup(cur,k);
         cur = head;
         i = k;
         while(i>0){
             ListNode tmp = cur.next;
             cur.next= pre;
             pre = cur;
             cur = tmp;
             i--;
         }
         return pre;
    }

}
