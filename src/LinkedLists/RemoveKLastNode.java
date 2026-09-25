package LinkedLists;

public class RemoveKLastNode {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        int k = 2;
        Node dummy = new Node(100);
        dummy.next = head;
        Node headPointer = dummy;
        Node trailPointer = dummy;

        while (k > 0) {
            headPointer = headPointer.next;
            k--;
        }

        while (headPointer.next != null) {
            headPointer = headPointer.next;
            trailPointer = trailPointer.next;
        }

        trailPointer.next = trailPointer.next.next;

    }
}

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }
}