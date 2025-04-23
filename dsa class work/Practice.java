import java.util.Scanner;

// Class representing a Node in the tree
class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class Practice {

    // 1. Find the height of a tree
    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 2. Count nodes of a tree
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // 3. Search a value in the tree
    public boolean searchValue(TreeNode root, int value) {
        if (root == null) {
            return false;
        }
        if (root.data == value) {
            return true;
        }
        return searchValue(root.left, value) || searchValue(root.right, value);
    }

    // 4. Count/find leaf nodes in a tree
    public int countLeafNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    // 5. Sum of all nodes
    public int sumOfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
    }

    // 6. Print nodes at a given level
    public void printNodesAtLevel(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " ");
        } else {
            printNodesAtLevel(root.left, level - 1);
            printNodesAtLevel(root.right, level - 1);
        }
    }

    // 7. Insert a node in the tree
    public TreeNode insertNode(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.data) {
            root.left = insertNode(root.left, value);
        } else {
            root.right = insertNode(root.right, value);
        }
        return root;
    }

    public static void main(String[] args) {
        Practice tree = new Practice();
        TreeNode root = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of nodes to insert:");
        int n = scanner.nextInt();
        System.out.println("Enter the values of the nodes:");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            root = tree.insertNode(root, value);
        }

        System.out.println("Height of tree: " + tree.findHeight(root));
        System.out.println("Number of nodes: " + tree.countNodes(root));

        System.out.println("Enter a value to search in the tree:");
        int searchValue = scanner.nextInt();
        System.out.println("Search " + searchValue + " in tree: " + tree.searchValue(root, searchValue));

        System.out.println("Number of leaf nodes: " + tree.countLeafNodes(root));
        System.out.println("Sum of all nodes: " + tree.sumOfNodes(root));

        System.out.println("Enter the level to print nodes:");
        int level = scanner.nextInt();
        System.out.print("Nodes at level " + level + ": ");
        tree.printNodesAtLevel(root, level);

        scanner.close();
    }
}
