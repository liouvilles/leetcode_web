class Solution {
    private List<Integer> occurrences(String text,String pattern){
        int m=pattern.length();
        int[] prefix=new int[m];
        for(int i=1,j=0;i<m;i++){
            while(j>0&&pattern.charAt(i)!=pattern.charAt(j))j=prefix[j-1];
            if(pattern.charAt(i)==pattern.charAt(j))j++;
            prefix[i]=j;
        }
        List<Integer> positions=new ArrayList<>();
        for(int i=0,j=0;i<text.length();i++){
            while(j>0&&text.charAt(i)!=pattern.charAt(j))j=prefix[j-1];
            if(text.charAt(i)==pattern.charAt(j))j++;
            if(j==m){
                positions.add(i-m+1);
                j=prefix[j-1];
            }
        }
        return positions;
    }
    public List<Integer> beautifulIndices(String s,String a,String b,int k){
        List<Integer> first=occurrences(s,a),second=occurrences(s,b),answer=new ArrayList<>();
        int pointer=0;
        for(int index:first){
            while(pointer<second.size()&&second.get(pointer)<index-k)pointer++;
            if(pointer<second.size()&&second.get(pointer)<=index+k)answer.add(index);
        }
        return answer;
    }
}
