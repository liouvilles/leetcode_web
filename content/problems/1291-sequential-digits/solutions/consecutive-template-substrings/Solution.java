class Solution {
    public List<Integer> sequentialDigits(int low,int high){
        String digits="123456789";
        List<Integer> answer=new ArrayList<>();
        for(int length=String.valueOf(low).length();length<=String.valueOf(high).length();length++)for(int start=0;start+length<=9;start++){
            int value=Integer.parseInt(digits.substring(start,start+length));
            if(value>=low&&value<=high)answer.add(value);
        }
        return answer;
    }
}
