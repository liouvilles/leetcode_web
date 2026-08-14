class Solution { public int minSwaps(String s){int balance=0,minimum=0;for(char value:s.toCharArray()){balance+=value=='['?1:-1;minimum=Math.min(minimum,balance);}return (-minimum+1)/2;} }
