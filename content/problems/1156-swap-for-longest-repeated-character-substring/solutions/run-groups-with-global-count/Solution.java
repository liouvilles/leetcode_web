class Solution {
    public int maxRepOpt1(String text){
        int[] total=new int[26];
        List<int[]> groups=new ArrayList<>();
        for(char ch:text.toCharArray())total[ch-'a']++;
        for(int i=0;i<text.length();){
            int j=i+1;
            while(j<text.length()&&text.charAt(j)==text.charAt(i))j++;
            groups.add(new int[]{
                text.charAt(i)-'a',j-i
            });
            i=j;
        }
        int best=0;
        for(int i=0;i<groups.size();i++){
            int[] group=groups.get(i);
            best=Math.max(best,Math.min(total[group[0]],group[1]+1));
            if(i+2<groups.size()&&groups.get(i+1)[1]==1&&groups.get(i+2)[0]==group[0])best=Math.max(best,Math.min(total[group[0]],group[1]+groups.get(i+2)[1]+1));
        }
        return best;
    }
}
