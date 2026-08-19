class Solution {
    string expression;
    int index=0;
    set<string> parseExpression(){
        set<string> result=parseTerm();
        while(index<(int)expression.size()&&expression[index]==','){
            ++index;
            auto term=parseTerm();
            result.insert(term.begin(),term.end());
        }
        return result;
    }
    set<string> parseTerm(){
        set<string> result{
            ""
        };
        while(index<(int)expression.size()&&expression[index]!=','&&expression[index]!='}'){
            set<string> factor;
            if(expression[index]=='{'){
                ++index;
                factor=parseExpression();
                ++index;
            }else factor.insert(string(1,expression[index++]));
            set<string> product;
            for(string left:result)for(string right:factor)product.insert(left+right);
            result.swap(product);
        }
        return result;
    }
    public:vector<string> braceExpansionII(string input){
        expression=input;
        index=0;
        auto result=parseExpression();
        return {
            result.begin(),result.end()
        };
    }
};
