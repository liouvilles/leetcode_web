class Solution {
    fun asteroidCollision(asteroids:IntArray):IntArray{
        val stack=mutableListOf<Int>();
        for(asteroid in asteroids){
            var alive=true;
            while(alive&&asteroid<0&&stack.isNotEmpty()&&stack.last()>0){
                val top=stack.last();
                if(top< -asteroid)stack.removeAt(stack.lastIndex)else{
                    if(top== -asteroid)stack.removeAt(stack.lastIndex);
                    alive=false
                }
            };
            if(alive)stack.add(asteroid)
        };
        return stack.toIntArray()
    }
}
