class Solution {
    private boolean adjacent(String a,String b){
        if(a.length()!=b.length())return false;
        int differences=0;
        for(int i=0;i<a.length();i++)if(a.charAt(i)!=b.charAt(i)&&++differences>1)return false;
        return differences==1;
    }
    public List<String> getWordsInLongestSubsequence(String[] words,int[] groups){
        int n=words.length;
        int[] dp=new int[n],previous=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(previous,-1);
        int best=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++)if(groups[i]!=groups[j]&&adjacent(words[i],words[j])&&dp[j]+1>dp[i]){
                dp[i]=dp[j]+1;
                previous[i]=j;
            }
            if(dp[i]>dp[best])best=i;
        }
        List<String> answer=new ArrayList<>();
        for(int node=best;node!=-1;node=previous[node])answer.add(words[node]);
        Collections.reverse(answer);
        return answer;
    }
}
