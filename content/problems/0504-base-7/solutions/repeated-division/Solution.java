class Solution {
    public String convertToBase7(int num){
        if(num==0)return "0";
        long value=Math.abs((long)num);
        StringBuilder answer=new StringBuilder();
        while(value>0){
            answer.append(value%7);
            value/=7;
        }
        if(num<0)answer.append('-');
        return answer.reverse().toString();
    }
}
