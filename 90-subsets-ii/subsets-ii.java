class Solution {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> curr=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0);
        return res;
    }
    public void backtrack(int[] nums,int start){
        res.add(new ArrayList<>(curr));
        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i-1]==nums[i])
             continue;
            curr.add(nums[i]);
            backtrack(nums,i+1);
            curr.remove(curr.size()-1);
        }
    }
}