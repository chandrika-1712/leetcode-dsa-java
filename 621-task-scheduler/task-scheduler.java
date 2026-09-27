class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
        }
        int maxfreq=0;
        for(int i:freq){
            maxfreq=Math.max(maxfreq,i);
        }
        int count=0;
        for(int i:freq){
            if(i==maxfreq){
                count++;
            }
        }
        int req=(maxfreq-1)*(n+1)+count;
        return Math.max(req,tasks.length);
    }
}