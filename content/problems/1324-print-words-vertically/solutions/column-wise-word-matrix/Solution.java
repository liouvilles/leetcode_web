class Solution {
    public List<String> printVertically(String s){
        String[] words=s.split(" ");
        int maximum=0;
        for(String word:words)maximum=Math.max(maximum,word.length());
        List<String> answer=new ArrayList<>();
        for(int column=0;column<maximum;column++){
            StringBuilder line=new StringBuilder();
            for(String word:words)line.append(column<word.length()?word.charAt(column):' ');
            while(line.length()>0&&line.charAt(line.length()-1)==' ')line.deleteCharAt(line.length()-1);
            answer.add(line.toString());
        }
        return answer;
    }
}
