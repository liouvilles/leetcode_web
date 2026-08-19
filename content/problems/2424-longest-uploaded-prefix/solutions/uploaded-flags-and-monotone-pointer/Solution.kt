class LUPrefix(n:Int){
    private val uploaded=BooleanArray(n+2);
    private var prefix=0;
    fun upload(video:Int){
        uploaded[video]=true;
        while(uploaded[prefix+1])prefix++
    }
    fun longest()=prefix
}
