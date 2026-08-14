class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        boolean[] visited = new boolean[amount + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0); visited[0] = true;
        int used = 0;
        while (!queue.isEmpty()) {
            used++;
            for (int size = queue.size(); size > 0; size--) {
                int current = queue.poll();
                for (int coin : coins) {
                    int next = current + coin;
                    if (next == amount) return used;
                    if (next < amount && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }
}
