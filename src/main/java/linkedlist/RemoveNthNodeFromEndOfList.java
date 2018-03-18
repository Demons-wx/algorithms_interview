package linkedlist;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * <p>
 * Created by wx
 * Date: 2018/2/1
 */
public class RemoveNthNodeFromEndOfList {

    // 双指针 + 滑动窗口
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p = dummy;
        ListNode q = dummy;

        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        ListNode del = p.next;
        p.next = del.next;

        return dummy.next;
    }

    public static void main(String[] args) {

        int[] arr = {1};
        ListNode pre = ListNode.createLinkedList(arr);

        ListNode after = new RemoveNthNodeFromEndOfList().removeNthFromEnd(pre, 1);
        System.out.println(after);

    }
}
