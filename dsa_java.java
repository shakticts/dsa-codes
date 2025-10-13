import java.util.*;
import java.util.LinkedList;

/**
 * Comprehensive DSA Implementation in Java
 * Contains major data structures and algorithms
 */
public class DSAJava {

    // 1. LinkedList Node
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 2. Binary Tree Node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    // 3. Graph Node
    static class GraphNode {
        int val;
        List<GraphNode> neighbors;
        GraphNode(int x) { 
            val = x; 
            neighbors = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== DSA Implementation in Java ===");
        
        // Test LinkedList
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("LinkedList: " + linkedListToString(head));
        
        // Test Binary Tree
        TreeNode root = createBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println("Tree Inorder: " + inorderTraversal(root));
        
        // Test Sorting
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted: " + Arrays.toString(arr));
        
        // Test Graph BFS
        GraphNode graph = createGraph();
        System.out.println("Graph BFS: " + graphBFS(graph));
        
        // Test Binary Search
        int[] sorted = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;
        System.out.println("Binary Search for " + target + ": " + binarySearch(sorted, target));
    }

    // ========== LINKED LIST OPERATIONS ==========
    public static ListNode createLinkedList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    public static String linkedListToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" -> ");
            head = head.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // ========== BINARY TREE OPERATIONS ==========
    public static TreeNode createBinaryTree(int[] values) {
        if (values.length == 0) return null;
        return buildTree(values, 0);
    }

    private static TreeNode buildTree(int[] values, int index) {
        if (index >= values.length) return null;
        TreeNode node = new TreeNode(values[index]);
        node.left = buildTree(values, 2 * index + 1);
        node.right = buildTree(values, 2 * index + 2);
        return node;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private static void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);
    }

    // ========== SORTING ALGORITHMS ==========
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // ========== SEARCHING ALGORITHMS ==========
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // ========== GRAPH ALGORITHMS ==========
    public static GraphNode createGraph() {
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node4);
        node3.neighbors.add(node4);
        
        return node1;
    }

    public static List<Integer> graphBFS(GraphNode start) {
        List<Integer> result = new ArrayList<>();
        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();
        
        queue.offer(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();
            result.add(node.val);
            
            for (GraphNode neighbor : node.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return result;
    }

    // ========== DYNAMIC PROGRAMMING ==========
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // ========== STACK & QUEUE ==========
    static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }
        
        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }
        
        public void pop() {
            if (stack.pop().equals(minStack.peek())) {
                minStack.pop();
            }
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int getMin() {
            return minStack.peek();
        }
    }

    // ========== HASHMAP IMPLEMENTATION ==========
    static class MyHashMap<K, V> {
        private static final int SIZE = 16;
        private Entry<K, V>[] table;
        
        static class Entry<K, V> {
            K key;
            V value;
            Entry<K, V> next;
            
            Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
        
        @SuppressWarnings("unchecked")
        public MyHashMap() {
            table = new Entry[SIZE];
        }
        
        public void put(K key, V value) {
            int hash = key.hashCode() % SIZE;
            Entry<K, V> entry = table[hash];
            
            if (entry == null) {
                table[hash] = new Entry<>(key, value);
            } else {
                while (entry.next != null) {
                    if (entry.key.equals(key)) {
                        entry.value = value;
                        return;
                    }
                    entry = entry.next;
                }
                entry.next = new Entry<>(key, value);
            }
        }
        
        public V get(K key) {
            int hash = key.hashCode() % SIZE;
            Entry<K, V> entry = table[hash];
            
            while (entry != null) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
                entry = entry.next;
            }
            return null;
        }
    }
}