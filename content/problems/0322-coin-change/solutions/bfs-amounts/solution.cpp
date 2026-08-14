class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if (amount == 0) return 0;
        vector<bool> visited(amount + 1);
        queue<int> values;
        values.push(0); visited[0] = true;
        int used = 0;
        while (!values.empty()) {
            ++used;
            for (int size = values.size(); size > 0; --size) {
                int current = values.front(); values.pop();
                for (int coin : coins) {
                    int next = current + coin;
                    if (next == amount) return used;
                    if (next < amount && !visited[next]) {
                        visited[next] = true;
                        values.push(next);
                    }
                }
            }
        }
        return -1;
    }
};
