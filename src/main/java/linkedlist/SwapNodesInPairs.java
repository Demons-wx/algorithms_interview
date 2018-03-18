package linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * <p>
 * Created by wx
 * Date: 2018/2/1
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;

        while (pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node1.next = next;
            node2.next = node1;
            pre.next = node2;

            pre = node1;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        ListNode head = ListNode.createLinkedList(arr);
        System.out.println(head);

        ListNode head2 = new SwapNodesInPairs().swapPairs(head);
        System.out.println(head2);

    }

}
