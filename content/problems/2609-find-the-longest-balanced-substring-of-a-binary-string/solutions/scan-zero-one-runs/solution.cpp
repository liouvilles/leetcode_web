class Solution {
    public:int findTheLongestBalancedSubstring(string s){
        int index=0,answer=0;
        while(index<(int)s.size()){
            int zeros=0,ones=0;
            while(index<(int)s.size()&&s[index]=='0'){
                ++zeros;
                ++index;
            }while(index<(int)s.size()&&s[index]=='1'){
                ++ones;
                ++index;
            }
            answer=max(answer,2*min(zeros,ones));
        }
        return answer;
    }
};
