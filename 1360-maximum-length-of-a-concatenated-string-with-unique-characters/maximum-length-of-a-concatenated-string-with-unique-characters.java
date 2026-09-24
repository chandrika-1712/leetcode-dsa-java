class Solution {
    public int maxLength(List<String> arr) {
        HashSet<Character> set=new HashSet<>();
        return solve(arr,0,set);
    }
    public int solve(List<String> arr,int ind,HashSet<Character> set){
        if(ind==arr.size())
         return set.size();
        int skip=solve(arr,ind+1,set);
        HashSet<Character> temp=new HashSet<>();
        String s=arr.get(ind);
        boolean valid=true;
        for(char ch:s.toCharArray()){
            if(set.contains(ch)||temp.contains(ch)){
                valid=false;
                break;
            }
            temp.add(ch);
        }
         int take=0;
        if(valid){
            for(char ch:s.toCharArray()){
                set.add(ch);
            }
            take=solve(arr,ind+1,set);
            for(char ch:s.toCharArray()){
                set.remove(ch);
            }
        }
        return Math.max(skip,take);
    }
}