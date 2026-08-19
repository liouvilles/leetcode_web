class Solution {
    public: vector<int> threeEqualParts(vector<int>& arr){
        int ones=accumulate(arr.begin(),arr.end(),0);
        if(ones==0)return {
            0,2
        };
        if(ones%3)return {
            -1,-1
        };
        int part=ones/3,first=-1,second=-1,third=-1,seen=0;
        for(int i=0;i<(int)arr.size();++i)if(arr[i]){
            ++seen;
            if(seen==1)first=i;
            else if(seen==part+1)second=i;
            else if(seen==2*part+1)third=i;
        }
        int length=arr.size()-third;
        if(first+length>second||second+length>third)return {
            -1,-1
        };
        for(int i=0;i<length;++i)if(arr[first+i]!=arr[second+i]||arr[first+i]!=arr[third+i])return {
            -1,-1
        };
        return {
            first+length-1,second+length
        };
    }
};
