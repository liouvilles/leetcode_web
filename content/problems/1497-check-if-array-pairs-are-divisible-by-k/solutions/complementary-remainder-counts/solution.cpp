class Solution {
    public: bool canArrange(vector<int>& arr,int k){
        vector<int> count(k);
        for(int value:arr)++count[(value%k+k)%k];
        if(count[0]%2)return false;
        for(int remainder=1;remainder<k;++remainder)if(remainder==k-remainder){
            if(count[remainder]%2)return false;
        }else if(count[remainder]!=count[k-remainder])return false;
        return true;
    }
};
