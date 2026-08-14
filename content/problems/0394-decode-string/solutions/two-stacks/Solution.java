class Solution {
    public String decodeString(String s) {
        Deque<Integer> counts = new ArrayDeque<>(); Deque<StringBuilder> prefixes = new ArrayDeque<>(); StringBuilder current = new StringBuilder(); int repeat = 0;
        for (char symbol : s.toCharArray()) { if (Character.isDigit(symbol)) repeat = repeat * 10 + symbol - '0'; else if (symbol == '[') { counts.push(repeat); prefixes.push(current); current = new StringBuilder(); repeat = 0; } else if (symbol == ']') { int times = counts.pop(); StringBuilder expanded = prefixes.pop(); while (times-- > 0) expanded.append(current); current = expanded; } else current.append(symbol); }
        return current.toString();
    }
}
