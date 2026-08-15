/*
 * Return the product of all elements except the current element
 * Approach: Prefix Product + Suffix Product using output array
 * Time Complexity: O(n)
 * Space Complexity: O(1) excluding the output array
 */
 class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n=arr.length;
        int ans[]=new int[n];
        ans[0]=1;
        for(int i=1;i<n;i++){
          ans[i]=arr[i-1]*ans[i-1];
        }
        int suff=1;
        for(int i=n-1;i>=0;i--){
           ans[i]=suff*ans[i];
           suff*=arr[i];
        }
        return ans;
    }
}