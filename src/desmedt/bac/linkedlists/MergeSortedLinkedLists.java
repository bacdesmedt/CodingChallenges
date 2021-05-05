package desmedt.bac.linkedlists;

import desmedt.bac.test.TestUtils;

/*
\Write a Java program to merge two given sorted lists.
Sample Output:
Merge Two Sorted ListsT:
1 2 3 7 9 13 40
 */
public class MergeSortedLinkedLists {

    public static void main(String[] args) {

        LinkedList list1 = new LinkedList(new int[]{ 1, 2, 9, 13 });
        LinkedList list2 = new LinkedList(new int[]{ 3, 7, 40 });

        LinkedList expected = new LinkedList(new int[]{ 1, 2, 3, 7, 9, 13, 40 });

        TestUtils.test(list1.node, list2.node, expected, MergeSortedLinkedLists::merge);
    }

    public static LinkedList merge(LLNode node1, LLNode node2) {
        LinkedList merged = new LinkedList();
        int nextValue;

        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                nextValue = node1.data;
                node1 = node1.next;
            } else {
                nextValue = node2.data;
                node2 = node2.next;
            }
            merged.append(nextValue);
        }

        merged.appendAll(node1 == null ? node2 : node1);

        return merged;
    }
}
