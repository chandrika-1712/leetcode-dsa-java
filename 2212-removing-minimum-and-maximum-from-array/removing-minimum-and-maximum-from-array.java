class Solution {
    public int minimumDeletions(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int mini=0;
        int maxi=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>max){
              max=nums[i];
              maxi=i;
            }if(nums[i]<min){
              min=nums[i];
              mini=i;
            }
        }
         int maxind=0;
         int minind=0;
        if(maxi>mini){
            maxind=maxi;
            minind=mini;
        }
        else{
            maxind=mini;
            minind=maxi;
        }
        return Math.min(maxind+1,Math.min(n-minind,minind+1+(n-maxind)));
    }
}   