/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 /*
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
*/
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        // traverse to m location
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        ListNode prevM = head;
        ListNode mNode = head.next;
        
        // reverse between m and n
        ListNode nNode = mNode;
        ListNode postnNode = mNode.next;
        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode tmp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = tmp;
        }
        // connect 3 parts together
        prevM.next = nNode;
        mNode.next = postnNode;
        return dummy.next;
    }
}
