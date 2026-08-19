class Solution {
    public:string robotWithString(string s){
        int frequency[26]={
        };
        for(char ch:s)++frequency[ch-'a'];
        int smallest=0;
        string stack,answer;
        for(char ch:s){
            stack+=ch;
            --frequency[ch-'a'];
            while(smallest<26&&!frequency[smallest])++smallest;
            while(!stack.empty()&&(smallest==26||stack.back()-'a'<=smallest)){
                answer+=stack.back();
                stack.pop_back();
            }
        }
        return answer;
    }
};
