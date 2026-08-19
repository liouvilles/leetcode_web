class Solution {
    public int[] numSmallerByFrequency(String[] queries,String[] words){
        int[] frequencies=new int[words.length];
        for(int i=0;i<words.length;i++)frequencies[i]=frequency(words[i]);
        Arrays.sort(frequencies);
        int[] answer=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int value=frequency(queries[i]),left=0,right=frequencies.length;
            while(left<right){
                int middle=(left+right)/2;
                if(frequencies[middle]<=value)left=middle+1;
                else right=middle;
            }
            answer[i]=frequencies.length-left;
        }
        return answer;
    }
    private int frequency(String text){
        char minimum='z';
        int count=0;
        for(char ch:text.toCharArray())if(ch<minimum){
            minimum=ch;
            count=1;
        }else if(ch==minimum)count++;
        return count;
    }
}
