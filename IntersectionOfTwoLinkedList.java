class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while (temp1 != temp2) {
            temp1 = (temp1 == null) ? headB : temp1.next;
            temp2 = (temp2 == null) ? headA : temp2.next;
        }
        return temp1;
    }

    public static void main(String[] args) {
        // Create intersection nodes
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);

        // First linked list: 4 -> 1 -> 8 -> 4
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // Second linked list: 5 -> 6 -> 1 -> 8 -> 4
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        IntersectionOfTwoLinkedList iotl = new IntersectionOfTwoLinkedList();
        ListNode intersection = iotl.getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection");
        }
    }
}
