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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode head = null, copy = null;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                if(head == null){
                    head = new ListNode(list1.val);
                    copy = head;
                }
                else{
                    copy.next = new ListNode(list1.val);
                    copy = copy.next;
                }
                list1 = list1.next;
            }
            else{
                if(head == null){
                    head = new ListNode(list2.val);
                    copy = head;
                }
                else{
                    copy.next = new ListNode(list2.val);
                    copy = copy.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 != null)
            copy.next = list1;
        if(list2 != null)
            copy.next = list2;
        return head;
    }
}