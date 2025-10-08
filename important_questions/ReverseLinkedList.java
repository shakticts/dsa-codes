package important_questions;

public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private static ListNode build(int[] a) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : a) { cur.next = new ListNode(v); cur = cur.next; }
        return dummy.next;
    }

    private static void print(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) { sb.append(head.val).append(" -> "); head = head.next; }
        sb.append("null");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        ListNode head = build(new int[]{1,2,3,4,5});
        System.out.print("Original: "); print(head);
        ListNode rev = reverse(head);
        System.out.print("Reversed: "); print(rev);
    }
}
