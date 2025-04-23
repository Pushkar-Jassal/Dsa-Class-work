import java.util.Scanner;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class leafnode {
    // Build tree using user input (recursive)
    public static Node buildTree(Scanner sc) {
        System.out.print("Enter node value (-1 for null): ");
        int val = sc.nextInt();
        if (val == -1) return null;
        Node node = new Node(val);
        System.out.println("Enter left child of " + val);
        node.left = buildTree(sc);
        System.out.println("Enter right child of " + val);
        node.right = buildTree(sc);
        return node;
    }

    // Count leaf nodes
    public static int countLeafNodes(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = buildTree(sc);
        int leafCount = countLeafNodes(root);
        System.out.println("Number of leaf nodes: " + leafCount);
    }
}
