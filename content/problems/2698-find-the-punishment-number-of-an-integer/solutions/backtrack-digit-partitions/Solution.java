class Solution {
    private boolean canSplit(String digits,int index,int sum,int target){
        if(index==digits.length())return sum==target;
        int number=0;
        for(int end=index;end<digits.length();end++){
            number=number*10+digits.charAt(end)-'0';
            if(sum+number>target)break;
            if(canSplit(digits,end+1,sum+number,target))return true;
        }
        return false;
    }
    public int punishmentNumber(int n){
        int answer=0;
        for(int value=1;value<=n;value++){
            int square=value*value;
            if(canSplit(String.valueOf(square),0,0,value))answer+=square;
        }
        return answer;
    }
}
