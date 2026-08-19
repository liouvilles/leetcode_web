class Solution {
    public: int minimizedMaximum(int n,vector<int>& quantities){
        int left=1,right=*max_element(quantities.begin(),quantities.end());
        while(left<right){
            int middle=(left+right)/2;
            long long required=0;
            for(int quantity:quantities)required+=(quantity+middle-1)/middle;
            if(required<=n)right=middle;
            else left=middle+1;
        }
        return left;
    }
};
