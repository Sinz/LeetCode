package com.company;
/**
 * @Des
 * 给出两个?非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照?逆序?的方式存储的，并且它们的每个节点只能存储?一位?数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0?开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * Related Topics
 * 链表
 * 数学
 * @Author
 * @Date
 */
public class LeetCode_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 1. 判断是否为0
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        // 2. 当l1 和 l2都存在时
        int carry = 0 ;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(l1 != null && l2 !=null){
            int sum = l1.val + l2.val + carry;
            int val = sum%10;
            carry = sum/10;

            ListNode newNode = new ListNode(val);
            current.next = newNode;
            current = current.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        // 3. l1 或 l2 不存在时
        while(l1 != null){
            int sum = l1.val + carry;
            int val = sum%10;
            carry = sum/10;
            ListNode newNode = new ListNode(val);
            current.next = newNode;
            current = current.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int sum = l2.val + carry;
            int val = sum%10;
            carry = sum/10;
            ListNode newNode = new ListNode(val);
            current.next = newNode;
            current = current.next;
            l2 = l2.next;
        }

        // 4. 当 l1 和 l2 都不存在时，判断carry是否为0
        if(carry != 0) current.next = new ListNode(carry);
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int newNode) {
            this.val = newNode;
        }
    }

}
