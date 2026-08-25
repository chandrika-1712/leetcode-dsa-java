class Solution {
    public int removeDuplicates(int[] nums) {
        int l=0;
        int n=nums.length;
        for(int r=0;r<n;r++){
           if(l<2||nums[r]!=nums[l-2]){
             nums[l]=nums[r];
             l++;
           }
        }
        return l;
    }
}