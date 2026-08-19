class Solution {
    private int[] distances(int[] edges,int start){
        int[] distance=new int[edges.length];
        Arrays.fill(distance,-1);
        for(int steps=0;start!=-1&&distance[start]==-1;steps++){
            distance[start]=steps;
            start=edges[start];
        }
        return distance;
    }
    public int closestMeetingNode(int[] edges,int node1,int node2){
        int[] first=distances(edges,node1),second=distances(edges,node2);
        int answer=-1,best=Integer.MAX_VALUE;
        for(int i=0;i<edges.length;i++)if(first[i]>=0&&second[i]>=0&&Math.max(first[i],second[i])<best){
            best=Math.max(first[i],second[i]);
            answer=i;
        }
        return answer;
    }
}
