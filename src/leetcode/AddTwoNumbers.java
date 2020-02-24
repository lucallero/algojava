package leetcode;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

        // Input: (2 -> 4 -> 3) + (5 -> 6 -> 4);
        // Output: 7 -> 0 -> 8;
        // Explanation: 342 + 465 = 807.;

        // ListNode l1 = new ListNode(2);
        // l1.next = new ListNode(4);
        // l1.next.next = new ListNode(3);

        // ListNode l2 = new ListNode(5);
        // l2.next = new ListNode(6);
        // l2.next.next = new ListNode(4);

        AddTwoNumbers app = new AddTwoNumbers();
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        app.addTwoNumbers(l1, l2);

    }

}