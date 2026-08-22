/*
 * Approach 1: Sorting
 * 1. For each string, convert it into a character array and sort it.
 * 2. Use the sorted string as the key in a HashMap.
 * 3. All anagrams produce the same sorted key, so add them to the
 *    same list.
 * 4. Return all the grouped lists from the HashMap.
 *
 * Time Complexity:
 * O(n * k log k)
 * where n = number of strings and k = maximum length of a string.
 *
 * Space Complexity:
 * O(n * k)
 *
 *
 * Approach 2: Frequency Array
 * 1. Create a frequency array of size 26 for each string.
 * 2. Count the frequency of every character.
 * 3. Convert the frequency array into a unique String key.
 * 4. Use this key in a HashMap to group all anagrams.
 * 5. Return all the grouped lists.
 *
 * Time Complexity:
 * O(n * k)
 * where n = number of strings and k = maximum length of a string.
 *
 * Space Complexity:
 * O(n * k)
 */
 class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm=new HashMap<>();
        for(String s:strs){
            // int[] freq=new int[26];
            // for(char ch:s.toCharArray()){
            //     freq[ch-'a']++;
            // }
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            // if(!hm.containsKey(key)){
            //     hm.put(key,new ArrayList<>());
            // }
            // hm.get(key).add(s);
            hm.computeIfAbsent(sorted,k->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(hm.values());
    }
}