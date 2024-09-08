/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
import java.util.*;
import static java.lang.System.*;
class Solution {
    static public char[] visited;
    static public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        visited = new char[101];
        initArray(visited);
        // showGraph(node);
        Node clone = new Node(1);
        BFS(node, clone);

        // visited = new char[101];
        // initArray(visited);
        // showGraph(clone);


        return clone;
    }

    static public void BFS(Node base, Node clone) {
        Queue<Node> q1 = new LinkedList<Node>();
        Queue<Node> q2 = new LinkedList<Node>();
        q1.add(base);
        q2.add(clone);
        
        while (!q1.isEmpty()) {
            Node curr1 = q1.remove();
            Node curr2 = q2.remove();
            
            if (visited[curr1.val] == 'B')
                continue;
            
            visited[curr1.val] = 'B';
            
            for (Node i : curr1.neighbors) {
                if (visited[i.val] == 'W') {
                    visited[i.val] = 'G';
                    q1.add(i);
                    Node newN = new Node(i.val);
                    curr2.neighbors.add(newN);
                    newN.neighbors.add(curr2);
                    q2.add(newN);
                }
                else if (visited[i.val] == 'G') {
                    Node n = null;
                    for (Node j : q2)
                        if (j.val == i.val) {
                            n = j;
                            break;
                        }
                    if (n != null){
                        curr2.neighbors.add(n);
                        n.neighbors.add(curr2);
                    }
                }
            }
            
        }
    }

    static public void showGraph(Node base) {
        Queue<Node> q = new LinkedList();
        q.add(base);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (visited[curr.val] != 'W')
                continue;
            visited[curr.val] = 'B';
            out.print(curr.val + " : ");
            for (Node i : curr.neighbors) {
                out.print(i.val + " ");
                q.add(i);
            }
            out.println();
        }
    }

    public static void initArray(char[] visited) {
        for (int i = 0; i < visited.length; i++)
            visited[i] = 'W';
    }
}