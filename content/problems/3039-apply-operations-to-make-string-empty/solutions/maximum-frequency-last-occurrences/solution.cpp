class Solution {
    public:string lastNonEmptyString(string s){
        array<int,26> frequency{
        },lastIndex{
        };
        for(int i=0;i<(int)s.size();++i){
            int letter=s[i]-'a';
            ++frequency[letter];
            lastIndex[letter]=i;
        }
        int maximum=*max_element(frequency.begin(),frequency.end());
        string answer;
        for(int i=0;i<(int)s.size();++i){
            int letter=s[i]-'a';
            if(frequency[letter]==maximum&&lastIndex[letter]==i)answer.push_back(s[i]);
        }
        return answer;
    }
};
