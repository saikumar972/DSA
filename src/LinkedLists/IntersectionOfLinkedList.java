package LinkedLists;

import java.util.HashMap;

public class IntersectionOfLinkedList {
    public static void main(String[] args) {
        List1 head = new List1(1);
        head.next = new List1(2);
        head.next.next = new List1(3);

        // Common/intersection part
        List1 common = new List1(4);
        common.next = new List1(5);
        common.next.next = new List1(6);
        common.next.next.next = new List1(7);

        // Connect list 1 to common part
        head.next.next.next = common;

        // List 2
        List1 head2 = new List1(100);
        head2.next = new List1(200);

        // Connect list 2 to the SAME common node
        head2.next.next = common;

        List1 intersectionNode = intersectionNode(head, head2);

        System.out.println("the intersection part node value is" + intersectionNode.value);

        List1 intersectionNode2 = intersectionNode2(head, head2);

        System.out.println(intersectionNode2.value);

    }

    public static List1 intersectionNode(List1 head1, List1 head2) {
        HashMap<List1, Integer> map = new HashMap<>();
        List1 temp = head1;
        while (temp != null) {
            map.put(temp, 1);
            temp = temp.next;
        }

        List1 temp2 = head2;
        while (temp2 != null) {
            if (map.containsKey(temp2)) {
                return temp2;
            }
            temp2 = temp2.next;
        }
        return null;
    }

    public static List1 intersectionNode2(List1 head1, List1 head2) {
        int n1 = 0;
        List1 temp = head1;
        while (temp != null) {
            temp = temp.next;
            n1++;
        }

        int n2 = 0;
        List1 temp2 = head2;
        while (temp2 != null) {
            temp2 = temp2.next;
            n2++;
        }

        System.out.println(n1);
        System.out.println(n2);

        return commonNode(head1, head2, n1, n2);
    }

    public static List1 commonNode(List1 head1, List1 head2, int n1, int n2) {
        if (n1 > n2) {
            int n = n1 - n2;
            List1 temp = head1;
            int k = 0;
            while (k < n) {
                temp = temp.next;
                k++;
            }
            List1 temp2 = head2;
            return helper(temp, temp2);

        } else if (n1 < n2) {
            int n = n2 - n1;
            List1 temp = head2;
            int k = 0;
            while (k != n) {
                temp = temp.next;
                k++;
            }
            List1 temp2 = head1;
            return helper(temp, temp2);
        } else {
            List1 temp1 = head1;
            List1 temp2 = head2;
            return helper(temp1, temp2);
        }
    }

    public static List1 helper(List1 temp1, List1 temp2) {
        while (temp2 != null) {
            if (temp1 == temp2) {
                return temp2;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }
}

class List1 {
    int value;
    List1 next;

    public List1(int value, List1 next) {
        this.value = value;
        this.next = next;
    }

    public List1(int value) {
        this.value = value;
    }

}