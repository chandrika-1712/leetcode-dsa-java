/*
 * Problem:
 * Find the kth smallest positive amount that can be made using
 * multiples of at least one coin denomination.
 * Coins cannot be combined, and duplicate amounts are counted once.
 *
 * Approach:
 * 1. Binary search the answer.
 * 2. For a value mid, count how many distinct amounts <= mid
 *    are divisible by at least one coin.
 * 3. Use Inclusion-Exclusion over all subsets of coins.
 * 4. For each subset, calculate its LCM. The number of common
 *    multiples <= mid is mid / LCM.
 * 5. Add odd-sized subsets and subtract even-sized subsets.
 *
 * Time Complexity:
 * O(2^n * n * log(minCoin * k))
 *
 * Space Complexity:
 * O(1)
 */
 class Solution {

    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long high = (long) getMin(coins) * k;

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins) {

        int n = coins.length;
        long total = 0;

        // Inclusion-Exclusion
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    long g = gcd(lcm, coins[i]);

                    // Prevent overflow and ignore LCM > x
                    lcm = (lcm / g) * coins[i];

                    if (lcm > x) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) {
                continue;
            }

            long multiples = x / lcm;

            if (bits % 2 == 1) {
                total += multiples;
            } else {
                total -= multiples;
            }
        }

        return total;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private int getMin(int[] coins) {

        int min = coins[0];

        for (int coin : coins) {
            min = Math.min(min, coin);
        }

        return min;
    }
}