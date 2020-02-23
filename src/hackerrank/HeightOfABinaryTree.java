package hackerrank;

import java.util.Scanner;

public class HeightOfABinaryTree {

    public static int height(Node root) {
        // Write your code here.
        return dfs(root, 0);
    }

    static int dfs(Node node, int depth) {
        if (node == null) {
            return depth;
        }
        if (node.left == null && node.right == null) {
            return depth;
        }
        ++depth;
        return Math.max(dfs(node.left, depth), dfs(node.right, depth));
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
    // 7
    // 3 5 2 1 4 6 7

}