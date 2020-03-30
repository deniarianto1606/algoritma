public class MergeTwoSortedLinkedList {

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode newNode = new ListNode(0);
    ListNode temp = newNode;
    while (true) {
      if (l1 == null && l2 == null) {
        break;
      }
      if (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
          temp.next = new ListNode(l1.val);
          l1 = l1.next;
        } else {
          temp.next = new ListNode(l2.val);
          l2 = l2.next;
        }
      } else if (l1 != null) {
        temp.next = new ListNode(l1.val);
        l1 = l1.next;
      } else if (l2 != null) {
        temp.next = new ListNode(l2.val);
        l2 = l2.next;
      }
      temp = temp.next;

    }
    return newNode.next;
  }


}
