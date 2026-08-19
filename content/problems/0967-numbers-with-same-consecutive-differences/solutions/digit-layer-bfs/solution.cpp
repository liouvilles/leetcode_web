class Solution {
    public: vector<int> numsSameConsecDiff(int n,int k){
        if(n==1)return {
            0,1,2,3,4,5,6,7,8,9
        };
        vector<int> values{
            1,2,3,4,5,6,7,8,9
        };
        for(int length=1;length<n;++length){
            vector<int> next;
            for(int value:values){
                int last=value%10,a=last+k,b=last-k;
                if(a<10)next.push_back(value*10+a);
                if(b>=0&&b!=a)next.push_back(value*10+b);
            }
            values.swap(next);
        }
        return values;
    }
};
