class Solution {
    private int mask(String word){
        int value=0;
        for(int i=0;i<word.length();i++)value|=1<<(word.charAt(i)-'a');
        return value;
    }
    public int wordCount(String[] startWords,String[] targetWords){
        Set<Integer> starts=new HashSet<>();
        for(String word:startWords)starts.add(mask(word));
        int answer=0;
        for(String word:targetWords){
            int value=mask(word);
            for(int bits=value;bits!=0;bits&=bits-1){
                int bit=bits&-bits;
                if(starts.contains(value^bit)){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
