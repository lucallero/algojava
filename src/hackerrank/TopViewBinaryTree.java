package hackerrank;

import java.util.*;

public class TopViewBinaryTree {

    /*
     * 
     * class Node int data; Node left; Node right;
     */
    public static void topView(Node root) {

        List<String> result = new ArrayList<>();

        leftTraversal(root, result);
        rigthTraversal(root.right, result);

        String solution = String.join(" ", result);

        System.out.println(":" + solution);



    }

    static void leftTraversal(Node node, List<String> result) {
        if (node == null) {
            return;
        }
        leftTraversal(node.left, result);
        result.add(Integer.toString(node.data));
    }

    static void rigthTraversal(Node node, List<String> result) {
        if (node == null) {
            return;
        }
        result.add(Integer.toString(node.data));
        rigthTraversal(node.right, result);
    }



    public static void travelRight(Node root){
        if(root != null){
            System.out.print(root.data+" ");
            travelRight(root.right); 
        }
    }
    public static void travelLeft(Node root){
        if(root != null){
            travelLeft(root.left);
            System.out.print(root.data+" ");
        }
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
        topView(root);
        // System.out.println(reverse("tabu"));
    }

    static String reverse(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
}
