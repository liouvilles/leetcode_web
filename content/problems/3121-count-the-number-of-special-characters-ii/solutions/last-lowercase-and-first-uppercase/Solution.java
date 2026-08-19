class Solution {
    public int numberOfSpecialChars(String word){
        int[] lastLowercase=new int[26],firstUppercase=new int[26];
        Arrays.fill(lastLowercase,-1);
        Arrays.fill(firstUppercase,word.length());
        for(int index=0;index<word.length();index++){
            char letter=word.charAt(index);
            if(Character.isLowerCase(letter))lastLowercase[letter-'a']=index;
            else firstUppercase[letter-'A']=Math.min(firstUppercase[letter-'A'],index);
        }
        int answer=0;
        for(int index=0;index<26;index++)if(lastLowercase[index]!=-1&&firstUppercase[index]<word.length()&&lastLowercase[index]<firstUppercase[index])answer++;
        return answer;
    }
}
