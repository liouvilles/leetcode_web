class Solution {
    public String mostCommonWord(String paragraph,String[] banned){
        Set<String> blocked=new HashSet<>(Arrays.asList(banned));
        Map<String,Integer> frequency=new HashMap<>();
        String answer="";
        int best=0;
        for(String word:paragraph.toLowerCase().split("[^a-z]+")){
            if(word.isEmpty()||blocked.contains(word))continue;
            int count=frequency.merge(word,1,Integer::sum);
            if(count>best){
                best=count;
                answer=word;
            }
        }
        return answer;
    }
}
