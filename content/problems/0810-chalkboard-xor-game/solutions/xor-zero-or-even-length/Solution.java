class Solution { public boolean xorGame(int[] nums){int xor=0;for(int value:nums)xor^=value;return xor==0||nums.length%2==0;} }
