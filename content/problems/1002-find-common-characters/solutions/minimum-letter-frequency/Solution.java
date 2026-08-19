class Solution {
    public List<String> commonChars(String[] words){
        int[] minimum=new int[26];
        Arrays.fill(minimum,Integer.MAX_VALUE);
        for(String word:words){
            int[] frequency=new int[26];
            for(char ch:word.toCharArray())frequency[ch-'a']++;
            for(int i=0;i<26;i++)minimum[i]=Math.min(minimum[i],frequency[i]);
        }
        List<String> answer=new ArrayList<>();
        for(int i=0;i<26;i++)for(int count=0;count<minimum[i];count++)answer.add(String.valueOf((char)('a'+i)));
        return answer;
    }
}
