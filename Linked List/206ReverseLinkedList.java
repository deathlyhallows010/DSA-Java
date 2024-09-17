
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    
    ListNode(int val) { 
        this.val = val; 
    }
    ListNode(int val, ListNode next) {
        this.val = val; 
        this.next = next; }
 }

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode RecReverseList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode newHead = head;
        if (head.next != null){
            newHead = this.RecReverseList(head.next);
            head.next.next = head; // To good
        }
        head.next = null;
        return newHead;
    }
}