class Solution {
    int eval(string expression,unordered_map<string,int> environment){
        if(expression[0]!='('){
            if(expression[0]=='-'||isdigit(expression[0]))return stoi(expression);
            return environment[expression];
        }
        vector<string> tokens=split(expression.substr(1,expression.size()-2));
        if(tokens[0]=="add")return eval(tokens[1],environment)+eval(tokens[2],environment);
        if(tokens[0]=="mult")return eval(tokens[1],environment)*eval(tokens[2],environment);
        for(int i=1;i<(int)tokens.size()-1;i+=2)environment[tokens[i]]=eval(tokens[i+1],environment);
        return eval(tokens.back(),environment);
    }
    vector<string> split(string value){
        vector<string> tokens;
        int depth=0,start=0;
        for(int i=0;i<=(int)value.size();++i){
            if(i==(int)value.size()||value[i]==' '&&depth==0){
                tokens.push_back(value.substr(start,i-start));
                start=i+1;
            }else if(value[i]=='(')++depth;
            else if(value[i]==')')--depth;
        }
        return tokens;
    }
    public:int evaluate(string expression){
        return eval(expression,{
        });
    }
};
