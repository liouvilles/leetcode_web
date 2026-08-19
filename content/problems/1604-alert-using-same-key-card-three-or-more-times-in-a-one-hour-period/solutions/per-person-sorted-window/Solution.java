class Solution {
    public List<String> alertNames(String[] keyName,String[] keyTime){
        Map<String,List<Integer>> times=new HashMap<>();
        for(int i=0;i<keyName.length;i++){
            String[] part=keyTime[i].split(":");
            int minute=Integer.parseInt(part[0])*60+Integer.parseInt(part[1]);
            times.computeIfAbsent(keyName[i],key->new ArrayList<>()).add(minute);
        }
        List<String> answer=new ArrayList<>();
        for(Map.Entry<String,List<Integer>> entry:times.entrySet()){
            List<Integer> values=entry.getValue();
            Collections.sort(values);
            for(int i=0;i+2<values.size();i++)if(values.get(i+2)-values.get(i)<=60){
                answer.add(entry.getKey());
                break;
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
