// Problem: Climbing Stairs
// Description: You are climbing a staircase. It takes n steps to reach the top.
// Each time you can climb either 1 or 2 steps. In how many distinct ways can you climb to the top?

public class ClimbingStairs {

    // Iterative DP approach (Bottom-up)
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int first = 1, second = 2, total = 0;
        for (int i = 3; i <= n; i++) {
            total = first + second;
            first = second;
            second = total;
        }
        return total;
    }

    // Recursive approach with memoization (Top-down)
    public static int climbStairsMemo(int n, int[] dp) {
        if (n <= 2) return n;
        if (dp[n] != 0) return dp[n];
        dp[n] = climbStairsMemo(n - 1, dp) + climbStairsMemo(n - 2, dp);
        return dp[n];
    }

    // Example usage
    public static void main(String[] args) {
        int n = 5; // Number of steps
        System.out.println("Ways to climb " + n + " steps (DP Iterative): " + climbStairs(n));

        int[] dp = new int[n + 1];
        System.out.println("Ways to climb " + n + " steps (DP Memoization): " + climbStairsMemo(n, dp));
    }
}
