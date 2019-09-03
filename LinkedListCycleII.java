public class LinkedListCycleII {
    // Time complexity : O(n)
    // Space complexity : O(n)
    public ListNode detectCycleI(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode node = head;
        Set<ListNode> set = new HashSet<>();
        while(node != null) {
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
            node = node.next;
        }
        return null;
    }


    // Time complexity : O(n)
    // Space complexity : O(1)
    public ListNode detectCycleII(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode start = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == slow) {
            while(start != slow) {
                start = start.next;
                slow = slow.next;
            }
            return start;
        } else {
            return null;
        }
        
    }
}