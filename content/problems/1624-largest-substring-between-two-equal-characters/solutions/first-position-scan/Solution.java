class Solution {
    public int maxLengthBetweenEqualCharacters(String text){
        int[] first=new int[26];
        Arrays.fill(first,-1);
        int answer=-1;
        for(int i=0;i<text.length();i++){
            int letter=text.charAt(i)-'a';
            if(first[letter]<0)first[letter]=i;
            else answer=Math.max(answer,i-first[letter]-1);
        }
        return answer;
    }
}
