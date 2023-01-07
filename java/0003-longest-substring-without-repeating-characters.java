class Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexes = new HashMap<>();
        int j = 0;
        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // check if duplicate and if its index is in the current window of length [j, i]
            if (charIndexes.containsKey(c) && charIndexes.get(c) >= j) {
                j = charIndexes.get(c);
            }

            length = Math.max(length, i - j + 1);
            charIndexes.put(c, i + 1);
        }

        return length;
    }
}
