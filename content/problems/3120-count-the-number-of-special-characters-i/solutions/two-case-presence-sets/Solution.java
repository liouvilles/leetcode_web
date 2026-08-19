class Solution {
    public int numberOfSpecialChars(String word){
        boolean[] lowercase=new boolean[26],uppercase=new boolean[26];
        for(char letter:word.toCharArray())if(Character.isLowerCase(letter))lowercase[letter-'a']=true;
        else uppercase[letter-'A']=true;
        int answer=0;
        for(int index=0;index<26;index++)if(lowercase[index]&&uppercase[index])answer++;
        return answer;
    }
}
