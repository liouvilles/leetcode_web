class Solution {
    private boolean isVowel(char ch){
        return "AEIOUaeiou".indexOf(ch)>=0;
    }
    public String sortVowels(String s){
        List<Character> vowels=new ArrayList<>();
        for(char ch:s.toCharArray())if(isVowel(ch))vowels.add(ch);
        Collections.sort(vowels);
        char[] chars=s.toCharArray();
        int index=0;
        for(int i=0;i<chars.length;i++)if(isVowel(chars[i]))chars[i]=vowels.get(index++);
        return new String(chars);
    }
}
