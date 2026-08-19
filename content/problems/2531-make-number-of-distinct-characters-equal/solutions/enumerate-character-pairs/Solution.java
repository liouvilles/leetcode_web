class Solution {
    public boolean isItPossible(String word1,String word2){
        int[] first=new int[26],second=new int[26];
        for(char c:word1.toCharArray())first[c-'a']++;
        for(char c:word2.toCharArray())second[c-'a']++;
        int distinct1=0,distinct2=0;
        for(int i=0;i<26;i++){
            if(first[i]>0)distinct1++;
            if(second[i]>0)distinct2++;
        }
        for(int i=0;i<26;i++)if(first[i]>0)for(int j=0;j<26;j++)if(second[j]>0){
            if(i==j){
                if(distinct1==distinct2)return true;
                continue;
            }
            int next1=distinct1-(first[i]==1?1:0)+(first[j]==0?1:0);
            int next2=distinct2-(second[j]==1?1:0)+(second[i]==0?1:0);
            if(next1==next2)return true;
        }
        return false;
    }
}
