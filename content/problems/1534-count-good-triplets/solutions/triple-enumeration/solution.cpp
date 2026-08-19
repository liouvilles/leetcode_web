class Solution {
    public: int countGoodTriplets(vector<int>& arr,int a,int b,int c){
        int answer=0;
        for(int i=0;i<(int)arr.size();++i)for(int j=i+1;j<(int)arr.size();++j)if(abs(arr[i]-arr[j])<=a)for(int k=j+1;k<(int)arr.size();++k)if(abs(arr[j]-arr[k])<=b&&abs(arr[i]-arr[k])<=c)++answer;
        return answer;
    }
};
