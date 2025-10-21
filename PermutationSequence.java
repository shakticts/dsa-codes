class Solution {
    public String getPermutation(int n, int k) {
        // Precompute factorials 0! .. n!
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = fact[i - 1] * i;

        // convert k to 0-based index
        int k0 = k - 1;

        // list of available digits 1..n
        java.util.List<Integer> nums = new java.util.ArrayList<>();
        for (int i = 1; i <= n; i++) nums.add(i);

        StringBuilder sb = new StringBuilder();
        // choose digits one by one
        for (int pos = n; pos >= 1; pos--) {
            int blockSize = fact[pos - 1];
            int idx = k0 / blockSize;      // which element to pick from nums
            sb.append(nums.remove(idx));   // remove it (shifts remaining elements)
            k0 = k0 % blockSize;           // remainder for next positions
        }

        return sb.toString();
    }
}
