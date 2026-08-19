class Solution {
    public int minDeletions(String text){
        int[] frequency=new int[26];
        for(char letter:text.toCharArray())frequency[letter-'a']++;
        Set<Integer> used=new HashSet<>();
        int deletions=0;
        for(int count:frequency){
            while(count>0&&used.contains(count)){
                count--;
                deletions++;
            }
            if(count>0)used.add(count);
        }
        return deletions;
    }
}
