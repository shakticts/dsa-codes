package important_questions;

public class BinarySearch {
    public static int binarySearch(int[] arr, int key) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        System.out.println("Index of 7: " + binarySearch(arr, 7));
        System.out.println("Index of 2: " + binarySearch(arr, 2));
    }
}
