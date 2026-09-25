package LinkedLists;

public class MergeSortedLinkedList {
    public static void main(String[] args) {

        // List 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        // List 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(6);

        ListNode result = mergeTwoLists(head, head2);

        while (result != null) {
            System.out.println("result " + result.value);
            result = result.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 != null) {
            return list2;
        } else if (list2 == null && list1 != null) {
            return list1;
        } else if (list1 == null && list2 == null) {
            return null;
        } else {
            ListNode temp1 = list1;
            ListNode temp2 = list2;
            ListNode temp = new ListNode(100);
            ListNode tail = temp;
            while (temp1 != null && temp2 != null) {
                if (temp1.value <= temp2.value) {
                    tail.next = temp1;
                    temp1 = temp1.next;
                } else {
                    tail.next = temp2;
                    temp2 = temp2.next;
                }
                tail = tail.next;
            }
            tail.next = temp1 != null ? temp1 : temp2;
            return temp.next;
        }
    }

}