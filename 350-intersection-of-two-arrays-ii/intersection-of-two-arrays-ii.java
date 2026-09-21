class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       HashMap<Integer,Integer> hm=new HashMap<>();
       for(int num:nums1){
         hm.put(num,hm.getOrDefault(num,0)+1);
       }
       ArrayList<Integer> al=new ArrayList<>();
       for(int num:nums2){
        if(hm.containsKey(num)){
            al.add(num);
            hm.put(num,hm.get(num)-1);
            if(hm.get(num)==0)
             hm.remove(num);
        }
       }
       int j=0;
       int[] ans=new int[al.size()];
       for(int i:al){
        ans[j++]=i;
       }
       return ans;
    }
}