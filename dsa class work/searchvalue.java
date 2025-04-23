import java.util.Scanner;

class Node {
    int data;
    Node left, right;
    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class searchvalue {
    // Insert a node in BST
    static Node insert(Node root, int value) {
        if (root == null) return new Node(value);
        if (value < root.data)
            root.left = insert(root.left, value);
        else if (value > root.data)
            root.right = insert(root.right, value);
        return root;
    }

    // Search a value in BST
    static boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            root = insert(root, val);
        }
        System.out.print("Enter value to search: ");
        int key = sc.nextInt();
        if (search(root, key))
            System.out.println("Value found in tree.");
        else
            System.out.println("Value not found in tree.");
        sc.close();
    }
}
