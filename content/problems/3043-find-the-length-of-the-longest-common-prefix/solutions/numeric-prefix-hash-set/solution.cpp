class Solution {
    public:int longestCommonPrefix(vector<int>& arr1,vector<int>& arr2){
        unordered_set<int> prefixes;
        for(int number:arr1)for(int value=number;value>0;value/=10)prefixes.insert(value);
        int answer=0;
        for(int number:arr2){
            int value=number,length=to_string(number).size();
            while(value>0&&length>answer){
                if(prefixes.count(value)){
                    answer=length;
                    break;
                }
                value/=10;
                --length;
            }
        }
        return answer;
    }
};
