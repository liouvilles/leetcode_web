class Solution {
    public:bool strongPasswordCheckerII(string password){
        if(password.size()<8)return false;
        bool lower=false,upper=false,digit=false,special=false;
        string specials="!@#$%^&*()-+";
        for(int i=0;i<(int)password.size();++i){
            char ch=password[i];
            if(i&&ch==password[i-1])return false;
            lower|=islower(ch);
            upper|=isupper(ch);
            digit|=isdigit(ch);
            special|=specials.find(ch)!=string::npos;
        }
        return lower&&upper&&digit&&special;
    }
};
