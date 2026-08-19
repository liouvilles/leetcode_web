class Solution {
    bool valid(string& value,int index,char candidate){
        return index<1||(value[index-1]!=candidate&&(index<2||value[index-2]!=candidate));
    }
    public:string smallestBeautifulString(string s,int k){
        char limit='a'+k;
        for(int index=s.size()-1;index>=0;--index)for(char candidate=s[index]+1;candidate<limit;++candidate)if(valid(s,index,candidate)){
            s[index]=candidate;
            for(int next=index+1;next<(int)s.size();++next)for(char fill='a';fill<limit;++fill)if(valid(s,next,fill)){
                s[next]=fill;
                break;
            }
            return s;
        }
        return "";
    }
};
