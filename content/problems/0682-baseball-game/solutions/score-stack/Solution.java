class Solution {
    public int calPoints(String[] operations){
        List<Integer> scores=new ArrayList<>();
        for(String operation:operations){
            if(operation.equals("C"))scores.remove(scores.size()-1);
            else if(operation.equals("D"))scores.add(scores.get(scores.size()-1)*2);
            else if(operation.equals("+"))scores.add(scores.get(scores.size()-1)+scores.get(scores.size()-2));
            else scores.add(Integer.parseInt(operation));
        }
        int total=0;
        for(int score:scores)total+=score;
        return total;
    }
}
