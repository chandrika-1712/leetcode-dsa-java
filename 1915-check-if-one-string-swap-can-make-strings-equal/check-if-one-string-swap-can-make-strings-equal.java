class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n=s1.length();
        int count=0,first=0,second=0;
        for(int i=0;i<n;i++){
           if(s1.charAt(i)!=s2.charAt(i)){
            count++;
            if(count==1)
             first=i;
            else if(count==2)
             second=i;
           }
        }
        if(count==0)
         return true;
        if(count>2) 
         return false;
        return s1.charAt(first)==s2.charAt(second)&&s1.charAt(second)==s2.charAt(first);
    }
}