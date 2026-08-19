class Solution {
    public int scoreOfStudents(String s,int[] answers){
        int count=(s.length()+1)/2;
        int[] numbers=new int[count];
        char[] operators=new char[count-1];
        for(int i=0;i<count;i++){
            numbers[i]=s.charAt(2*i)-'0';
            if(i+1<count)operators[i]=s.charAt(2*i+1);
        }
        int correct=0,term=numbers[0];
        for(int i=0;i<operators.length;i++)if(operators[i]=='*')term*=numbers[i+1];
        else{
            correct+=term;
            term=numbers[i+1];
        }
        correct+=term;
        Set<Integer>[][] dp=new Set[count][count];
        for(int i=0;i<count;i++){
            dp[i][i]=new HashSet<>();
            dp[i][i].add(numbers[i]);
        }
        for(int length=2;length<=count;length++)for(int left=0;left+length<=count;left++){
            int right=left+length-1;
            dp[left][right]=new HashSet<>();
            for(int split=left;split<right;split++)for(int a:dp[left][split])for(int b:dp[split+1][right]){
                int value=operators[split]=='+'?a+b:a*b;
                if(value<=1000)dp[left][right].add(value);
            }
        }
        int score=0;
        for(int answer:answers)score+=answer==correct?5:dp[0][count-1].contains(answer)?2:0;
        return score;
    }
}
