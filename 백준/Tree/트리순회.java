package 백준.boj_230510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회 {

    static class Node {
        char root;
        Node left;
        Node right;

        Node(char root, Node left, Node right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }

    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            inputNode(head, root, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();
    }

    // 트리입력
    public static void inputNode(Node temp, char root, char left, char right) {
        if (temp.root == root) {
            temp.left = (left == '.' ? null : new Node(left, null, null));
            temp.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            if (temp.left != null) inputNode(temp.left, root, left, right);
            if (temp.right != null) inputNode(temp.right, root, left, right);
        }
    }

    // 전위
    public static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.root);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위
    public static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.root);
        inOrder(node.right);
    }

    // 후위
    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.root);
    }
}
