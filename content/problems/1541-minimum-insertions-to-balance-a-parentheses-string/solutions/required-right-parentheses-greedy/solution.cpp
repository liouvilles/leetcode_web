class Solution {
    public: int minInsertions(string text){
        int insertions=0,need=0;
        for(char value:text)if(value=='('){
            if(need%2){
                ++insertions;
                --need;
            }
            need+=2;
        }else if(--need<0){
            ++insertions;
            need=1;
        }
        return insertions+need;
    }
};
