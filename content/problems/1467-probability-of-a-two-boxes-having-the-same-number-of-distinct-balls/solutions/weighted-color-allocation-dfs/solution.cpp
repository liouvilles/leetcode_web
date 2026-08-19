class Solution {
    vector<int> balls;
    int half;
    vector<vector<double>> choose;
    double dfs(int color,int used,int distinctFirst,int distinctSecond,double ways){
        if(used>half)return 0;
        if(color==(int)balls.size())return used==half&&distinctFirst==distinctSecond?ways:0;
        double answer=0;
        for(int take=0;take<=balls[color];++take)answer+=dfs(color+1,used+take,distinctFirst+(take>0),distinctSecond+(take<balls[color]),ways*choose[balls[color]][take]);
        return answer;
    }
    public:double getProbability(vector<int>& balls){
        this->balls=balls;
        int total=accumulate(balls.begin(),balls.end(),0);
        half=total/2;
        choose.assign(total+1,vector<double>(total+1));
        for(int n=0;n<=total;++n){
            choose[n][0]=choose[n][n]=1;
            for(int k=1;k<n;++k)choose[n][k]=choose[n-1][k-1]+choose[n-1][k];
        }
        return dfs(0,0,0,0,1)/choose[total][half];
    }
};
