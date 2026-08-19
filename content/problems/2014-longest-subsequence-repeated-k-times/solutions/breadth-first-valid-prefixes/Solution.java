class Solution {
    private boolean valid(String source,String candidate,int k){
        int index=0,repeats=0;
        for(char value:source.toCharArray())if(value==candidate.charAt(index)){
            index++;
            if(index==candidate.length()){
                index=0;
                if(++repeats==k)return true;
            }
        }
        return false;
    }
    public String longestSubsequenceRepeatedK(String s,int k){
        int[] frequency=new int[26];
        for(char value:s.toCharArray())frequency[value-'a']++;
        StringBuilder alphabet=new StringBuilder();
        for(int i=0;i<26;i++)if(frequency[i]>=k)alphabet.append((char)('a'+i));
        Queue<String> queue=new ArrayDeque<>();
        queue.offer("");
        String answer="";
        int maximum=s.length()/k;
        while(!queue.isEmpty()){
            String prefix=queue.poll();
            for(int i=0;i<alphabet.length();i++){
                String candidate=prefix+alphabet.charAt(i);
                if(candidate.length()<=maximum&&valid(s,candidate,k)){
                    queue.offer(candidate);
                    if(candidate.length()>answer.length()||candidate.length()==answer.length()&&candidate.compareTo(answer)>0)answer=candidate;
                }
            }
        }
        return answer;
    }
}
