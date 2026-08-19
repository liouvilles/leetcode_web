class Solution {
    public List<String> topKFrequent(String[] words,int k){
        Map<String,Integer> counts=new HashMap<>();
        for(String word:words)counts.put(word,counts.getOrDefault(word,0)+1);
        List<String> unique=new ArrayList<>(counts.keySet());
        unique.sort((a,b)->!counts.get(a).equals(counts.get(b))?Integer.compare(counts.get(b),counts.get(a)):a.compareTo(b));
        return new ArrayList<>(unique.subList(0,k));
    }
}
