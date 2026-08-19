class Solution {
    struct Compare{
        bool operator()(const pair<int,char>& a,const pair<int,char>& b)const{
            return a.first!=b.first?a.first<b.first:a.second>b.second;
        }
    };
    public:string longestDiverseString(int a,int b,int c){
        priority_queue<pair<int,char>,vector<pair<int,char>>,Compare> heap;
        if(a)heap.push({
            a,'a'
        });
        if(b)heap.push({
            b,'b'
        });
        if(c)heap.push({
            c,'c'
        });
        string answer;
        while(!heap.empty()){
            auto first=heap.top();
            heap.pop();
            int length=answer.size();
            if(length>=2&&answer[length-1]==first.second&&answer[length-2]==first.second){
                if(heap.empty())break;
                auto second=heap.top();
                heap.pop();
                answer+=second.second;
                if(--second.first)heap.push(second);
                heap.push(first);
            }else{
                answer+=first.second;
                if(--first.first)heap.push(first);
            }
        }
        return answer;
    }
};
