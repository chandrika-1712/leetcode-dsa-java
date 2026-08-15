/*
 * Find the longest subsequence whose XOR is non-zero
 * Approach: Total XOR + Remove One Element
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
 class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int xor=0;
        for(int num:nums){
            xor^=num;
        }
        if(xor!=0)
         return n;
        for(int num:nums){
            if(num!=0)
             return n-1;
        }
        return 0;
    }
}