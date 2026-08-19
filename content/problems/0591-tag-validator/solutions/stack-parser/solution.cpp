class Solution {
    bool validName(const string& name){
        if(name.empty()||name.size()>9)return false;
        return all_of(name.begin(),name.end(),[](char c){
            return c>='A'&&c<='Z';
        });
    }
    public:bool isValid(string code){
        vector<string> stack;
        bool root=false;
        int index=0;
        while(index<(int)code.size()){
            if(index>0&&stack.empty())return false;
            if(code.compare(index,9,"<![CDATA[")==0){
                if(stack.empty())return false;
                int end=code.find("]]>",index+9);
                if(end==string::npos)return false;
                index=end+3;
            }else if(code.compare(index,2,"</")==0){
                int end=code.find('>',index+2);
                if(end==string::npos)return false;
                string name=code.substr(index+2,end-index-2);
                if(!validName(name)||stack.empty()||stack.back()!=name)return false;
                stack.pop_back();
                index=end+1;
            }else if(code[index]=='<'){
                int end=code.find('>',index+1);
                if(end==string::npos)return false;
                string name=code.substr(index+1,end-index-1);
                if(!validName(name))return false;
                stack.push_back(name);
                root=true;
                index=end+1;
            }else{
                if(stack.empty())return false;
                ++index;
            }
        }
        return root&&stack.empty();
    }
};
