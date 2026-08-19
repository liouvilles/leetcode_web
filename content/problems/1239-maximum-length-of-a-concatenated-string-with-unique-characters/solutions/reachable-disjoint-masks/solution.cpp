class Solution {
    public: int maxLength(vector<string>& arr){
        vector<int> states{
            0
        };
        int answer=0;
        for(string& word:arr){
            int mask=0;
            bool valid=true;
            for(char ch:word){
                int bit=1<<(ch-'a');
                if(mask&bit){
                    valid=false;
                    break;
                }
                mask|=bit;
            }
            if(!valid)continue;
            int size=states.size();
            for(int i=0;i<size;++i)if(!(states[i]&mask)){
                int combined=states[i]|mask;
                states.push_back(combined);
                answer=max(answer,__builtin_popcount(combined));
            }
        }
        return answer;
    }
};
