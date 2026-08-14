class Solution {
    public int maximumLengthSubstring(String s) {
        int j=0;
        int max=0;
        int n=s.length();
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
            while(hm.get(s.charAt(i))>2){
                 hm.put(s.charAt(j),hm.get(s.charAt(j))-1);
                 if(hm.get(s.charAt(j))==0){
                    hm.remove(s.charAt(j));
                 }
                 j++;       
            }
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}