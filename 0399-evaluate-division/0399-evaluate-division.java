import java.util.*;

import static java.lang.System.*;
class Solution {
    public static class Pair<I, J> implements Comparable<Pair<I, J>> {
        I x;
        J y;
    
        public Pair(Object x, Object y)
        {
            this.x = (I)x;
            this.y = (J)y;
        }
    
        @Override
        public String toString() {
            return "(%s, %s)".formatted(x, y);
        }
    
        @Override public int compareTo(Pair a)
        {
            // if the string are not equal
            // return this.x.compareTo(a.x);
            return 0;
        }
    }

    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries)
    {
        
        Map<String, List<Pair<String, Double>>> graph = new HashMap();

        // initialize graph
        for (int i = 0; i < equations.size(); i++)
        {
            if (!graph.containsKey(equations.get(i).get(0)))
                graph.put(equations.get(i).get(0), new ArrayList<Pair<String, Double>>());
            graph.get(equations.get(i).get(0)).add(new Pair(equations.get(i).get(1), values[i]));

            if (!graph.containsKey(equations.get(i).get(1)))
                graph.put(equations.get(i).get(1), new ArrayList<Pair<String, Double>>());
            graph.get(equations.get(i).get(1)).add(new Pair(equations.get(i).get(0), 1/values[i]));
        }
        
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) 
        {
            ans[i] = BFS(graph, queries.get(i).get(0), queries.get(i).get(1));
            if (ans[i] != -1)
            {
                graph.get(queries.get(i).get(0)).add(new Pair(queries.get(i).get(1), (double)ans[i]));
                graph.get(queries.get(i).get(1)).add(new Pair(queries.get(i).get(0), 1/ans[i]));
            }
        }
        
        return ans;
    }

    public double BFS(Map<String, List<Pair<String, Double>>> graph, String start, String end) 
    {
        if (!graph.containsKey(start) || !graph.containsKey(end))
            return -1;

        Map<String, Boolean> visited = new HashMap();
        Queue<Pair<String, Double>> q = new LinkedList();
        q.add(new Pair<String, Double>(start, (double)1));

        while (!q.isEmpty()) 
        {
            var curr = q.poll();
            if (curr.x.equals(end))
                return curr.y;
            
            visited.put(curr.x, true);

            for (Pair<String, Double> p : graph.get(curr.x))
                if (!visited.containsKey(p.x) || !visited.get(p.x))
                    q.add(new Pair(p.x, p.y * curr.y));
        }
        return -1;
    }
}