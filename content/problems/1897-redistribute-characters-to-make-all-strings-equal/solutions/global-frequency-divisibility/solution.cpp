class Solution {
    public: bool makeEqual(vector<string>& words){
        int frequency[26]={
        };
        for(auto& word:words)for(char letter:word)++frequency[letter-'a'];
        for(int count:frequency)if(count%words.size())return false;
        return true;
    }
};
