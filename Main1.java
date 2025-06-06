import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of nodes
        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();
        TreeNode root = null;

        System.out.println("Enter values to insert into BST:");
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            root = insertBST(root, val);
        }

        Solution sol = new Solution();
        TreeNode balancedRoot = sol.balanceBST(root);

        System.out.println("In-order traversal of balanced BST:");
        inorderTraversal(balancedRoot);
        scanner.close();
    }

    // Insert a value into the BST
    public static TreeNode insertBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insertBST(root.left, val);
        else root.right = insertBST(root.right, val);
        return root;
    }

    // In-order traversal to print tree
    public static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
}

// TreeNode class representing each node in the tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Solution class that contains the logic to balance the BST
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        return buildBalancedBST(inorderList, 0, inorderList.size() - 1);
    }

    // Helper function to perform in-order traversal and collect node values
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    // Helper function to build a balanced BST from sorted node values
    private TreeNode buildBalancedBST(List<Integer> list, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = buildBalancedBST(list, start, mid - 1);
        node.right = buildBalancedBST(list, mid + 1, end);
        return node;
    }
}
