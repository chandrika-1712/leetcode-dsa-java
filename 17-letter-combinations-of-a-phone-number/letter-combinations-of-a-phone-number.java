class Solution {
     String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    String digits;
    public List<String> letterCombinations(String digits) {
        this.digits=digits;
        List<String> ans=new ArrayList<>();
        backtrack(0,new StringBuilder(),ans);
        return ans;
    }
    void backtrack(int ind,StringBuilder sb,List<String> ans){
        if(sb.length()==digits.length()){
            ans.add(sb.toString());
            return;
        }
        String letters=map[digits.charAt(ind)-'0'];
        for(int j=0;j<letters.length();j++){
            sb.append(letters.charAt(j));
            backtrack(ind+1,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}