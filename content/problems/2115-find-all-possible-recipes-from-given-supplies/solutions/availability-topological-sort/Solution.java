class Solution {
    public List<String> findAllRecipes(String[] recipes,List<List<String>> ingredients,String[] supplies){
        Map<String,List<Integer>> dependents=new HashMap<>();
        int[] missing=new int[recipes.length];
        for(int i=0;i<recipes.length;i++){
            missing[i]=ingredients.get(i).size();
            for(String ingredient:ingredients.get(i))dependents.computeIfAbsent(ingredient,ignored->new ArrayList<>()).add(i);
        }
        Queue<String> queue=new ArrayDeque<>(Arrays.asList(supplies));
        List<String> answer=new ArrayList<>();
        while(!queue.isEmpty()){
            String item=queue.poll();
            for(int recipe:dependents.getOrDefault(item,Collections.emptyList()))if(--missing[recipe]==0){
                answer.add(recipes[recipe]);
                queue.offer(recipes[recipe]);
            }
        }
        return answer;
    }
}
