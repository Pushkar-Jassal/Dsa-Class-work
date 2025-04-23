import java.util.Scanner;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class sumnodes {
    // Function to insert nodes in level order
    public static Node insertLevelOrder(int[] arr, int i) {
        Node root = null;
        if (i < arr.length) {
            root = new Node(arr[i]);
            root.left = insertLevelOrder(arr, 2 * i + 1);
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;
    }

    // Function to sum all nodes
    public static int sumNodes(Node root) {
        if (root == null) return 0;
        return root.data + sumNodes(root.left) + sumNodes(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Node root = insertLevelOrder(arr, 0);
        int sum = sumNodes(root);
        System.out.println("Sum of all nodes: " + sum);
    }
}
