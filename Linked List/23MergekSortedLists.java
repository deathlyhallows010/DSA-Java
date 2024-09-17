import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    // Divide and conquor
    public ListNode mergeKLists(ListNode[] lists) {
        if( lists == null || lists.length ==0){
            return null;
        }

        while(lists.length>1){
            List<ListNode> mergedLists = new ArrayList<>();
            for(int i=0;i<lists.length;i+=2){
                ListNode l1 = lists[i];
                ListNode l2 = ((i+1)<lists.length) ? lists[i+1] : null;
                mergedLists.add(this.mergeTwoLists(l1, l2));                
            }
             // Convert List<ListNode> to ListNode[] (manual conversion)
            lists = mergedLists.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr = new ListNode();
        ListNode tail = curr;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        } else if (list2 != null) {
            tail.next = list2;
        }

        return curr.next; // Dummy node
    }
}