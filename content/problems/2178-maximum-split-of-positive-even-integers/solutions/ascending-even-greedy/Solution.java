class Solution {
    public List<Long> maximumEvenSplit(long finalSum){
        List<Long> answer=new ArrayList<>();
        if((finalSum&1)==1)return answer;
        for(long next=2;finalSum>=next;next+=2){
            answer.add(next);
            finalSum-=next;
        }
        if(!answer.isEmpty())answer.set(answer.size()-1,answer.get(answer.size()-1)+finalSum);
        return answer;
    }
}
