class Solution {
    private String signature(String word){
        char[] chars=word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public List<String> removeAnagrams(String[] words){
        List<String> answer=new ArrayList<>();
        String previous="";
        for(String word:words){
            String current=signature(word);
            if(!current.equals(previous)){
                answer.add(word);
                previous=current;
            }
        }
        return answer;
    }
}
