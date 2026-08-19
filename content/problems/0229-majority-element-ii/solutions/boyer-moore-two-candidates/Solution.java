class Solution {
    public List<Integer> majorityElement(int[] nums){
        int first=0,second=1,count1=0,count2=0;
        for(int value:nums){
            if(value==first)count1++;
            else if(value==second)count2++;
            else if(count1==0){
                first=value;
                count1=1;
            }else if(count2==0){
                second=value;
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        count1=count2=0;
        for(int value:nums){
            if(value==first)count1++;
            else if(value==second)count2++;
        }
        List<Integer> answer=new ArrayList<>();
        if(count1>nums.length/3)answer.add(first);
        if(count2>nums.length/3)answer.add(second);
        Collections.sort(answer);
        return answer;
    }
}
