class Solution {
    public List<String> ambiguousCoordinates(String s){
        String digits=s.substring(1,s.length()-1);
        List<String> answer=new ArrayList<>();
        for(int split=1;split<digits.length();split++)for(String left:forms(digits.substring(0,split)))for(String right:forms(digits.substring(split)))answer.add("("+left+", "+right+")");
        return answer;
    }
    private List<String> forms(String part){
        List<String> result=new ArrayList<>();
        if(part.length()==1||part.charAt(0)!='0')result.add(part);
        for(int dot=1;dot<part.length();dot++){
            String integer=part.substring(0,dot),fraction=part.substring(dot);
            if((integer.length()==1||integer.charAt(0)!='0')&&fraction.charAt(fraction.length()-1)!='0')result.add(integer+"."+fraction);
        }
        return result;
    }
}
