class Solution {
    public String truncateSentence(String sentence,int k){
        String[] words=sentence.split(" ");
        return String.join(" ",Arrays.copyOf(words,k));
    }
}
