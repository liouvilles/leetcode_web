class Solution {
    public String shortestSuperstring(String[] words){
        int n=words.length;
        int[][] overlap=new int[n][n];
        for(int i=0;i<n;i++)for(int j=0;j<n;j++)if(i!=j)for(int length=Math.min(words[i].length(),words[j].length());length>=0;length--)if(words[i].endsWith(words[j].substring(0,length))){
            overlap[i][j]=length;
            break;
        }
        String[][] dp=new String[1<<n][n];
        for(int i=0;i<n;i++)dp[1<<i][i]=words[i];
        for(int mask=1;mask<(1<<n);mask++)for(int last=0;last<n;last++)if(dp[mask][last]!=null)for(int next=0;next<n;next++)if((mask&(1<<next))==0){
            int nextMask=mask|(1<<next);
            String candidate=dp[mask][last]+words[next].substring(overlap[last][next]);
            if(better(candidate,dp[nextMask][next]))dp[nextMask][next]=candidate;
        }
        String answer=null;
        for(String candidate:dp[(1<<n)-1])if(better(candidate,answer))answer=candidate;
        return answer;
    }
    private boolean better(String a,String b){
        return b==null||a.length()<b.length()||a.length()==b.length()&&a.compareTo(b)<0;
    }
}
