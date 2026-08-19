class Solution {
    public boolean areSentencesSimilar(String sentence1,String sentence2){
        String[] first=sentence1.split(" "),second=sentence2.split(" ");
        if(first.length>second.length){
            String[] temp=first;
            first=second;
            second=temp;
        }
        int prefix=0;
        while(prefix<first.length&&first[prefix].equals(second[prefix]))prefix++;
        int suffix=0;
        while(prefix+suffix<first.length&&first[first.length-1-suffix].equals(second[second.length-1-suffix]))suffix++;
        return prefix+suffix==first.length;
    }
}
