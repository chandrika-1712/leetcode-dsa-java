class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        if(n<2)
         return false;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,-1);
        int pref=0;
        for(int i=0;i<n;i++){
            pref+=nums[i];
            int rem = pref % k;
            if(hm.containsKey(rem)){
                if(i-hm.get(rem)>=2){
                    return true;
                }
            }
            else{
                    hm.put(rem,i);
                }
        }
        return false;
    }
}