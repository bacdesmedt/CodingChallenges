package desmedt.bac.trees;

/*
    Given a binary tree root, create 3 functions to print the elements,
    one for preorder, one for inorder, and one for post order

    Preorder = print root date, then print left subtree, then print right subtree
    Inorder = print left subtree, then print root date, then print right subtree
    Postorder = print left subtree, then print right subtree, then print root date
 */
public class TreeDepthFirstSearch {

    public static void main(String[] args) {
        TNode tree = new TNode(4);

        tree.left = new TNode(6);
        tree.right = new TNode(7);

        tree.left.left = new TNode(3);
        tree.left.right = new TNode(5);

        tree.right.left = new TNode(1);
        tree.right.right = new TNode(2);

        System.out.print("PREORDER: ");
        printPreOrder(tree);
        System.out.println();

        System.out.print("INORDER: ");
        printInOrder(tree);
        System.out.println();

        System.out.print("POSTORDER: ");
        printPostOrder(tree);
        System.out.println();
    }

    public static void printPreOrder(TNode tree) {
        if (tree != null) {
            System.out.print(tree.value + " ");
            printPreOrder(tree.left);
            printPreOrder(tree.right);
        }
    }

    public static void printInOrder(TNode tree) {
        if (tree != null) {
            printInOrder(tree.left);
            System.out.print(tree.value + " ");
            printInOrder(tree.right);
        }
    }

    public static void printPostOrder(TNode tree) {
        if (tree != null) {
            printPostOrder(tree.left);
            printPostOrder(tree.right);
            System.out.print(tree.value + " ");
        }
    }

}
