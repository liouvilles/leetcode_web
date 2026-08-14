class Solution { public int findNumbers(int[] nums){int answer=0;for(int value:nums){int digits=0;for(int number=value;number>0;number/=10)digits++;if(digits%2==0)answer++;}return answer;} }
