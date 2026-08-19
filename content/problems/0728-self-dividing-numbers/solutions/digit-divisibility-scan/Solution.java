class Solution {
    public List<Integer> selfDividingNumbers(int left,int right){
        List<Integer> answer=new ArrayList<>();
        for(int value=left;value<=right;value++)if(valid(value))answer.add(value);
        return answer;
    }
    private boolean valid(int value){
        int remaining=value;
        while(remaining>0){
            int digit=remaining%10;
            if(digit==0||value%digit!=0)return false;
            remaining/=10;
        }
        return true;
    }
}
