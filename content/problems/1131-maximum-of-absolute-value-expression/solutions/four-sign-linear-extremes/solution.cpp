class Solution {
    public: int maxAbsValExpr(vector<int>& arr1,vector<int>& arr2){
        int answer=0;
        for(int signB:{
            -1,1
        })for(int signI:{
            -1,1
        }){
            int minimum=INT_MAX,maximum=INT_MIN;
            for(int i=0;i<(int)arr1.size();++i){
                int value=arr1[i]+signB*arr2[i]+signI*i;
                minimum=min(minimum,value);
                maximum=max(maximum,value);
            }
            answer=max(answer,maximum-minimum);
        }
        return answer;
    }
};
