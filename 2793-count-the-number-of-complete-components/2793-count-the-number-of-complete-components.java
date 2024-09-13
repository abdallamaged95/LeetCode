import java.util.*;

class Solution {
    List<Integer>[] graph;
    char[] visited;
    public int countCompleteComponents(int n, int[][] edges) {
        visited = new char[n];
        Arrays.fill(visited, 'W');

        graph = new List[n];
        // init graph
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++)
            if (visited[i] == 'W') {
                if (BFS(i))
                    cnt++;
            }

        return cnt;
    }

    public boolean BFS(int vrtx) {
        List<Integer> nodes = new ArrayList<>();
        int edgesCnt = 0, nodesCnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(vrtx);
        while (!q.isEmpty()) {
            int curr = q.remove();
            visited[curr] = 'B';
            nodesCnt++;
            nodes.add(curr);
            for (int i = 0; i < graph[curr].size(); i++) {
                if (visited[graph[curr].get(i)] == 'W') {
                    q.add(graph[curr].get(i));
                    visited[graph[curr].get(i)] = 'G';
                    edgesCnt++;
                }
                else if (visited[graph[curr].get(i)] == 'G')
                    edgesCnt++;
            }
        }

//        if (edgesCnt == ((nodesCnt-1) * nodesCnt) / 2)
//            return true;
//        else if (nodesCnt == 2 && edgesCnt == 1)
//            return true;
//        else if (nodesCnt == 1 && edgesCnt == 0)
//            return true;
        boolean flag = true;
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.size() && j != i; j++) {
                if (!graph[nodes.get(i)].contains(nodes.get(j)))
                    flag = false;
            }
        }

        return flag;
    }

}