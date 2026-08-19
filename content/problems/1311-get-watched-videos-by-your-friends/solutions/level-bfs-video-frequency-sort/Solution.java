class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos,int[][] friends,int id,int level){
        Queue<Integer> queue=new ArrayDeque<>();
        boolean[] seen=new boolean[friends.length];
        queue.offer(id);
        seen[id]=true;
        while(level-->0)for(int size=queue.size();size>0;size--){
            int person=queue.poll();
            for(int next:friends[person])if(!seen[next]){
                seen[next]=true;
                queue.offer(next);
            }
        }
        Map<String,Integer> frequency=new HashMap<>();
        while(!queue.isEmpty())for(String video:watchedVideos.get(queue.poll()))frequency.merge(video,1,Integer::sum);
        List<String> answer=new ArrayList<>(frequency.keySet());
        answer.sort((a,b)->frequency.get(a).equals(frequency.get(b))?a.compareTo(b):frequency.get(a)-frequency.get(b));
        return answer;
    }
}
