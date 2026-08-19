class Solution {
    double gain(array<double,2> c){
        return (c[0]+1)/(c[1]+1)-c[0]/c[1];
    }
    public:double maxAverageRatio(vector<vector<int>>& classes,int extraStudents){
        auto compare=[&](auto a,auto b){
            return gain(a)<gain(b);
        };
        priority_queue<array<double,2>,vector<array<double,2>>,decltype(compare)> queue(compare);
        for(auto& c:classes)queue.push({
            (double)c[0],(double)c[1]
        });
        while(extraStudents--){
            auto c=queue.top();
            queue.pop();
            ++c[0];
            ++c[1];
            queue.push(c);
        }
        double sum=0;
        while(!queue.empty()){
            auto c=queue.top();
            queue.pop();
            sum+=c[0]/c[1];
        }
        return sum/classes.size();
    }
};
