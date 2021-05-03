package desmedt.bac.trees;

import desmedt.bac.test.TestUtils;

/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s),
which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
 */
public class SerializeDeserializeTree {

    public static void main(String[] args) {
        String node = "Node('45', Node('23', Node('16')), Node('99'))";
        Node n = Node.deserialize(node);

        TestUtils.test(n, node, Node::serialize);
    }

    static class Node {

        public final int value;
        public Node left, right;

        public Node(int root) {
            this(root, null, null);
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public static Node deserialize(String source) {
            if (source == null || source.isEmpty()) return null;

            int index1 = source.indexOf("'");
            int index2 = source.indexOf("'", index1 + 1);
            int val = Integer.parseInt(source.substring(index1 + 1, index2));

            if ((index2 + 2) < source.length()) {
                String branches = source.substring(index2 + 2, source.length() - 1).trim();
                int counter = 0;
                int index = branches.length();
                for (int i = 0; i < branches.length(); i++) {
                    if (branches.charAt(i) == '(') {
                        counter++;
                    } else if (branches.charAt(i) == ')') {
                        counter--;
                        if (counter == 0) {
                            index = Math.min(index, i);
                        }
                    }
                }
                String left = null;
                String right = null;
                if (index < branches.length() - 1) {
                    left = branches.substring(0, index + 1);
                    right = branches.substring(index + 2).trim();
                } else {
                    left = branches;
                }

                return new Node(val, deserialize(left), deserialize(right));
            } else return new Node(val);
        }

        public String serialize() {
            StringBuilder builder = new StringBuilder(getClass().getSimpleName());
            builder.append("('");
            builder.append(value);
            builder.append("'");

            if (left != null) {
                builder.append(", ");
                builder.append(left.serialize());
            }
            if (right != null) {
                builder.append(", ");
                builder.append(right.serialize());
            }
            builder.append(")");

            return builder.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Node) {
                Node other = (Node) obj;
                return this.serialize().equals(other.serialize());
            }
            return false;
        }
    }
}
