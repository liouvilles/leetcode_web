class Solution { public: vector<int> memLeak(int memory1,int memory2){int time=1;while(max(memory1,memory2)>=time){(memory1>=memory2?memory1:memory2)-=time++;}return {time,memory1,memory2};} };
