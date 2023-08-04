/*
 * Detect cycle in an Undirected graph using BFS traversal.
 * Approach: 
 * 
 * 1. if two edges converge at a node (the node which is already traversed once)
 *    then we have cycle in the graph
 */
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class cycle_In_Undirected_Graph_BFS {

    public static void main(String[] args) {
        int edges[][] = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 1, 5 } };
        int n = 7;
        int start = 0;
        if (foundCyclebfs(n, edges, start)) {
            System.out.println("Cycle exists in the given grpah");
        } else {
            System.out.println("No cycle exists in the given graph");
        }

    }

    public static boolean foundCyclebfs(int n, int edges[][], int start) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();

        for (int ed[] : edges) {
            adj.computeIfAbsent(ed[0], val -> new ArrayList<>()).add(ed[1]);
            adj.computeIfAbsent(ed[1], val -> new ArrayList<>()).add(ed[0]);
        }
        boolean visited[] = new boolean[7];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { start, -1 }); // [node , parent]

        while (!q.isEmpty()) {
            int[] front = q.poll();

            for (int nei : adj.get(front[0])) {
                if (nei == front[1])
                    continue; // nei == parent ?

                if (visited[nei]) {
                    return true;
                }
                visited[nei] = true;
                q.add(new int[] { nei, front[0] });

            }
        }

        return false;
    }
}
