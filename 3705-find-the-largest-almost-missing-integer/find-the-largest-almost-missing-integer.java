/*
 * Largest Almost Missing Integer
 * Approach: Frequency Array + First/Last Element
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int largestInteger(int[] nums, int k) {
        int freq[]=new int[51];
        int n=nums.length;
        for(int num:nums){
            freq[num]++;
        }
        int max=-1;
        if(k==1){
            for(int i=0;i<=50;i++){
                if(freq[i]==1){
                    max=i;
                }
            }
            return max;
        }
        if(k==n){
            for(int i=0;i<=50;i++){
                if(freq[i]>0){
                    max=i;
                }
            }
            return max;
        }
        if(freq[nums[0]]==1){
            max=Math.max(max,nums[0]);
        }
        if(freq[nums[n-1]]==1){
            max=Math.max(max,nums[n-1]);
        }
        return max;
    }
}