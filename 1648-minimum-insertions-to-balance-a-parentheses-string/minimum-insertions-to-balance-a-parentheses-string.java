class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int need = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // If need is odd, insert ')' before this '('
                if (need % 2 == 1) {
                    insertions++;
                    need--;
                }

                // Every '(' requires two ')'
                need += 2;
            } else {
                need--;

                // No opening '(' available for this ')'
                if (need < 0) {
                    insertions++;
                    need = 1;
                }
            }
        }

        // Insert any remaining required closing parentheses
        return insertions + need;
    }
}