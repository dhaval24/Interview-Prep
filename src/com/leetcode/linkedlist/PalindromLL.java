package com.leetcode.linkedlist;

/**
 * Created by Dhaval on 11/8/2016.
 */
public class PalindromLL {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode head1 = reverseList(p1);
        while (head !=null && head1 != null) {
            if (head.val != head1.val) return false;
            head = head.next;
            head1 = head1.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        head.next = null;
        return p1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(2);
//        temp = temp.next;
//        temp.next = new ListNode(1);
        System.out.println(new PalindromLL().isPalindrome(head));

    }
}
