class Solution {
    public String[] findRestaurant(String[] list1,String[] list2){
        Map<String,Integer> indices=new HashMap<>();
        for(int i=0;i<list1.length;i++)indices.put(list1[i],i);
        List<String> answer=new ArrayList<>();
        int best=Integer.MAX_VALUE;
        for(int i=0;i<list2.length;i++){
            Integer first=indices.get(list2[i]);
            if(first==null)continue;
            int sum=first+i;
            if(sum<best){
                best=sum;
                answer.clear();
                answer.add(list2[i]);
            }else if(sum==best)answer.add(list2[i]);
        }
        return answer.toArray(new String[0]);
    }
}
