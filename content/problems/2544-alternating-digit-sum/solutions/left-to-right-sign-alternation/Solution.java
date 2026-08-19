class Solution { public int alternateDigitSum(int n){String digits=String.valueOf(n);int answer=0;for(int i=0;i<digits.length();i++)answer+=(i%2==0?1:-1)*(digits.charAt(i)-'0');return answer;} }
