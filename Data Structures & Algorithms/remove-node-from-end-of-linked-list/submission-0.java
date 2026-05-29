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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;
        int size = 0;
        ListNode current = head;
        while(current != null){
            current = current.next;
            size++;
        }
        int target = size - n;
        if(target == 0)
            return head.next;
        current = head;
        int start = 0;
        while(start < target){
            if(start == target -1){
                current.next = current.next.next;
                break;
            }
            current = current.next;
            start++;
        }
        return head;
    }
}
