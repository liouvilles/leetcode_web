class Solution {
    public String addBinary(String a, String b) {
        StringBuilder answer = new StringBuilder(); int left = a.length() - 1, right = b.length() - 1, carry = 0;
        while (left >= 0 || right >= 0 || carry != 0) { int sum = carry; if (left >= 0) sum += a.charAt(left--) - '0'; if (right >= 0) sum += b.charAt(right--) - '0'; answer.append(sum & 1); carry = sum >> 1; }
        return answer.reverse().toString();
    }
}
