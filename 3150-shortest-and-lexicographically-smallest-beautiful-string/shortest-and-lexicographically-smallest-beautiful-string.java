class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l=0;
        int n=s.length();
        int count=0;
        String ans="";
        for(int r=0;r<n;r++){
           if(s.charAt(r)=='1'){
            count++;
           }
            while(count>k){
              if(s.charAt(l)=='1'){
                count--;
              }
               l++;
            }
            while(count==k&&s.charAt(l)=='0')
             l++;
           if(count==k){
             String cur=s.substring(l,r+1);
             if(ans.isEmpty()||cur.length()<ans.length()){
                ans=cur;
             }
             else if(cur.length()==ans.length()&&cur.compareTo(ans)<0){
                ans=cur;
             }
           }
        }
        return ans;
    }
}