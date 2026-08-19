class Solution {
    public: int maxEqualRowsAfterFlips(vector<vector<int>>& matrix){
        unordered_map<string,int> frequency;
        int answer=0;
        for(auto& row:matrix){
            string key;
            for(int bit:row)key+=char('0'+(bit^row[0]));
            answer=max(answer,++frequency[key]);
        }
        return answer;
    }
};
