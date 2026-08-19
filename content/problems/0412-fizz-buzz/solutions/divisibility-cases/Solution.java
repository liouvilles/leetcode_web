class Solution {
    public List<String> fizzBuzz(int n){
        List<String> answer=new ArrayList<>();
        for(int value=1;value<=n;value++){
            if(value%15==0)answer.add("FizzBuzz");
            else if(value%3==0)answer.add("Fizz");
            else if(value%5==0)answer.add("Buzz");
            else answer.add(String.valueOf(value));
        }
        return answer;
    }
}
