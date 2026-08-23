/*
Question:
Replace '?' with digits so Alice wants unequal half sums and Bob wants equal sums.

Approach:
Count left/right sums and '?'s.
Compare the sum difference with '?' imbalance.
If Bob can balance exactly → false, else → true.

Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution {
    public boolean sumGame(String num) {
        int n=num.length();
        int mid=n/2;
        int lsum=0,rsum=0,lq=0,rq=0;
        for(int i=0;i<mid;i++){
             if(num.charAt(i)=='?'){
                lq++;
             }
             else{
                lsum+=(num.charAt(i)-'0');
             }
        }
        for(int i=mid;i<n;i++){
             if(num.charAt(i)=='?'){
                rq++;
             }
             else{
                rsum+=(num.charAt(i)-'0');
             }
        }
        int diff=lsum-rsum;
        int qdiff=lq-rq;
        if(qdiff%2!=0)
         return true;
        return diff!=-9*qdiff/2;
    }  
}