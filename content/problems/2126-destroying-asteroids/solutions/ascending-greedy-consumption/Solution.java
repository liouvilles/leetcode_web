class Solution {
    public boolean asteroidsDestroyed(int mass,int[] asteroids){
        Arrays.sort(asteroids);
        long current=mass;
        for(int asteroid:asteroids){
            if(current<asteroid)return false;
            current+=asteroid;
        }
        return true;
    }
}
