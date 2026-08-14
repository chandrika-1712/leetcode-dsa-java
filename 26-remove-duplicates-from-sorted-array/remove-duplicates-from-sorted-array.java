/*
 * Remove duplicates from a sorted array in-place
 * Approach: Two Pointer
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
 class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}