package desmedt.bac.trees;

import desmedt.bac.test.TestUtils;

/*
    Given a binary tree of integers root,
    create a function that reverses it left to right in place
 */
public class ReverseBinaryTree {

    public static void main(String[] args) {

        TNode tree = getTree();
        TNode rTree = getReversedTree();

        TestUtils.test(tree,rTree,ReverseBinaryTree::treeReversed);

    }

    public static TNode getReversedTree() {
        var tree = new TNode(4);

        tree.right = new TNode(6);
        tree.left = new TNode(7);

        tree.right.right = new TNode(3);
        tree.right.right.right = new TNode(9);
        tree.right.left = new TNode(5);

        tree.left.right = new TNode(1);
        tree.left.left = new TNode(2);
        tree.left.left.left = new TNode(8);

        return tree;
    }

    public static TNode getTree() {
        var tree = new TNode(4);

        tree.left = new TNode(6);
        tree.right = new TNode(7);

        tree.left.left = new TNode(3);
        tree.left.left.left = new TNode(9);
        tree.left.right = new TNode(5);

        tree.right.left = new TNode(1);
        tree.right.right = new TNode(2);
        tree.right.right.right = new TNode(8);

        return tree;
    }

    public static TNode treeReversed(TNode tree) {
        reverseBinaryTree(tree);
        return tree;
    }

    public static void reverseBinaryTree(TNode tree) {
        if (tree != null) {
            tree.reverseNodes(); //implemented in popular.TNode.class
            reverseBinaryTree(tree.left);
            reverseBinaryTree(tree.right);
        }
    }
}
