class Solution {
    public int compareVersion(String version1, String version2) { String[] first = version1.split("[.]"); String[] second = version2.split("[.]"); int count = Math.max(first.length, second.length); for (int index = 0; index < count; index++) { long left = index < first.length ? Long.parseLong(first[index]) : 0; long right = index < second.length ? Long.parseLong(second[index]) : 0; if (left < right) return -1; if (left > right) return 1; } return 0; }
}
