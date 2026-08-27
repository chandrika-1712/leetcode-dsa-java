class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i:nums)
         hs.add(i);
        int ans=0;
        for(int i:hs){
            if(!hs.contains(i-1)){
                int count=1;
                int cur=i;
                while(hs.contains(cur+1)){
                    cur++;
                    count++;
                }
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
}