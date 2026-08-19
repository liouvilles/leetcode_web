class Solution {
    public int[] missingRolls(int[] rolls,int mean,int n){
        int sum=Arrays.stream(rolls).sum(),missing=mean*(rolls.length+n)-sum;
        if(missing<n||missing>6*n)return new int[0];
        int[] answer=new int[n];
        Arrays.fill(answer,missing/n);
        for(int i=0;i<missing%n;i++)answer[i]++;
        return answer;
    }
}
