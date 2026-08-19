class Solution {
    public int[] smallestSufficientTeam(String[] reqSkills,List<List<String>> people){
        Map<String,Integer> skill=new HashMap<>();
        for(int i=0;i<reqSkills.length;i++)skill.put(reqSkills[i],i);
        Map<Integer,List<Integer>> dp=new HashMap<>();
        dp.put(0,new ArrayList<>());
        for(int person=0;person<people.size();person++){
            int personMask=0;
            for(String name:people.get(person))personMask|=1<<skill.get(name);
            List<Map.Entry<Integer,List<Integer>>> snapshot=new ArrayList<>(dp.entrySet());
            for(Map.Entry<Integer,List<Integer>> entry:snapshot){
                int next=entry.getKey()|personMask;
                List<Integer> current=dp.get(next);
                if(current==null||current.size()>entry.getValue().size()+1){
                    List<Integer> team=new ArrayList<>(entry.getValue());
                    team.add(person);
                    dp.put(next,team);
                }
            }
        }
        return dp.get((1<<reqSkills.length)-1).stream().mapToInt(Integer::intValue).toArray();
    }
}
