class Solution { public int[] evenOddBit(int n){int[] answer=new int[2];for(int position=0;n>0;position++,n>>=1)if((n&1)==1)answer[position&1]++;return answer;} }
