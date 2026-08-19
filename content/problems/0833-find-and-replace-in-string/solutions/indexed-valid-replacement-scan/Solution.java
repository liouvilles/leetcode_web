class Solution {
    public String findReplaceString(String s,int[] indices,String[] sources,String[] targets){
        Map<Integer,Integer> operations=new HashMap<>();
        for(int i=0;i<indices.length;i++)if(s.startsWith(sources[i],indices[i]))operations.put(indices[i],i);
        StringBuilder answer=new StringBuilder();
        for(int i=0;i<s.length();){
            Integer operation=operations.get(i);
            if(operation==null)answer.append(s.charAt(i++));
            else{
                answer.append(targets[operation]);
                i+=sources[operation].length();
            }
        }
        return answer.toString();
    }
}
