package desmedt.bac.linkedlists;

import desmedt.bac.test.TestUtils;

/*
    given a linked list of integers list, create a function
    that reverses it without using an additional data structure.
    For linked list 20->40->60->80, the reversed linked list is 80->60->40->20
*/
public class ReverseLinkedList {

    public static void main(String[] args) {
        int[] values = { 20, 40, 60, 80 };
        int[] reversedValues = { 80, 60, 40, 20 };
        LinkedList list = new LinkedList(values);
        LinkedList reversedList = new LinkedList(reversedValues);

        TestUtils.test(list.node, reversedList.node, ReverseLinkedList::reverse);
    }


    public static LLNode reverse(LLNode node) {
        LLNode previous = null;
        while(node!=null){
            var next = node.next;  //get the next one
            node.next = previous; // set the next to the previous
            previous = node; // set the previous to the current
            node = next;    // set the current to the next one
        }

        return previous;
    }
}
