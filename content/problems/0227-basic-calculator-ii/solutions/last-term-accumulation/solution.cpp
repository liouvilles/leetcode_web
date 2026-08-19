class Solution {
    public: int calculate(string s){
        int result=0,last=0,number=0;
        char op='+';
        for(int i=0;i<(int)s.size();++i){
            char c=s[i];
            if(isdigit(c))number=number*10+c-'0';
            if((!isdigit(c)&&c!=' ')||i==(int)s.size()-1){
                if(op=='+'){
                    result+=last;
                    last=number;
                }else if(op=='-'){
                    result+=last;
                    last=-number;
                }else if(op=='*')last*=number;
                else last/=number;
                op=c;
                number=0;
            }
        }
        return result+last;
    }
};
