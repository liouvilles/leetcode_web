class Solution {
    public List<Boolean> camelMatch(String[] queries,String pattern){
        List<Boolean> answer=new ArrayList<>();
        for(String query:queries){
            int index=0;
            boolean valid=true;
            for(char ch:query.toCharArray())if(index<pattern.length()&&ch==pattern.charAt(index))index++;
            else if(Character.isUpperCase(ch)){
                valid=false;
                break;
            }
            answer.add(valid&&index==pattern.length());
        }
        return answer;
    }
}
