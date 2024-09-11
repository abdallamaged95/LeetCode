import java.util.*;

public class Solution {
    public List<Integer>[] graph;
    public char[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

        visited = new char[numCourses];
        Arrays.fill(visited, 'W');

        int[] requires = new int[numCourses];
        // Initializae graph
        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][0] == prerequisites[i][1])
                return false;

            graph[prerequisites[i][0]].add(prerequisites[i][1]);
            requires[prerequisites[i][1]] += 1;
        }

        for (int i = 0; i < numCourses; i++) {
            if (!DFS(i))
                return false;
        }
        return true;
    }

    public boolean DFS(int course) {
        if (visited[course] != 'W')
            return (visited[course] == 'B');

        visited[course] = 'G';
        for (int i = 0; i < graph[course].size(); i++) {
            boolean f = DFS(graph[course].get(i));
            if (f == false)
                return false;
        }
        visited[course] = 'B';
        return true;
    }
}
