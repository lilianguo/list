public class LinkedListCycle {
    
    /*
    Time complexity : O(n). We visit each of the nn elements in the list at most once. Adding a node to the hash table costs only O(1)O(1) time.

    Space complexity: O(n). The space depends on the number of elements added to the hash table, which contains at most nn elements.
    */
    /**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
    public boolean hasCycleI(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleII(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode f = head.next;
        ListNode s = head;
        while(f != s) {
            if (f == null || f.next == null) {
                return false;
            }
            f = f.next.next;
            s = s.next;
        }
        return true;
    }

    
}