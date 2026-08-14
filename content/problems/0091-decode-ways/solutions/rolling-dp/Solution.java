class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int beforePrevious = 1, previous = 1;
        for (int index = 1; index < s.length(); index++) {
            int current = s.charAt(index) == '0' ? 0 : previous;
            int pair = (s.charAt(index - 1) - '0') * 10 + s.charAt(index) - '0';
            if (pair >= 10 && pair <= 26) current += beforePrevious;
            beforePrevious = previous;
            previous = current;
        }
        return previous;
    }
}
