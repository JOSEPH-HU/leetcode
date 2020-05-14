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
