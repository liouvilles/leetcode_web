class Solution {
    public: bool validUtf8(vector<int>& data){
        int remaining=0;
        for(int raw:data){
            int value=raw&255;
            if(remaining==0){
                if((value&128)==0)continue;
                int count=0,mask=128;
                while(value&mask){
                    ++count;
                    mask>>=1;
                }
                if(count==1||count>4)return false;
                remaining=count-1;
            }else{
                if((value&192)!=128)return false;
                --remaining;
            }
        }
        return remaining==0;
    }
};
