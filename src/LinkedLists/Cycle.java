package LinkedLists;

public class Cycle {
    public static void main(String[] args) {
         ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        boolean k = hasCycle(head);
        System.out.println(k);
    }
    public static boolean hasCycle(ListNode head) {
        int k=0;
        ListNode temp = head;
        while(temp!=null){
            k++;
            temp = temp.next;
        }
        if(k>2){
            return true;
        }
        else{
            return false;
        }
    }
}

