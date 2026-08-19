class Solution {
    public int findJudge(int n,int[][] trust){
        int[] score=new int[n+1];
        for(int[] relation:trust){
            score[relation[0]]--;
            score[relation[1]]++;
        }
        for(int person=1;person<=n;person++)if(score[person]==n-1)return person;
        return -1;
    }
}
