class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hs=new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }
        int m=k;
        while(hs.contains(m)){
            m+=k;
        }
        return m;
    }
}