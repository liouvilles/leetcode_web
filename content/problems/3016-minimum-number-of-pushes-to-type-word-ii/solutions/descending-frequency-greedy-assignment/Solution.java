class Solution {
    public int minimumPushes(String word){
        int[] frequency=new int[26];
        for(char letter:word.toCharArray())frequency[letter-'a']++;
        Arrays.sort(frequency);
        int answer=0;
        for(int rank=0;rank<26;rank++)answer+=frequency[25-rank]*(rank/8+1);
        return answer;
    }
}
