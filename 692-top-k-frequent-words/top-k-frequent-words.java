import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        // Step 1: Count frequencies
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Step 2: Min Heap
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> {

                int freqA = map.get(a);
                int freqB = map.get(b);

                // Different frequencies:
                // smaller frequency is worse
                if (freqA != freqB) {
                    return freqA - freqB;
                }

                // Same frequency:
                // lexicographically larger is worse
                return b.compareTo(a);
            }
        );

        // Step 3: Keep only K words
        for (String word : map.keySet()) {

            pq.offer(word);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Build answer
        List<String> answer = new ArrayList<>();

        while (!pq.isEmpty()) {
            answer.add(pq.poll());
        }

        // Heap gives worst → best,
        // so reverse it
        Collections.reverse(answer);

        return answer;
    }
}// class Solution {
//     public List<String> topKFrequent(String[] words, int k) {
//         HashMap<String,Integer> hm=new HashMap<>();
//         for(String word:words){
//             hm.put(word,hm.getOrDefault(word,0)+1);
//         }
//         PriorityQueue<String> pq=new PriorityQueue<>((a,b)->{
//             if(hm.get(a).equals(hm.get(b))){
//                 return b.compareTo(a);
//             }
//             return hm.get(a)-hm.get(b);
//         });
//         for(String word:hm.keySet()){
//             pq.offer(word);
//             if(pq.size()>k){
//                 pq.poll();
//             }
//         }
//         List<String> ans=new ArrayList<>(pq);
//         ans.sort((a,b)->{
//             if(hm.get(a).equals(hm.get(b))){
//                 return a.compareTo(b);
//             }
//             return hm.get(b)-hm.get(a);
//         });
//         return ans;
//     }
// }