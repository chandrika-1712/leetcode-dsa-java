class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int start=0,end=0;
        for(int i=0;i<n;i++){
            int odd=palindrome(s,i,i);
            int even=palindrome(s,i,i+1);
            int len=Math.max(odd,even);
            if(len>end-start){
               start=i-(len-1)/2;
               end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
     public int palindrome(String s,int i,int j){
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
}