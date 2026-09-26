class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int i:hm.values()){
            if(isPrime(i)){
              return true;
            }
        }
        return false;
    }
    public boolean isPrime(int n){
        if(n<=1)
         return false;
        if(n==2||n==3)
         return true;
        if(n%2==0||n%3==0){
            return false;
        }
        for(int i=5;i*i<=n;i+=6){
            if(n%i==0||n%(i+2)==0){
               return false;
            }
        }
        return true;
    }
}