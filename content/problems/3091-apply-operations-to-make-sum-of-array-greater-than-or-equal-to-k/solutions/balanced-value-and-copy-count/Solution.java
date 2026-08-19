class Solution { public int minOperations(int k){int value=(int)Math.sqrt(k);int copies=(k+value-1)/value;return value+copies-2;} }
