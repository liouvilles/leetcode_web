class Solution {
    public String maximumNumber(String num,int[] change){
        char[] result=num.toCharArray();
        boolean started=false;
        for(int i=0;i<result.length;i++){
            int digit=result[i]-'0',mapped=change[digit];
            if(!started){
                if(mapped>digit){
                    started=true;
                    result[i]=(char)('0'+mapped);
                }
            }else if(mapped>=digit)result[i]=(char)('0'+mapped);
            else break;
        }
        return new String(result);
    }
}
