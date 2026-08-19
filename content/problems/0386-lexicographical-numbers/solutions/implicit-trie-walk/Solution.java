class Solution {
    public List<Integer> lexicalOrder(int n){
        List<Integer> answer=new ArrayList<>(n);
        int current=1;
        for(int count=0;count<n;count++){
            answer.add(current);
            if((long)current*10<=n)current*=10;
            else{
                while(current%10==9||current+1>n)current/=10;
                current++;
            }
        }
        return answer;
    }
}
