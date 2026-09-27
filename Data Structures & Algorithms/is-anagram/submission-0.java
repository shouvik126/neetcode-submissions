class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int oldVal = map.get(s.charAt(i));
                map.put(s.charAt(i), oldVal + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                int oldVal = map.get(t.charAt(i));
                if (oldVal <= 0) {
                    return false;
                }
                map.put(t.charAt(i), oldVal - 1);
            } else {
                return false;
            }
        }
        for (int val : map.values()) {
            if (val > 0) {
                return false;
            }
        }
        return true;
    }
}
