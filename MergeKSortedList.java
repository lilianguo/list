/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
class MergeKSortedList {

    // divide and conquer
    // time complexity O(NlogK) where K is the number o linkedlists 
    //                                N is the total number of nodes in two lists
    // space: O(1)
    // step 1: pair up K lists into K/2 lists
    // then to k/4, k/8, down to 1
    public ListNode mergeKSortedList(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.size() - 1);
    }
    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        int mid = start + (end - start)/2;
        ListNode leftMerge = mergeHelper(lists, start, mid);
        ListNode rightMerge = mergeHelper(lists, mid + 1, end);
        return mergeTwoSortedList(leftMerge, rightMerge);
    }
    private ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = new ListNode(l1.val);
                l1 = l1.next;
                tail = tail.next;
            } else {
                tail.next = new ListNode(l2.val);
                l2 = l2.next;
                tail = tail.next;
            }
        }
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }
        return dummy.next;
    }
}