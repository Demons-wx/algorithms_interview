package linkedlist;

/**
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * Created by wx
 * Date: 2018/1/31
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null) {

            if (cur.next.val == val) {
                ListNode del = cur.next;
                cur.next = del.next;
                del.next = null;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 6, 3, 4, 5, 6};

        ListNode pre = ListNode.createLinkedList(arr);
        System.out.println(pre);

        ListNode after = new RemoveLinkedListElements().removeElements(pre, 6);
        System.out.println(after);

    }
}
