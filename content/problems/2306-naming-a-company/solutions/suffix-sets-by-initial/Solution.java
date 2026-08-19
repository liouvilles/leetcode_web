class Solution {
    public long distinctNames(String[] ideas){
        Set<String>[] groups=new Set[26];
        for(int i=0;i<26;i++)groups[i]=new HashSet<>();
        for(String idea:ideas)groups[idea.charAt(0)-'a'].add(idea.substring(1));
        long answer=0;
        for(int i=0;i<26;i++)for(int j=i+1;j<26;j++){
            int common=0;
            for(String suffix:groups[i])if(groups[j].contains(suffix))common++;
            answer+=2L*(groups[i].size()-common)*(groups[j].size()-common);
        }
        return answer;
    }
}
