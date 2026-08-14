const d=146,n="lru-cache",e="LRU Cache",l="中等",u="链表",t=["哈希表","链表","设计","双向链表"],y=!1,i="https://leetcode.cn/problems/lru-cache/",c="LRU 缓存",a=["哈希表","双向链表","最近使用顺序"],o="设计固定容量的键值缓存，使查询和更新都能在常数时间完成；容量满时淘汰最久未使用的键。",s="哈希表负责按键定位节点，双向链表负责在常数时间移动节点并维护新旧顺序。",r=["读取已有键也会刷新最近使用时间","更新已有键不能增加缓存大小","淘汰节点后必须同步从哈希表删除"],p=[{id:"hash-map-order-list",title:"哈希表 + 最近使用链",kind:"最优",idea:"哈希表定位键，访问顺序链维护从最近到最久的次序；标准库支持时可直接使用访问顺序映射。",steps:["get 命中后把对应节点移动到最近使用端","put 更新已有节点或插入新的最近使用节点","容量超限时删除最久未使用端，并同步清理哈希表"],complexity:{time:"O(1)",space:"O(capacity)"},code:{java:`class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(16, 0.75f, true);
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
        if (cache.size() > capacity) {
            Integer oldest = cache.keySet().iterator().next();
            cache.remove(oldest);
        }
    }
}
`,kotlin:`class LRUCache(private val capacity: Int) {
    private val cache = LinkedHashMap<Int, Int>(16, 0.75f, true)

    fun get(key: Int): Int = cache[key] ?: -1

    fun put(key: Int, value: Int) {
        cache[key] = value
        if (cache.size > capacity) {
            cache.remove(cache.keys.first())
        }
    }
}
`,cpp:`class LRUCache {
    int capacity;
    list<pair<int, int>> order;
    unordered_map<int, list<pair<int, int>>::iterator> positions;

public:
    LRUCache(int capacity) : capacity(capacity) {}

    int get(int key) {
        auto found = positions.find(key);
        if (found == positions.end()) return -1;
        order.splice(order.begin(), order, found->second);
        return found->second->second;
    }

    void put(int key, int value) {
        auto found = positions.find(key);
        if (found != positions.end()) {
            found->second->second = value;
            order.splice(order.begin(), order, found->second);
            return;
        }
        order.push_front({key, value});
        positions[key] = order.begin();
        if ((int)positions.size() > capacity) {
            positions.erase(order.back().first);
            order.pop_back();
        }
    }
};
`}}],f={id:146,slug:n,titleEn:e,difficulty:"中等",category:"链表",officialTags:t,paidOnly:!1,sourceUrl:i,title:c,studyTags:a,summary:o,insight:s,pitfalls:r,solutions:p};export{u as category,f as default,l as difficulty,d as id,s as insight,t as officialTags,y as paidOnly,r as pitfalls,n as slug,p as solutions,i as sourceUrl,a as studyTags,o as summary,c as title,e as titleEn};
