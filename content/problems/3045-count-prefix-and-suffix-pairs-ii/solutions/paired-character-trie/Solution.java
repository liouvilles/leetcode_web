class Solution {
    public long countPrefixSuffixPairs(String[] words){
        int total=0;
        for(String word:words)total+=word.length();
        Map<Long,Integer> edges=new HashMap<>(total*4/3+1);
        int[] terminal=new int[total+1];
        int nodes=1;
        long answer=0;
        for(String word:words){
            int node=0,length=word.length();
            for(int index=0;index<length;index++){
                int pair=(word.charAt(index)-'a')*26+word.charAt(length-1-index)-'a';
                long key=((long)node<<10)|pair;
                Integer child=edges.get(key);
                if(child==null){
                    child=nodes++;
                    edges.put(key,child);
                }
                node=child;
                answer+=terminal[node];
            }
            terminal[node]++;
        }
        return answer;
    }
}
