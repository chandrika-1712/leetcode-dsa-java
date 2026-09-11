class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            int num=entry.getKey();
            int freq=entry.getValue();
            if(buckets[freq]==null){
                buckets[freq]=new ArrayList<>();
            }
            buckets[freq].add(num);
        }
        int ans[]=new int[k];
        int ind=0;
        for(int i=n;i>=0;i--){
            if(buckets[i]!=null){
                for(int num:buckets[i]){
                    ans[ind++]=num;
                    if(ind==k)
                     return ans;
                }
            }
        }
        return ans;
    }
}