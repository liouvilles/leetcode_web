class Solution { public int sumOfMultiples(int n){int answer=0;for(int value=1;value<=n;value++)if(value%3==0||value%5==0||value%7==0)answer+=value;return answer;} }
