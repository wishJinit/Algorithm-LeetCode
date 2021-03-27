package challenge.y2021_week11;

// https://leetcode.com/problems/intersection-of-two-linked-lists/
// Intersection of Two Linked Lists
// 참고 : https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49792/Concise-JAVA-solution-O(1)-memory-O(n)-time

public class Q04 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode lnA = headA;
        while (lnA != null) {
            ListNode lnB = headB;
            while (lnB != null) {
                if (lnA.val == lnB.val && lnA.hashCode() == lnB.hashCode()) {
                    return lnB;
                }
                lnB = lnB.next;
            }
            lnA = lnA.next;
        }
        return null;
    }
}
