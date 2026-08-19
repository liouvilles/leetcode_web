class Solution {
    public: int repeatedStringMatch(string a,string b){
        string value;
        int repeats=0;
        while(value.size()<b.size()){
            value+=a;
            ++repeats;
        }
        if(value.find(b)!=string::npos)return repeats;
        value+=a;
        return value.find(b)!=string::npos?repeats+1:-1;
    }
};
