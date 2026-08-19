class Solution {
    public:int numberOfBeams(vector<string>& bank){
        int previous=0,answer=0;
        for(string& row:bank){
            int current=count(row.begin(),row.end(),'1');
            if(current){
                answer+=previous*current;
                previous=current;
            }
        }
        return answer;
    }
};
