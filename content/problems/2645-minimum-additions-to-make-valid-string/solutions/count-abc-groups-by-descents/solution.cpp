class Solution {
    public:int addMinimum(string word){
        int groups=1;
        for(int i=1;i<(int)word.size();++i)if(word[i]<=word[i-1])++groups;
        return groups*3-word.size();
    }
};
