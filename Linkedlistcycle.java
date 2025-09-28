
import java.util.*;

class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}
public class Linkedlistcycle{
public boolean hasCycle(ListNode head){
ListNode slow=head,fast=head;

while(fast!=null && fast.next!=null){
    slow=slow.next;
    fast=fast.next.next;

    if(slow==fast){
        return true;
    }
}
return false;
}

public static void main(String[] args) {
 Linkedlistcycle llc=new Linkedlistcycle();   

 ListNode head=new ListNode(1);
   head.next=new ListNode(2);
  head.next.next=new ListNode(3);
    head.next.next.next=new ListNode(4);

    head.next.next.next.next=head.next;

    boolean result=llc.hasCycle(head);
    System.out.println("Linked list has cycle: "+result);
}
}