class Solution {
    public int[] countPairs(int n,int[][] edges,int[] queries){
        int[] degree=new int[n];
        Map<Long,Integer> multiplicity=new HashMap<>();
        for(int[] edge:edges){
            int a=edge[0]-1,b=edge[1]-1;
            if(a>b){
                int t=a;
                a=b;
                b=t;
            }
            degree[a]++;
            degree[b]++;
            long key=(long)a*n+b;
            multiplicity.put(key,multiplicity.getOrDefault(key,0)+1);
        }
        int[] sorted=degree.clone();
        Arrays.sort(sorted);
        int[] answer=new int[queries.length];
        for(int index=0;index<queries.length;index++){
            int left=0,right=n-1,count=0;
            while(left<right)if(sorted[left]+sorted[right]>queries[index]){
                count+=right-left;
                right--;
            }else left++;
            for(Map.Entry<Long,Integer> entry:multiplicity.entrySet()){
                int a=(int)(entry.getKey()/n),b=(int)(entry.getKey()%n),sum=degree[a]+degree[b];
                if(sum>queries[index]&&sum-entry.getValue()<=queries[index])count--;
            }
            answer[index]=count;
        }
        return answer;
    }
}
