/*
Approach:
Simulate using two ArrayLists.
Compare last elements and append accordingly.
Finally concatenate arr1 + arr2.

Time: O(n)
Space: O(n)
*/
class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> al1=new ArrayList<>();
        ArrayList<Integer> al2=new ArrayList<>();
        al1.add(nums[0]);
        al2.add(nums[1]);
        for(int i=2;i<n;i++){
            if(al1.get(al1.size()-1)>al2.get(al2.size()-1)){
                al1.add(nums[i]);
            }
            else{
                al2.add(nums[i]);
            }
        }
        int[] ans=new int[n];
        int k=0;
        for(int i:al1){
            ans[k]=i;
            k++;
        }
        for(int i:al2){
            ans[k]=i;
            k++;
        }
        return ans;

    }
}