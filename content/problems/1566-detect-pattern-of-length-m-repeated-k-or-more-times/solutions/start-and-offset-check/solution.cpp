class Solution {
    public: bool containsPattern(vector<int>& arr,int m,int k){
        int required=m*k;
        for(int start=0;start+required<=(int)arr.size();++start){
            bool valid=true;
            for(int offset=m;offset<required;++offset)if(arr[start+offset]!=arr[start+offset-m]){
                valid=false;
                break;
            }
            if(valid)return true;
        }
        return false;
    }
};
