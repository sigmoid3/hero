package utils;

import java.util.Stack;

/**
 * @Author: sandro
 * @Create: 2019-09-07
 * @Description:
 **/

public class BinaryTree {

    public static void printNode(Node<String> node) {
        System.out.print(node.getVal() + "  ");
    }

    public Node<String> init() {
        Node<String> D = new Node<String>("D", null, null);
        Node<String> H = new Node<String>("H", null, null);
        Node<String> I = new Node<String>("I", null, null);
        Node<String> J = new Node<String>("J", null, null);
        Node<String> K = new Node<String>("K", null, null);
        Node<String> G = new Node<String>("G", K, null);
        Node<String> F = new Node<String>("F", null, J);
        Node<String> E = new Node<String>("E", H, I);
        Node<String> B = new Node<String>("B", D, E);
        Node<String> C = new Node<String>("C", F, G);
        Node<String> root = new Node<String>("A", B, C);
        return root;
    }

    public static void preOrder(Node<String> node) {
        printNode(node);
        if (node.getLeft() != null) {
            preOrder(node.getLeft());
        }
        if (node.getRight() != null) {
            preOrder(node.getRight());
        }
    }

    public static void inOrder(Node<String> node) {
        if (node.getLeft() != null) {
            inOrder(node.getLeft());
        }
        printNode(node);
        if (node.getRight() != null) {
            inOrder(node.getRight());
        }
    }

    public static void postOrder(Node<String> node) {
        if (node.getLeft() != null) {
            postOrder(node.getLeft());
        }
        if (node.getRight() != null) {
            postOrder(node.getRight());
        }
        printNode(node);
    }

    // Traversal without recursion
    protected static void iterativePreorder(Node<String> node) {
        Stack<Node<String>> stack = new Stack<Node<String>>();
        if (node != null) {
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                printNode(node);
                if (node.getRight() != null) {
                    stack.push(node.getRight());
                }
                if (node.getLeft() != null) {
                    stack.push(node.getLeft());
                }
            }
        }
    }

    protected static void iterativeInorder(Node<String> node) {
        Stack<Node<String>> stack = new Stack<Node<String>>();
        while (node != null) {
            while (node != null) {
                if (node.getRight() != null) { stack.push(node.getRight()); }
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            while (!stack.isEmpty() && node.getRight() == null) {
                printNode(node);
                node = stack.pop();
            }
            printNode(node);
            if (!stack.isEmpty()) { node = stack.pop(); } else { node = null; }
        }
    }

    protected static void iterativePostorder(Node<String> node) {
        Node<String> prev = node;
        Stack<Node<String>> stack = new Stack<Node<String>>();
        while (node != null) {
            for (; node.getLeft() != null; node = node.getLeft()) { stack.push(node); }
            while (node != null && (node.getRight() == null || node.getRight() == prev)) {
                printNode(node);
                prev = node;
                if (stack.isEmpty()) { return; }
                node = stack.pop();
            }
            stack.push(node);
            node = node.getRight();
        }
    }
}
