class Solution {
    int lower(vector<int>& values,long long target){
        return lower_bound(values.begin(),values.end(),target)-values.begin();
    }
    int upper(vector<int>& values,long long target){
        return upper_bound(values.begin(),values.end(),target)-values.begin();
    }
    long long floorDiv(long long a,long long b){
        long long quotient=a/b,remainder=a%b;
        if(remainder&&((remainder>0)!=(b>0)))--quotient;
        return quotient;
    }
    long long countProducts(vector<int>& first,vector<int>& second,long long limit){
        long long result=0;
        for(long long value:first)if(value>0)result+=upper(second,floorDiv(limit,value));
        else if(value<0){
            long long ceiling=-floorDiv(-limit,value);
            result+=second.size()-lower(second,ceiling);
        }else if(limit>=0)result+=second.size();
        return result;
    }
    public: long long kthSmallestProduct(vector<int>& nums1,vector<int>& nums2,long long k){
        long long left=-10000000000LL,right=10000000000LL;
        while(left<right){
            long long middle=left+(right-left)/2;
            if(countProducts(nums1,nums2,middle)>=k)right=middle;
            else left=middle+1;
        }
        return left;
    }
};
