class Solution {
    long long combination(int n,int choose){
        choose=min(choose,n-choose);
        long long answer=1;
        for(int i=1;i<=choose;++i)answer=answer*(n-i+1)/i;
        return answer;
    }
    public:string kthSmallestPath(vector<int>& destination,int k){
        int vertical=destination[0],horizontal=destination[1];
        string answer;
        while(horizontal&&vertical){
            long long startWithH=combination(horizontal+vertical-1,vertical);
            if(k<=startWithH){
                answer+='H';
                --horizontal;
            }else{
                answer+='V';
                --vertical;
                k-=startWithH;
            }
        }
        answer+=string(horizontal,'H');
        answer+=string(vertical,'V');
        return answer;
    }
};
