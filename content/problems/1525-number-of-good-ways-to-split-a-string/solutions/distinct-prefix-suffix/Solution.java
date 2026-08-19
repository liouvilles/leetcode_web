class Solution {
    public int numSplits(String text){
        int n=text.length();
        int[] left=new int[n],right=new int[n],count=new int[26];
        int distinct=0;
        for(int i=0;i<n;i++){
            if(count[text.charAt(i)-'a']++==0)distinct++;
            left[i]=distinct;
        }
        Arrays.fill(count,0);
        distinct=0;
        for(int i=n-1;i>=0;i--){
            if(count[text.charAt(i)-'a']++==0)distinct++;
            right[i]=distinct;
        }
        int answer=0;
        for(int i=0;i<n-1;i++)if(left[i]==right[i+1])answer++;
        return answer;
    }
}
