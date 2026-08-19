class Solution {
    public: string reorganizeString(string s){
        int counts[26]{
        };
        for(char c:s)++counts[c-'a'];
        struct Compare{
            bool operator()(const pair<int,int>& a,const pair<int,int>& b)const{
                return a.second!=b.second?a.second<b.second:a.first>b.first;
            }
        };
        priority_queue<pair<int,int>,vector<pair<int,int>>,Compare> heap;
        for(int c=0;c<26;++c)if(counts[c])heap.push({
            c,counts[c]
        });
        string answer;
        pair<int,int> previous{
            -1,0
        };
        while(!heap.empty()){
            auto current=heap.top();
            heap.pop();
            answer+=char('a'+current.first);
            if(previous.second>0)heap.push(previous);
            --current.second;
            previous=current;
        }
        return previous.second>0?"":answer;
    }
};
