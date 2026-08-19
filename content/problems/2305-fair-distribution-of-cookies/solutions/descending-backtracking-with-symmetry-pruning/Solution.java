class Solution {
    int[] cookies,loads;
    int best;
    private void search(int index,int current){
        if(current>=best)return;
        if(index==cookies.length){
            best=current;
            return;
        }
        Set<Integer> seen=new HashSet<>();
        for(int i=0;i<loads.length;i++){
            if(!seen.add(loads[i]))continue;
            int before=loads[i];
            loads[i]+=cookies[index];
            search(index+1,Math.max(current,loads[i]));
            loads[i]=before;
            if(before==0)break;
        }
    }
    public int distributeCookies(int[] cookies,int k){
        Arrays.sort(cookies);
        this.cookies=new int[cookies.length];
        for(int i=0;i<cookies.length;i++)this.cookies[i]=cookies[cookies.length-1-i];
        loads=new int[k];
        best=Integer.MAX_VALUE;
        search(0,0);
        return best;
    }
}
