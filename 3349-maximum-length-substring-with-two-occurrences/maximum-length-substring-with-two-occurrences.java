/*
 * Find the maximum length substring where each character appears at most twice
 * Approach: Sliding Window with Frequency Array
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
 class Solution {
    public int maximumLengthSubstring(String s) {
        int freq[]=new int[26];
        int l=0,max=0;
        for(int r=0;r<s.length();r++){
           int idx=s.charAt(r)-'a';
           freq[idx]++;
           while(freq[idx]>2){
            freq[s.charAt(l)-'a']--;
            l++;
           }
           max=Math.max(r-l+1,max);
        }
        return max;
    }
}