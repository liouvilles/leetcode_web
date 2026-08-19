class Solution {
    public List<String> maxNumOfSubstrings(String text){
        int[] first=new int[26],last=new int[26];
        Arrays.fill(first,-1);
        for(int i=0;i<text.length();i++){
            int c=text.charAt(i)-'a';
            if(first[c]==-1)first[c]=i;
            last[c]=i;
        }
        List<int[]> intervals=new ArrayList<>();
        for(int c=0;c<26;c++)if(first[c]!=-1){
            int start=first[c],end=last[c];
            boolean valid=true;
            for(int i=start;i<=end;i++){
                int value=text.charAt(i)-'a';
                if(first[value]<start){
                    valid=false;
                    break;
                }
                end=Math.max(end,last[value]);
            }
            if(valid)intervals.add(new int[]{
                start,end
            });
        }
        intervals.sort(Comparator.comparingInt(interval->interval[1]));
        List<String> answer=new ArrayList<>();
        int previous=-1;
        for(int[] interval:intervals)if(interval[0]>previous){
            answer.add(text.substring(interval[0],interval[1]+1));
            previous=interval[1];
        }
        return answer;
    }
}
