/*
Approach: HashSet for unique lookup.
Time: O(n + m)
Space: O(n)
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Store unique elements from nums1
        HashSet<Integer> hs=new HashSet<>();
        for(int i:nums1){
            hs.add(i);
        }
        // Find common unique elements
        ArrayList<Integer> al=new ArrayList<>();
        for(int i:nums2){
            if(hs.contains(i)){
                al.add(i);
                hs.remove(i);
            }
        }

        // Convert list to array
        int ans[]=new int[al.size()];
        for(int i=0;i<al.size();i++){
            ans[i]=al.get(i);
        }
        return ans;
    }
}