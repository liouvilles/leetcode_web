class Solution {
    public:int countTime(string time){
        int answer=0;
        for(int hour=0;hour<24;++hour)for(int minute=0;minute<60;++minute){
            char buffer[6];
            snprintf(buffer,6,"%02d:%02d",hour,minute);
            bool matches=true;
            for(int i=0;i<5;++i)if(time[i]!='?'&&time[i]!=buffer[i])matches=false;
            answer+=matches;
        }
        return answer;
    }
};
