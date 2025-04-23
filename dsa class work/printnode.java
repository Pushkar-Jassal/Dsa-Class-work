import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

public class printnode {
    // Function to print nodes at a given level
    static void printLevel(Node root, int level) {
        if (root == null) return;
        if (level == 1) {
            System.out.print(root.data + " ");
        } else {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }

    // Function to build tree from user input (level order)
    static Node buildTree(Scanner sc) {
        System.out.print("Enter root value (-1 for null): ");
        int val = sc.nextInt();
        if (val == -1) return null;
        Node root = new Node(val);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print("Enter left child of " + curr.data + " (-1 for null): ");
            int leftVal = sc.nextInt();
            if (leftVal != -1) {
                curr.left = new Node(leftVal);
                queue.add(curr.left);
            }
            System.out.print("Enter right child of " + curr.data + " (-1 for null): ");
            int rightVal = sc.nextInt();
            if (rightVal != -1) {
                curr.right = new Node(rightVal);
                queue.add(curr.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = buildTree(sc);
        System.out.print("Enter level to print: ");
        int level = sc.nextInt();
        System.out.print("Nodes at level " + level + ": ");
        printLevel(root, level);
        sc.close();
    }
}
