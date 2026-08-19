class Solution {
    public: vector<bool> camelMatch(vector<string>& queries,string pattern){
        vector<bool> answer;
        for(string& query:queries){
            int index=0;
            bool valid=true;
            for(char ch:query)if(index<(int)pattern.size()&&ch==pattern[index])++index;
            else if(isupper(ch)){
                valid=false;
                break;
            }
            answer.push_back(valid&&index==(int)pattern.size());
        }
        return answer;
    }
};
