class Solution {
    public: string interpret(string command){
        string answer;
        for(int i=0;i<(int)command.size();)if(command[i]=='G'){
            answer+='G';
            ++i;
        }else if(command[i+1]==')'){
            answer+='o';
            i+=2;
        }else{
            answer+="al";
            i+=4;
        }
        return answer;
    }
};
