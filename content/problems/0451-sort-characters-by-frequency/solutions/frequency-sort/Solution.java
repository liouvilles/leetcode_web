class Solution {
    public String frequencySort(String s){
        int[] counts=new int[128];
        List<Integer> chars=new ArrayList<>();
        for(char c:s.toCharArray())counts[c]++;
        for(int c=0;c<counts.length;c++)if(counts[c]>0)chars.add(c);
        chars.sort((a,b)->counts[a]!=counts[b]?Integer.compare(counts[b],counts[a]):Integer.compare(a,b));
        StringBuilder answer=new StringBuilder();
        for(int c:chars)for(int i=0;i<counts[c];i++)answer.append((char)c);
        return answer.toString();
    }
}
