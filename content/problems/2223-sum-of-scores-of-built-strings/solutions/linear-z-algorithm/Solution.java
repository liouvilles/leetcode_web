class Solution {
    public long sumScores(String s){
        int n=s.length(),left=0,right=0;
        int[] z=new int[n];
        long answer=n;
        for(int i=1;i<n;i++){
            if(i<=right)z[i]=Math.min(right-i+1,z[i-left]);
            while(i+z[i]<n&&s.charAt(z[i])==s.charAt(i+z[i]))z[i]++;
            if(i+z[i]-1>right){
                left=i;
                right=i+z[i]-1;
            }
            answer+=z[i];
        }
        return answer;
    }
}
