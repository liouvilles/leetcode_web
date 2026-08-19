class Solution {
    public int countTime(String time){
        int answer=0;
        for(int hour=0;hour<24;hour++)for(int minute=0;minute<60;minute++){
            String value=String.format("%02d:%02d",hour,minute);
            boolean matches=true;
            for(int i=0;i<5;i++)if(time.charAt(i)!='?'&&time.charAt(i)!=value.charAt(i))matches=false;
            if(matches)answer++;
        }
        return answer;
    }
}
