class Solution {
    public String[] divideString(String s,int k,char fill){
        String[] answer=new String[(s.length()+k-1)/k];
        for(int group=0,start=0;group<answer.length;group++,start+=k){
            StringBuilder value=new StringBuilder(s.substring(start,Math.min(start+k,s.length())));
            while(value.length()<k)value.append(fill);
            answer[group]=value.toString();
        }
        return answer;
    }
}
