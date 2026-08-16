/*
 * Determine whether Alice wins Stone Game IX
 * Approach: Modulo 3 + Game Theory
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];

        // Count stones based on their remainder when divided by 3
        for (int stone : stones) {
            count[stone % 3]++;
        }
        int count0 = count[0];
        int count1 = count[1];
        int count2 = count[2];

        // Even number of remainder-0 stones
        if (count0 % 2 == 0) {
            return count1 > 0 && count2 > 0;
        }

        // Odd number of remainder-0 stones
        return Math.abs(count1 - count2) > 2;
    }
}