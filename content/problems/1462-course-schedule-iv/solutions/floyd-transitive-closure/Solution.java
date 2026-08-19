class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses,int[][] prerequisites,int[][] queries){
        boolean[][] reach=new boolean[numCourses][numCourses];
        for(int[] edge:prerequisites)reach[edge[0]][edge[1]]=true;
        for(int middle=0;middle<numCourses;middle++)for(int from=0;from<numCourses;from++)if(reach[from][middle])for(int to=0;to<numCourses;to++)reach[from][to]|=reach[middle][to];
        List<Boolean> answer=new ArrayList<>();
        for(int[] query:queries)answer.add(reach[query[0]][query[1]]);
        return answer;
    }
}
