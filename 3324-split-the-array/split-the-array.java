class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int[] freq=new int[101];
        for(int num:nums){
           freq[num]++;
        }
        for(int i=0;i<101;i++){
            if(freq[i]>2)
             return false;
        }
        return true;
    }
}