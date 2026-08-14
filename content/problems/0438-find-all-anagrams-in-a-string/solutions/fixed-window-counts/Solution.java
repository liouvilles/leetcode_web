class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>(); if (p.length() > s.length()) return answer;
        int[] target = new int[26], window = new int[26]; for (char value : p.toCharArray()) target[value - 'a']++;
        for (int right = 0; right < s.length(); right++) { window[s.charAt(right) - 'a']++; if (right >= p.length()) window[s.charAt(right - p.length()) - 'a']--; if (right >= p.length() - 1 && Arrays.equals(target, window)) answer.add(right - p.length() + 1); }
        return answer;
    }
}
