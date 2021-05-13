package two;

/**
 * 力扣二题
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lhy
 * @version 1.0
 * @date 2021/4/29 8:57
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode parent = null;
        // 余数
        int number = 0;
        for (; ; ) {
            if (l1 == null && l2 == null) {
                break;
            }
            if (l1 != null) {
                number += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                number += l2.val;
                l2 = l2.next;
            }
            System.err.println(number + "\t" + number % 10 + "\t" + number / 10);
            ListNode node = new ListNode(number % 10);
            if (parent == null) {
                parent = node;
            } else {
                ListNode cur = parent;
                //遍历结点
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = node;
            }
            number /= 10;
        }
        if (number != 0){
            ListNode cur = parent;
            //遍历结点
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new ListNode(number % 10);
        }
        return parent;
    }

    public static void main(String[] args) {
        // 先把l1 l2放进去
        int[] l1 = new int[]{9, 9, 9, 9, 9, 9, 9}, l2 = new int[]{9, 9, 9, 9};
        ListNode listNode1 = null, listNode2 = null;
        for (int i = 0; i < l1.length; i++) {
            listNode1 = insertNode(listNode1, new ListNode(l1[i]));
        }
        for (int i = 0; i < l2.length; i++) {
            listNode2 = insertNode(listNode2, new ListNode(l2[i]));
        }
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        print(listNode);
        // 7 0 8
    }

    public static ListNode insertNode(ListNode parent, ListNode next) {
        if (parent == null) {
            parent = next;
        } else {
            ListNode cur = parent;
            //遍历结点
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = next;
        }
        return parent;
    }

    public static void print(ListNode node) {
        if (node != null) {
            do {
                System.out.printf("%d \t", node.val);
                node = node.next;
            } while (node != null);
        }
        System.out.println();
    }
}


