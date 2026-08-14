class Solution { public: int reachNumber(int target){target=abs(target);int step=0,sum=0;while(sum<target||(sum-target)%2)sum+=++step;return step;} };
