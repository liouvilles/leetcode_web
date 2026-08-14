class Solution {
    public boolean isValid(String s) {
        int previousLength;
        do {
            previousLength = s.length();
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        } while (s.length() != previousLength);
        return s.isEmpty();
    }
}
