class Solution {
    public: vector<string> removeComments(vector<string>& source){
        vector<string> answer;
        bool inBlock=false;
        string buffer;
        for(string& line:source){
            for(int index=0;index<(int)line.size();){
                if(inBlock){
                    if(index+1<(int)line.size()&&line[index]=='*'&&line[index+1]=='/'){
                        inBlock=false;
                        index+=2;
                    }else ++index;
                }else if(index+1<(int)line.size()&&line[index]=='/'&&line[index+1]=='/')break;
                else if(index+1<(int)line.size()&&line[index]=='/'&&line[index+1]=='*'){
                    inBlock=true;
                    index+=2;
                }else buffer+=line[index++];
            }
            if(!inBlock&&!buffer.empty()){
                answer.push_back(buffer);
                buffer.clear();
            }
        }
        return answer;
    }
};
