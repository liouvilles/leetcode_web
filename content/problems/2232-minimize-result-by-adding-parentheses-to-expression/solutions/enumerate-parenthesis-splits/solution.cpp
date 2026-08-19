class Solution {
    public:string minimizeResult(string expression){
        int plus=expression.find('+');
        string left=expression.substr(0,plus),right=expression.substr(plus+1),answer;
        int best=INT_MAX;
        for(int i=0;i<(int)left.size();++i)for(int j=1;j<=(int)right.size();++j){
            int outsideLeft=i?stoi(left.substr(0,i)):1;
            int insideLeft=stoi(left.substr(i));
            int insideRight=stoi(right.substr(0,j));
            int outsideRight=j<(int)right.size()?stoi(right.substr(j)):1;
            int value=outsideLeft*(insideLeft+insideRight)*outsideRight;
            if(value<best){
                best=value;
                answer=left.substr(0,i)+"("+left.substr(i)+"+"+right.substr(0,j)+")"+right.substr(j);
            }
        }
        return answer;
    }
};
