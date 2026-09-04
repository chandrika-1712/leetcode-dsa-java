class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] pref = new int[n];
        int[] suff = new int[n];
        int max=nums[0];
        for(int i=0;i<n;i++){
           max=Math.max(nums[i],max);
           pref[i]=max;
        }
        int min = nums[n-1];
        for(int i=n-1;i>=0;i--){
            min=Math.min(nums[i],min);
            suff[i]=min;
        }
        for(int i=0;i<n;i++){
            if(pref[i]-suff[i]<=k)
             return i;
        }
        return -1;
    }
}