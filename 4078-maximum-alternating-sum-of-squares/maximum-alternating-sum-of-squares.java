class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long[] ans=new long[n];
        for(int i=0;i<n;i++){
            ans[i]=(long)nums[i]*nums[i];
        }
        Arrays.sort(ans);
        long score=0;
        for(int i=0;i<n;i++){
           if(i<n/2){
            score-=ans[i];
           }else{
            score+=ans[i];
           }
        }
        return score;
    }
}