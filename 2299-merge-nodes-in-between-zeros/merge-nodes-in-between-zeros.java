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
    public ListNode mergeNodes(ListNode head) {
        head = head.next;
        if(head == null){
            return head;
        }
        ListNode curr = head;
        int sum = 0;
        while(curr.val != 0){
            sum += curr.val;
            curr = curr.next;
        }
        head.val = sum;
        head.next = mergeNodes(curr);
        return head;
    }
}