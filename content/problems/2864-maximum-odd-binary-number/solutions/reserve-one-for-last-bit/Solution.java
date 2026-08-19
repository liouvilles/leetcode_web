class Solution {
    public String maximumOddBinaryNumber(String s){
        int ones=0;
        for(char digit:s.toCharArray())if(digit=='1')ones++;
        StringBuilder answer=new StringBuilder(s.length());
        for(int i=1;i<ones;i++)answer.append('1');
        for(int i=ones;i<s.length();i++)answer.append('0');
        return answer.append('1').toString();
    }
}
