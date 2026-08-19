class Solution {
    public:string smallestNumber(string pattern){
        string answer;
        vector<int> stack;
        for(int i=0;i<=(int)pattern.size();++i){
            stack.push_back(i+1);
            if(i==(int)pattern.size()||pattern[i]=='I')while(!stack.empty()){
                answer+=char('0'+stack.back());
                stack.pop_back();
            }
        }
        return answer;
    }
};
