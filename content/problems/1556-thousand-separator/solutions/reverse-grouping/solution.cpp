class Solution {
    public: string thousandSeparator(int n){
        string text=to_string(n),reversed;
        int count=0;
        for(int i=text.size()-1;i>=0;--i){
            reversed+=text[i];
            if(++count%3==0&&i>0)reversed+='.';
        }
        reverse(reversed.begin(),reversed.end());
        return reversed;
    }
};
