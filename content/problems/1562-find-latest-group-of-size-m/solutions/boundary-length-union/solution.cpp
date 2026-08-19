class Solution {
    public: int findLatestStep(vector<int>& arr,int m){
        vector<int> length(arr.size()+2);
        int groups=0,answer=-1;
        for(int step=1;step<=(int)arr.size();++step){
            int position=arr[step-1],left=length[position-1],right=length[position+1];
            if(left==m)--groups;
            if(right==m)--groups;
            int merged=left+right+1;
            length[position-left]=length[position+right]=merged;
            if(merged==m)++groups;
            if(groups)answer=step;
        }
        return answer;
    }
};
