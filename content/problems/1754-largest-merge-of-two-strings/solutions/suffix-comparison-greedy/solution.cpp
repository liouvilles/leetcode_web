class Solution {
    public: string largestMerge(string word1,string word2){
        string answer;
        int first=0,second=0;
        while(first<(int)word1.size()&&second<(int)word2.size())if(word1.compare(first,string::npos,word2,second,string::npos)>0)answer+=word1[first++];
        else answer+=word2[second++];
        return answer+word1.substr(first)+word2.substr(second);
    }
};
