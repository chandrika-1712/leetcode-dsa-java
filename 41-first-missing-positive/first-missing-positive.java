/*
 * Find the smallest missing positive integer
 * Approach: In-place Index Placement
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
 class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]>=1&&nums[i]<=n&&nums[i]!=nums[nums[i]-1]){
                int j=nums[i]-1;
                swap(nums,i,j);
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1)
             return i+1;
        }
        return n+1;
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}