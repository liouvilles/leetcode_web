class Solution {
    bool valid(const string& s,int length){
        array<int,26> target{
        },current{
        };
        for(int index=0;index<length;++index)++target[s[index]-'a'];
        for(int start=length;start<(int)s.size();start+=length){
            current.fill(0);
            for(int index=start;index<start+length;++index)++current[s[index]-'a'];
            if(target!=current)return false;
        }
        return true;
    }
    public:int minAnagramLength(string s){
        for(int length=1;length<=(int)s.size();++length)if(s.size()%length==0&&valid(s,length))return length;
        return s.size();
    }
};
