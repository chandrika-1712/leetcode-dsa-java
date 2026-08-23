class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int idx=0;
        if(ruleKey.equals("type"))
        {
            idx=0;
        }if(ruleKey.equals("color")){
            idx=1;
        }
        if(ruleKey.equals("name")){
            idx=2;
        }
        int ans=0;
        for(List<String> al:items){
            if(al.get(idx).equals(ruleValue)){
                ans++;
            }
        }
        return ans;
    }
}