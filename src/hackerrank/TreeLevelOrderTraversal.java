package hackerrank;

import java.util.LinkedList;

public class TreeLevelOrderTraversal {

    public static void levelOrder(Node root) {
        String result = "";
        LinkedList<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);

            result += current.data + " ";

        }
        System.out.println(result);
    }
}