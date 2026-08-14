class Solution { public boolean queryString(String s,int n){for(int value=n;value>n/2;value--)if(!s.contains(Integer.toBinaryString(value)))return false;return true;} }
