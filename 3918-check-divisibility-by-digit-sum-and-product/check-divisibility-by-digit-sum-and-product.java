/*
 * Approach:
 * Extract each digit, calculate digit sum and product,
 * then check n % (sum + product) == 0.
 *
 * Time: O(log n)
 * Space: O(1)
 */
 class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int num=n;
        int psum=1;
        while(num!=0){
            sum+=(num%10);
            psum*=(num%10);
            num=num/10;
        }
        if(n%(psum+sum)==0)
         return true;
        return false;
    }
}