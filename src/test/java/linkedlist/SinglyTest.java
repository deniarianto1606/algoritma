package linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SinglyTest {
    @Test
    public void SinglyLinkedList_AddFirst_NextMustNull(){
        Singly singly = new Singly();
        singly.add(4);
        Assertions.assertNull(singly.singlyNode.next);
    }

    @Test
    public void SinglyLinkedList_AddTwoData_HeadMustNotNullAndTailMustNull(){
        Singly singly = new Singly();
        singly.add(4);
        singly.add(8);
        Assertions.assertNotNull(singly.singlyNode.next);
        Assertions.assertNotNull(singly.head);
        Assertions.assertNotNull(singly.tail);
    }


    @Test
    public void SinglyLinkedList_AddFirst_HeadMustNotNullAndTailMustNull(){
        Singly singly = new Singly();
        singly.addFirst(4);
        singly.addFirst(8);
        Assertions.assertNotNull(singly.singlyNode.next);
        Assertions.assertNotNull(singly.head);
        Assertions.assertNotNull(singly.tail);
    }

    @Test
    public void SinglyLinkedList_AddAtIndex_HeadMustNotNullAndTailMustNull(){
        Singly singly = new Singly();
        singly.add(1);
        singly.add(2);
        singly.add(3);
        singly.add(4);
        singly.addAtIndex(10, 2);
        Assertions.assertNotNull(singly.singlyNode.next);
        Assertions.assertNotNull(singly.head);
        Assertions.assertNotNull(singly.tail);
    }

    @Test
    public void SinglyLinkedList_MergeTwoOrderedLinkedList(){
        Singly singly = new Singly();
        singly.add(1);
        singly.add(5);
        singly.add(8);

        Singly singly2 = new Singly();
        singly2.add(3);
        singly2.add(4);
        singly2.add(20);

        Singly singly3 = new Singly().mergeOrderedLinkedList(singly, singly2);
        System.out.println(singly3);
    }
}
