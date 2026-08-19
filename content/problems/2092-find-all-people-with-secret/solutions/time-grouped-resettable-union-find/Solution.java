class Solution {
    int[] parent;
    private int find(int value){
        return value==parent[value]?value:(parent[value]=find(parent[value]));
    }
    private void union(int a,int b){
        parent[find(a)]=find(b);
    }
    public List<Integer> findAllPeople(int n,int[][] meetings,int firstPerson){
        Arrays.sort(meetings,Comparator.comparingInt(a->a[2]));
        parent=new int[n];
        for(int i=0;i<n;i++)parent[i]=i;
        union(0,firstPerson);
        for(int index=0;index<meetings.length;){
            int end=index,time=meetings[index][2];
            Set<Integer> participants=new HashSet<>();
            while(end<meetings.length&&meetings[end][2]==time){
                union(meetings[end][0],meetings[end][1]);
                participants.add(meetings[end][0]);
                participants.add(meetings[end][1]);
                end++;
            }
            int root=find(0);
            for(int person:participants)if(find(person)!=root)parent[person]=person;
            index=end;
        }
        List<Integer> answer=new ArrayList<>();
        for(int person=0;person<n;person++)if(find(person)==find(0))answer.add(person);
        return answer;
    }
}
