import java.util.*;

public class Node{

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return getBst(nums, 0, nums.length - 1);
    }

    public static TreeNode getBst(int[] arr, int startIdx, int endIdx) {
        if (startIdx > endIdx) return null;

        int mid = startIdx + (endIdx - startIdx) / 2;
        TreeNode bst = new TreeNode(arr[mid]);
        bst.left = getBst(arr, startIdx, mid - 1);
        bst.right = getBst(arr, mid + 1, endIdx);

        return bst;
    }

    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // New method to print level-order with nulls:
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                result.add("null");
            }
        }

        // Remove trailing "null"s for cleaner output
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            result.remove(i);
            i--;
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the sorted array:");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        TreeNode root = sortedArrayToBST(nums);

        System.out.println("Inorder traversal of constructed BST:");
        printInorder(root);
        System.out.println(); // Newline after inorder output

        System.out.println("Level-order (BFS) serialization of constructed BST:");
        printLevelOrder(root);

        sc.close();
    }
}
