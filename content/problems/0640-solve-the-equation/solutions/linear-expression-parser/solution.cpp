class Solution {
    pair<int,int> parse(string expression){
        int coefficient=0,constant=0,index=0,sign=1;
        while(index<(int)expression.size()){
            if(expression[index]=='+'||expression[index]=='-')sign=expression[index++]=='-'?-1:1;
            int start=index,value=0;
            while(index<(int)expression.size()&&isdigit(expression[index]))value=value*10+expression[index++]-'0';
            if(index<(int)expression.size()&&expression[index]=='x'){
                coefficient+=sign*(index==start?1:value);
                ++index;
            }else constant+=sign*value;
        }
        return{
            coefficient,constant
        };
    }
    public:string solveEquation(string equation){
        int equal=equation.find('=');
        auto left=parse(equation.substr(0,equal)),right=parse(equation.substr(equal+1));
        int coefficient=left.first-right.first,constant=right.second-left.second;
        if(coefficient==0)return constant==0?"Infinite solutions":"No solution";
        return "x="+to_string(constant/coefficient);
    }
};
