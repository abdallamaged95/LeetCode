import java.util.*;

public class Solution {
    public List<Integer>[] graph;
    LinkedList[] ans;
    public char[] visited;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

        visited = new char[numCourses];
        Arrays.fill(visited, 'W');

        int[] requires = new int[numCourses];
        // Initializae graph
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
            requires[prerequisites[i][1]] += 1;
        }

        boolean possible = true;
        ans = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            LinkedList<Integer> path = new LinkedList<>();
            Arrays.fill(visited, 'W');

            possible = possible & DFS(i, path);

            if (possible && path.size() == numCourses)
                return to_array(path);
            else if (possible) {
//                path.removeLast();
                ans[i] = path;
            }
            else if (!possible)
                return new int[]{};
        }
        return to_array(construct(numCourses, ans));
    }

    public boolean DFS(int course, LinkedList<Integer> path) {
        if (visited[course] != 'W')
            return (visited[course] == 'B');

        visited[course] = 'G';
        for (int i = 0; i < graph[course].size(); i++) {
            if (ans[graph[course].get(i)] != null && visited[graph[course].get(i)] == 'W') {
                path.addAll(ans[graph[course].get(i)]);
                visited[graph[course].get(i)] = 'B';
            }
            else {
                if (visited[graph[course].get(i)] == 'B')
                    continue;
                else if (!DFS(graph[course].get(i), path))
                    return false;
            }
        }

        visited[course] = 'B';
        path.add(course);
        return true;
    }
    
    public LinkedList<Integer> construct(int numCourses, List<Integer>... path) {
        LinkedList<Integer> arr = new LinkedList<>();
        boolean[] vis = new boolean[numCourses];
        Arrays.fill(vis, false);

        for (int i = 0; i < path.length; i++) {
            Iterator<Integer> it = path[i].iterator();
            while (it.hasNext()) {
                int tmp = it.next();
                if (!vis[tmp]) {
                    arr.add(tmp);
                    vis[tmp] = true;
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                arr.add(i);
                vis[i] = true;
            }
        }
        return arr;
    }
    public int[] to_array(LinkedList<Integer> path) {
        int[] arr = new int[path.size()];
        var it = path.iterator();
        int idx = 0;
        while (it.hasNext()) {
            arr[idx++] = it.next();
        }
        return arr;
    }
}
