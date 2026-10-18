package LinkedLists;

public class MidNodeInLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(25);

        Node midNode = midNode(head);

        System.out.println(midNode.data);
    }

    private static Node midNode(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while(fastPointer!=null && fastPointer.next.next!=null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }
}
