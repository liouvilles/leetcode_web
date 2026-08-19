class Solution {
    public:int minimumLevels(vector<int>& possible){
        int total=0;
        for(int value:possible)total+=value?1:-1;
        int prefix=0;
        for(int index=0;index+1<(int)possible.size();++index){
            prefix+=possible[index]?1:-1;
            if(prefix>total-prefix)return index+1;
        }
        return -1;
    }
};
