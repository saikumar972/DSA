package LinkedLists;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode nextListNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextListNode;
        }
        head = prev;
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
}
class ListNode {
    int value;
    ListNode next;

    ListNode(int value){
        this.value = value;
    }

    ListNode(int value, ListNode next){
        this.value = value;
        this.next = next;
    }
}