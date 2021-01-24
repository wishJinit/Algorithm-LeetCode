package challenge.week02_2021_january_8th_january_14th;

// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3601/
// Add Two Numbers

import java.math.BigInteger;

public class Q03 {
    public static class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1 = getNumByListNode(l1, 0), num2 = getNumByListNode(l2, 0);
        BigInteger sum = num1.add(num2);
        char[] chars = sum.toString().toCharArray();
        return buildListNode(chars, chars.length - 1);
    }

    BigInteger getNumByListNode(ListNode listNode, int deep) {
        BigInteger val = new BigInteger(Integer.toString(listNode.val)).multiply(new BigInteger(stringPow(deep)));
        if (listNode.next == null) return val;
        return getNumByListNode(listNode.next, deep + 1).add(val);
    }

    ListNode buildListNode(char[] chars, int idx) {
        if (idx == -1) return null;
        return new ListNode(chars[idx] - '0', buildListNode(chars, idx - 1));
    }

    private String stringPow(int deep) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append("0".repeat(Math.max(0, deep)));
        return sb.toString();
    }
}
