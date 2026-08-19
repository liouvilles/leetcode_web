class AuthenticationManager(private val timeToLive:Int) {
    private val expiry=mutableMapOf<String,Int>();
    fun generate(tokenId:String,currentTime:Int){
        expiry[tokenId]=currentTime+timeToLive
    };
    fun renew(tokenId:String,currentTime:Int){
        if((expiry[tokenId]?:0)>currentTime)expiry[tokenId]=currentTime+timeToLive
    };
    fun countUnexpiredTokens(currentTime:Int):Int=expiry.values.count{
        it>currentTime
    }
}
