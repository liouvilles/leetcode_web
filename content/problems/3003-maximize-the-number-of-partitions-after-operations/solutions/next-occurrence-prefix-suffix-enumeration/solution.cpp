class Solution {
    int n,limitDistinct;
    vector<array<int,26>> next;
    array<int,26> work;
    int cut(int start,int changedIndex,int oldLetter,int replacement){
        work=next[start];
        if(changedIndex>=0&&replacement!=oldLetter){
            if(work[oldLetter]==changedIndex)work[oldLetter]=next[changedIndex+1][oldLetter];
            if(changedIndex>=start&&changedIndex<work[replacement])work[replacement]=changedIndex;
        }
        sort(work.begin(),work.end());
        return limitDistinct<26?work[limitDistinct]:n;
    }
    public:int maxPartitionsAfterOperations(string s,int k){
        n=s.size();
        limitDistinct=k;
        next.assign(n+1,{
        });
        next[n].fill(n);
        for(int i=n-1;i>=0;--i){
            next[i]=next[i+1];
            next[i][s[i]-'a']=i;
        }
        vector<int> suffix(n+1),segmentStart(n),prefixPartitions(n);
        for(int i=n-1;i>=0;--i){
            int boundary=cut(i,-1,0,0);
            suffix[i]=1+(boundary<n?suffix[boundary]:0);
        }
        int mask=0,start=0,parts=0;
        for(int i=0;i<n;++i){
            int bit=1<<(s[i]-'a');
            if(__builtin_popcount(mask|bit)>k){
                ++parts;
                start=i;
                mask=bit;
            }else mask|=bit;
            segmentStart[i]=start;
            prefixPartitions[i]=parts;
        }
        int answer=suffix[0];
        for(int i=0;i<n;++i){
            int oldLetter=s[i]-'a';
            for(int replacement=0;replacement<26;++replacement){
                int firstBoundary=cut(segmentStart[i],i,oldLetter,replacement),candidate;
                if(firstBoundary<=i){
                    int secondBoundary=cut(i,i,oldLetter,replacement);
                    candidate=prefixPartitions[i]+2+(secondBoundary<n?suffix[secondBoundary]:0);
                }else candidate=prefixPartitions[i]+1+(firstBoundary<n?suffix[firstBoundary]:0);
                answer=max(answer,candidate);
            }
        }
        return answer;
    }
};
