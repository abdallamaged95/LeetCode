import java.util.*;

public class Solution {
    public List<Integer>[] graph;
    public List<Integer> path;
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
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            path = new ArrayList<>();
            Arrays.fill(visited, 'W');
            possible = possible & DFS(i);
            if (possible && path.size() == numCourses)
                return to_array(path);
            else if (possible) {
                path.remove(path.size()-1);
                ans.add(path);
            }
        }
        if (possible)
            return to_array(construct(numCourses, ans.toArray(new List[0])));
        return new int[]{};
    }

    public boolean DFS(int course) {
        if (visited[course] != 'W')
            return (visited[course] == 'B');

        visited[course] = 'G';
        for (int i = 0; i < graph[course].size(); i++)
            if (!DFS(graph[course].get(i)))
                return false;

        visited[course] = 'B';
        path.add(course);
        return true;
    }
    public List<Integer> construct(int numCourses, List<Integer>... path) {
        List<Integer> arr = new ArrayList<>();
        boolean[] vis = new boolean[numCourses];
        Arrays.fill(vis, false);
        for (int idx = 0; idx < numCourses; idx++) {
            for (int i = 0; i < numCourses; i++) {
                if (idx < path[i].size() && !vis[path[i].get(idx)]) {
                    arr.add(path[i].get(idx));
                    vis[path[i].get(idx)] = true;
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
    public int[] to_array(List<Integer> path) {
        int[] arr = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            arr[i] = path.get(i);
        }
        return arr;
    }
}
