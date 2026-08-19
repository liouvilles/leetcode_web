class Solution {
    private void updateBest(int[] best,int node,int index,String[] words){
        int current=best[node];
        if(current<0||words[index].length()<words[current].length()||words[index].length()==words[current].length()&&index<current)best[node]=index;
    }
    public int[] stringIndices(String[] wordsContainer,String[] wordsQuery){
        int total=0;
        for(String word:wordsContainer)total+=word.length();
        int[] children=new int[(total+1)*26],best=new int[total+1];
        Arrays.fill(best,-1);
        int nodes=1;
        for(int index=0;index<wordsContainer.length;index++){
            int node=0;
            updateBest(best,node,index,wordsContainer);
            String word=wordsContainer[index];
            for(int position=word.length()-1;position>=0;position--){
                int edge=node*26+word.charAt(position)-'a';
                if(children[edge]==0)children[edge]=nodes++;
                node=children[edge];
                updateBest(best,node,index,wordsContainer);
            }
        }
        int[] answer=new int[wordsQuery.length];
        for(int query=0;query<wordsQuery.length;query++){
            int node=0;
            answer[query]=best[0];
            String word=wordsQuery[query];
            for(int position=word.length()-1;position>=0;position--){
                int child=children[node*26+word.charAt(position)-'a'];
                if(child==0)break;
                node=child;
                answer[query]=best[node];
            }
        }
        return answer;
    }
}
