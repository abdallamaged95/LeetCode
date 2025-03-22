class Solution {
    public static int countCompleteComponents(int n, int[][] edges) {
        char[] visited = new char[n];
        for (int i = 0; i < n; i++)
            visited[i] = 'w';
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++)
            graph.put(i, new ArrayList<>());
        for (int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        int count = 0;
        for (int i = 0; i < n; i++)
            if (visited[i] == 'w') {
                if (BFS(graph, visited, i))
                    count++;
            }

        return count;
    }
    public static boolean BFS(Map<Integer, List<Integer>> graph, char[] visited, int vrtx){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(vrtx);
//        visited[vrtx] = 'b';
        int vertices = 0;
        int edges = 0;
        while(!queue.isEmpty()) {
            var curr = queue.poll();
            visited[curr] = 'b';
            vertices++;
            for (Integer i : graph.get(curr)) {
                if(visited[i] == 'w') {
                    visited[i] = 'g';
                    queue.add(i);
                    edges++;
                }
                else if(visited[i] == 'g')
                    edges++;
            }
        }
        return ((vertices*(vertices-1)/2) == edges);
    }
}