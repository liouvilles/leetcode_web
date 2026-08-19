class Solution {
    public List<Integer> circularPermutation(int n,int start){
        List<Integer> answer=new ArrayList<>();
        for(int i=0;i<(1<<n);i++)answer.add(start^(i^(i>>1)));
        return answer;
    }
}
