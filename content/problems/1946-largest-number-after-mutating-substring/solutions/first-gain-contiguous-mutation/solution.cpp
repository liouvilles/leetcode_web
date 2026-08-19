class Solution {
    public: string maximumNumber(string num,vector<int>& change){
        bool started=false;
        for(char& value:num){
            int digit=value-'0',mapped=change[digit];
            if(!started){
                if(mapped>digit){
                    started=true;
                    value='0'+mapped;
                }
            }else if(mapped>=digit)value='0'+mapped;
            else break;
        }
        return num;
    }
};
