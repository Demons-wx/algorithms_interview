package linkedlist;

/**
 * Created by wx
 * Date: 2018/2/1
 */
public class ListNode {

    int val;
    linkedlist.ListNode next;
    ListNode(int x) {
        this.val = x;
    }

    public String toString() {
        return val + "->" + next;
    }

    public static linkedlist.ListNode createLinkedList(int[] arr) {

        linkedlist.ListNode head = new linkedlist.ListNode(arr[0]);
        linkedlist.ListNode cur = head;

        for (int i = 1; i < arr.length; i++) {
            cur.next = new linkedlist.ListNode(arr[i]);
            cur = cur.next;
        }

        return head;
    }

}
