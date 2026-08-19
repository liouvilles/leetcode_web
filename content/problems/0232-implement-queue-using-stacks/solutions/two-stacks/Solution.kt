class MyQueue {
    private val input=ArrayDeque<Int>();
    private val output=ArrayDeque<Int>();
    fun push(x:Int){
        input.addLast(x)
    }
    private fun move(){
        if(output.isEmpty())while(input.isNotEmpty())output.addLast(input.removeLast())
    }
    fun pop():Int{
        move();
        return output.removeLast()
    }
    fun peek():Int{
        move();
        return output.last()
    }
    fun empty():Boolean=input.isEmpty()&&output.isEmpty()
}
