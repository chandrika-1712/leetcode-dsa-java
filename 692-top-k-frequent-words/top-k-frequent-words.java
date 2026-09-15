class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(String word:words){
            hm.put(word,hm.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->{
            if(hm.get(a).equals(hm.get(b))){
                return b.compareTo(a);
            }
            return hm.get(a)-hm.get(b);
        });
        for(String word:hm.keySet()){
            pq.offer(word);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<String> ans=new ArrayList<>(pq);
        ans.sort((a,b)->{
            if(hm.get(a).equals(hm.get(b))){
                return a.compareTo(b);
            }
            return hm.get(b)-hm.get(a);
        });
        return ans;
    }
}