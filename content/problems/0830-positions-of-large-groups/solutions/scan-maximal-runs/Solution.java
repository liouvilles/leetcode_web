class Solution {
    public List<List<Integer>> largeGroupPositions(String s){
        List<List<Integer>> answer=new ArrayList<>();
        for(int start=0;start<s.length();){
            int end=start+1;
            while(end<s.length()&&s.charAt(end)==s.charAt(start))end++;
            if(end-start>=3)answer.add(Arrays.asList(start,end-1));
            start=end;
        }
        return answer;
    }
}
