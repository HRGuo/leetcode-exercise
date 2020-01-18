package org.guo.leetCode;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (null == head || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        ListNode prev = null;
        ListNode cur = slow;
        ListNode next = cur.next;
        while (cur != null && next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = prev;
        slow = cur;

        fast = head;
        while (fast != null && slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(2);
        l2.next = l3;
        ListNode l4 = new ListNode(1);
        l3.next = l4;
        System.out.println(new IsPalindrome().isPalindrome(l1));
    }
}
