class Solution {
public:
    int minimumBoxes(vector<int>& apple,vector<int>& capacity){
        int remaining=accumulate(apple.begin(),apple.end(),0);
        sort(capacity.rbegin(),capacity.rend());
        for(int index=0;index<(int)capacity.size();++index){
            remaining-=capacity[index];
            if(remaining<=0)return index+1;
        }
        return capacity.size();
    }
};
