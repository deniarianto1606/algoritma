package linkedlist;

public class Singly {
    public SinglyNode singlyNode;
    public SinglyNode head;
    public SinglyNode tail;
    public int length = 0;

    public Singly(){

    }

    public void add(int value){
        if(head == null && tail == null){
            singlyNode = new SinglyNode(value, null);
            head = singlyNode;
            tail = singlyNode;
            return;
        }
        SinglyNode node = new SinglyNode(value, null);
        tail.next = node;
        tail = node;
        length++;
    }

    public void addFirst(int value) {
        if(head == null){
            add(value);
            return;
        }

        SinglyNode node = new SinglyNode(value, head);
        head = node;
        singlyNode = head;
        length++;
    }

    public void addAtIndex(int value, int index){
        if(index > length){
            return;
        }

        int counter = 0;
        SinglyNode temp = singlyNode;
        SinglyNode nextTemp = singlyNode.next;
        while(true){
            if(counter == index){
                SinglyNode node = new SinglyNode(value, null);
                temp.next = node;
                node.next = nextTemp;
                length++;
                break;
            }
            temp = temp.next;
            nextTemp = temp.next;
            counter++;
        }
    }

    public Singly mergeOrderedLinkedList(Singly a, Singly b){
        Singly singly = new Singly();
        SinglyNode tempA = a.singlyNode;
        SinglyNode tempB = b.singlyNode;
        while(true){
            if(tempA.next == null || tempB.next == null){
                break;
            }
            if(tempA.value < tempB.value){
                singly.add(tempA.value);
                tempA = tempA.next;
            }else{
                singly.add(tempB.value);
                tempB = tempB.next;
            }
        }

        while(tempA != null){
            singly.add(tempA.value);
            tempA = tempA.next;
        }


        while(tempB != null){
            singly.add(tempB.value);
            tempB = tempB.next;
        }

        return singly;
    }
}
