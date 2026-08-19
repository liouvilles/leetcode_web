class Solution {
    void flip(vector<int>& arr,int length){
        reverse(arr.begin(),arr.begin()+length);
    }
    public:vector<int> pancakeSort(vector<int>& arr){
        vector<int> moves;
        for(int size=arr.size();size>1;--size){
            int index=max_element(arr.begin(),arr.begin()+size)-arr.begin();
            if(index==size-1)continue;
            if(index>0){
                flip(arr,index+1);
                moves.push_back(index+1);
            }
            flip(arr,size);
            moves.push_back(size);
        }
        return moves;
    }
};
