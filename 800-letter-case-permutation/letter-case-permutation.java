class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        solve(s,ans,0,sb);
        return ans;
    }
    public void solve(String s,List<String> ans,int ind,StringBuilder sb){
        if(ind==s.length()){
            ans.add(sb.toString());
            return;
        }
        char ch=s.charAt(ind);
        if(Character.isDigit(ch)){
            sb.append(ch);
            solve(s,ans,ind+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            sb.append(Character.toLowerCase(ch));
            solve(s,ans,ind+1,sb);
            sb.deleteCharAt(sb.length()-1);
            sb.append(Character.toUpperCase(ch));
            solve(s,ans,ind+1,sb);
             sb.deleteCharAt(sb.length()-1);
        }
    }
}