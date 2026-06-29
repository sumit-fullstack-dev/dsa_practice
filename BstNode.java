package tree;

class BstNode {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Node node = null;

        node = insert(node, 4);
        node = insert(node, 2);
        node = insert(node, 1);
        node = insert(node, 3);
        node = insert(node, 6);
        node = insert(node, 5);

        inOrder(node);
    }

    public static Node insert(Node root, int data) {

        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static void inOrder(Node node) {

        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }
}