/*
 * Find the maximum amount of water that can be contained between two vertical lines
 * Approach: Two Pointer
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
 class Solution {
    public int maxArea(int[] arr) {
        int n=arr.length;
        int l=0;
        int r=n-1;
        int res=0;
        while(l<r){
             int ans=Math.min(arr[l],arr[r])*(r-l);
            res=Math.max(ans,res);
            if(arr[l]<arr[r])
             l++;
            else 
             r--;
        }
        return res;
    }
}