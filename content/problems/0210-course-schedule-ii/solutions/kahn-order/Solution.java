class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(); for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses]; for (int[] edge : prerequisites) { graph.get(edge[1]).add(edge[0]); indegree[edge[0]]++; }
        Queue<Integer> queue = new ArrayDeque<>(); for (int course = 0; course < numCourses; course++) if (indegree[course] == 0) queue.offer(course);
        int[] order = new int[numCourses]; int count = 0;
        while (!queue.isEmpty()) { int course = queue.poll(); order[count++] = course; for (int next : graph.get(course)) if (--indegree[next] == 0) queue.offer(next); }
        return count == numCourses ? order : new int[0];
    }
}
