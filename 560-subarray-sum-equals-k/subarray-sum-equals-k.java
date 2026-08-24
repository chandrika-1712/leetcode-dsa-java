/*
LC 560 - Subarray Sum Equals K

Approach:
Prefix Sum + HashMap.
previousPrefix = currentPrefix - k.
Check (psum - k) in HashMap and add its frequency.
Store prefix sums with frequency.
Initialize 0 → 1 for subarrays starting at index 0.

Time: O(n)
Space: O(n)
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int psum=0;
        int count=0;
        for(int i:nums){
          psum+=i;
          if(hm.containsKey(psum-k)){
            count+=hm.get(psum-k);
          }
          hm.put(psum,hm.getOrDefault(psum,0)+1);
        }
        return count;
    }
}