class Solution {
public:
    string addBinary(string a, string b) {
        string answer; int left = a.size() - 1, right = b.size() - 1, carry = 0;
        while (left >= 0 || right >= 0 || carry) { int sum = carry; if (left >= 0) sum += a[left--] - '0'; if (right >= 0) sum += b[right--] - '0'; answer += char('0' + (sum & 1)); carry = sum >> 1; }
        reverse(answer.begin(), answer.end()); return answer;
    }
};
