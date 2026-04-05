/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev_node = null;
        ListNode curr_node = head;

        while(curr_node != null){
            ListNode next_node = curr_node.next;
            curr_node.next = prev_node;
            prev_node = curr_node;
            curr_node = next_node;

        }
        return prev_node;
    }
}
