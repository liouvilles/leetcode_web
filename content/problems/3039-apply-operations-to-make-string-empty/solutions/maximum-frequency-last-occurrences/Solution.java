class Solution {
    public String lastNonEmptyString(String s){
        int[] frequency=new int[26],lastIndex=new int[26];
        for(int i=0;i<s.length();i++){
            int letter=s.charAt(i)-'a';
            frequency[letter]++;
            lastIndex[letter]=i;
        }
        int maximum=0;
        for(int count:frequency)maximum=Math.max(maximum,count);
        StringBuilder answer=new StringBuilder();
        for(int i=0;i<s.length();i++){
            int letter=s.charAt(i)-'a';
            if(frequency[letter]==maximum&&lastIndex[letter]==i)answer.append(s.charAt(i));
        }
        return answer.toString();
    }
}
