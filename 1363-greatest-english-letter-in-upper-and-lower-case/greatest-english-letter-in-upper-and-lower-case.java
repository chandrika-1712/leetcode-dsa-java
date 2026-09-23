class Solution {
    public String greatestLetter(String s) {
        boolean[] lower=new boolean[26];
        boolean[] upper=new boolean[26];
        for(char ch:s.toCharArray()){
         if(Character.isLowerCase(ch))
            lower[ch-'a']=true;
         if(Character.isUpperCase(ch))
           upper[ch-'A']=true;
        }
        for(int i=25;i>=0;i--){
            if(lower[i]&&upper[i]){
                return String.valueOf((char)(i+'A'));
            }
        }
        return "";
    }
}