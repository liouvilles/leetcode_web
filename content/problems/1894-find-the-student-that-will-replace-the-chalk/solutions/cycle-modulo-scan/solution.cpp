class Solution {
    public: int chalkReplacer(vector<int>& chalk,int k){
        long long sum=accumulate(chalk.begin(),chalk.end(),0LL),remaining=k%sum;
        for(int i=0;i<(int)chalk.size();++i){
            if(remaining<chalk[i])return i;
            remaining-=chalk[i];
        }
        return 0;
    }
};
