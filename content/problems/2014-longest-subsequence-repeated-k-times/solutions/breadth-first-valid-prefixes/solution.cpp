class Solution {
    bool valid(string& source,string& candidate,int k){
        int index=0,repeats=0;
        for(char value:source)if(value==candidate[index]){
            if(++index==(int)candidate.size()){
                index=0;
                if(++repeats==k)return true;
            }
        }
        return false;
    }
    public: string longestSubsequenceRepeatedK(string s,int k){
        int frequency[26]={
        };
        for(char value:s)++frequency[value-'a'];
        string alphabet;
        for(int i=0;i<26;++i)if(frequency[i]>=k)alphabet+='a'+i;
        queue<string> pending;
        pending.push("");
        string answer;
        int maximum=s.size()/k;
        while(!pending.empty()){
            string prefix=pending.front();
            pending.pop();
            for(char letter:alphabet){
                string candidate=prefix+letter;
                if((int)candidate.size()<=maximum&&valid(s,candidate,k)){
                    pending.push(candidate);
                    if(candidate.size()>answer.size()||candidate.size()==answer.size()&&candidate>answer)answer=candidate;
                }
            }
        }
        return answer;
    }
};
