class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1=new int[26];
        int[] freq2=new int[26];
          int l=s1.length();
        if(l>s2.length())
         return false;
        for(char ch:s1.toCharArray()){
            freq1[ch-'a']++;
        }
        for(int i=0;i<l;i++){
            freq2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(freq1,freq2))
         return true;
        for(int i=l;i<s2.length();i++){
            freq2[s2.charAt(i-l)-'a']--;
            freq2[s2.charAt(i)-'a']++;
            if(Arrays.equals(freq1,freq2))
             return true;
        }
        return false;
    }
}