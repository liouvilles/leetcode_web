class LRUCache {
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
