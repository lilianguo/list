/*
21. Merge Two Sorted Lists
Easy

Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4


8?
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergeTwoSortedList {
    // time: O(m + n)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    head.next = new ListNode(l1.val);
                    l1 = l1.next;
                    head = head.next;
                } else {
                    head.next = new ListNode(l2.val);
                    l2 = l2.next;
                    head = head.next;
                }
            } else if (l1 == null) {
                head.next = l2;
                l2 = null;
            } else {
                head.next = l1;
                l1 = null;
            }
        }
        return dummy.next;
    }

    public ListNode mergeTwoListsII(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        head.next = new ListNode(Math.min(l1.val, l2.val));
        if (l1.val < l2.val) {
            l1 = l1.next;
        } else {
            l2 = l2.next;
        }
        head = head.next;
        head.next = mergeTwoLists(l1, l2);
        return dummy.next;
    }
}