package desmedt.bac.linkedlists;

import desmedt.bac.test.TestUtils;

import java.util.HashSet;

/*
    Write a Java program to remove duplicates from a sorted linked list.
    Original List with duplicate elements:
    12->12->13->14->15->15->16->17->17
    After removing duplicates from the said list:
    12->13->14->15->16->17
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] values = { 12, 12, 13, 14, 15, 15, 16, 17, 17 };
        int[] expectedValues = { 12, 13, 14, 15, 16, 17 };
        LinkedList list = new LinkedList(values);
        LinkedList expected = new LinkedList(expectedValues);

        TestUtils.test(list, expected, RemoveDuplicates::removeDuplicates);
    }

    public static LinkedList removeDuplicates(LinkedList list) {
        HashSet<Integer> set = new HashSet<>();
        LLNode node = list.node;
        while (node != null){
            if(set.contains(node.data)) list.remove(node.data);
            else set.add(node.data);

            node = node.next;
        }

        return list;
    }
}
