class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(0,new ArrayList<>(),ans,nums);
        return ans;
    }
    void backtrack(int index,List<Integer> curr,List<List<Integer>> ans,int[] nums){
        if(index==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        backtrack(index+1,curr,ans,nums);
        curr.remove(curr.size()-1);
          backtrack(index+1,curr,ans,nums);
    }
}