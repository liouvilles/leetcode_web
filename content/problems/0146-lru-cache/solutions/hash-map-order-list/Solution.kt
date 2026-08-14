class LRUCache(private val capacity: Int) {
    private val cache = LinkedHashMap<Int, Int>(16, 0.75f, true)

    fun get(key: Int): Int = cache[key] ?: -1

    fun put(key: Int, value: Int) {
        cache[key] = value
        if (cache.size > capacity) {
            cache.remove(cache.keys.first())
        }
    }
}
