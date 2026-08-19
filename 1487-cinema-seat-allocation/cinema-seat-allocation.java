/*
 * Cinema Seat Allocation
 * Approach: HashMap + Greedy
 * Time Complexity: O(m)
 * Space Complexity: O(m)
 */
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // Store reserved seats for each affected row
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            map.computeIfAbsent(seat[0], k -> new HashSet<>())
               .add(seat[1]);
        }

        // Every completely empty row can accommodate 2 groups
        long answer = (long) (n - map.size()) * 2;

        // Process only rows having reserved seats
        for (Set<Integer> reserved : map.values()) {

            boolean left = true;   // 2,3,4,5
            boolean middle = true; // 4,5,6,7
            boolean right = true;  // 6,7,8,9

            for (int seat : reserved) {
                if (seat >= 2 && seat <= 5) {
                    left = false;
                }

                if (seat >= 4 && seat <= 7) {
                    middle = false;
                }

                if (seat >= 6 && seat <= 9) {
                    right = false;
                }
            }

            // Left and right blocks don't overlap
            if (left && right) {
                answer += 2;
            } 
            else if (left || middle || right) {
                answer += 1;
            }
        }

        return (int) answer;
    }
}