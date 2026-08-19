class Solution {
    unordered_map<int,int> memo{
        {
            1,0
        }
    };
    int power(int value){
        if(memo.count(value))return memo[value];
        return memo[value]=1+power(value%2==0?value/2:3*value+1);
    }
    public:int getKth(int lo,int hi,int k){
        vector<int> values(hi-lo+1);
        iota(values.begin(),values.end(),lo);
        sort(values.begin(),values.end(),[&](int a,int b){
            int pa=power(a),pb=power(b);
            return pa==pb?a<b:pa<pb;
        });
        return values[k-1];
    }
};
