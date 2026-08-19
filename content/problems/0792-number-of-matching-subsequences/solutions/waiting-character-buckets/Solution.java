class Solution {
    public int numMatchingSubseq(String s,String[] words){
        List<Deque<int[]>> buckets=new ArrayList<>();
        for(int i=0;i<26;i++)buckets.add(new ArrayDeque<>());
        for(int i=0;i<words.length;i++)buckets.get(words[i].charAt(0)-'a').addLast(new int[]{
            i,0
        });
        int answer=0;
        for(char c:s.toCharArray()){
            Deque<int[]> queue=buckets.get(c-'a');
            int size=queue.size();
            while(size-->0){
                int[] state=queue.removeFirst();
                state[1]++;
                if(state[1]==words[state[0]].length())answer++;
                else buckets.get(words[state[0]].charAt(state[1])-'a').addLast(state);
            }
        }
        return answer;
    }
}
