/*
 * Find the maximum score Alice can obtain in Stone Game V
 * Approach: Interval DP + Prefix Sum
 * Time Complexity: O(n^3)
 * Space Complexity: O(n^2)
 */
 class Solution {
    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        // prefix[i] = sum of elements from 0 to i-1
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        // dp[l][r] = maximum score Alice can get
        // from subarray l to r
        int[][] dp = new int[n][n];

        // Consider intervals of length 2, 3, ..., n
        for (int len = 2; len <= n; len++) {

            // Starting index
            for (int l = 0; l + len <= n; l++) {

                // Ending index
                int r = l + len - 1;

                // Try every possible split
                for (int k = l; k < r; k++) {

                    // Sum of left part
                    int leftSum =
                        prefix[k + 1] - prefix[l];

                    // Sum of right part
                    int rightSum =
                        prefix[r + 1] - prefix[k + 1];

                    // Left is smaller
                    if (leftSum < rightSum) {

                        // Right is discarded
                        // Alice keeps left
                        dp[l][r] = Math.max(
                            dp[l][r],
                            leftSum + dp[l][k]
                        );

                    }

                    // Right is smaller
                    else if (leftSum > rightSum) {

                        // Left is discarded
                        // Alice keeps right
                        dp[l][r] = Math.max(
                            dp[l][r],
                            rightSum + dp[k + 1][r]
                        );

                    }

                    // Both are equal
                    else {

                        // Alice can choose either side
                        dp[l][r] = Math.max(
                            dp[l][r],
                            leftSum + Math.max(
                                dp[l][k],
                                dp[k + 1][r]
                            )
                        );
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}