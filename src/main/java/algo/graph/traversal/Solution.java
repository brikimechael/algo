package algo.graph.traversal;

//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {

int flag =0;
    void dfs(int[] visited, int node, ArrayList<ArrayList<Integer>> adj, Set<Integer> visitedEdges) {
        visited[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) {
                visitedEdges.add(node * adj.size() + neighbor);
                visitedEdges.add(neighbor * adj.size() + node);
                dfs(visited, neighbor, adj, visitedEdges);
            } else if (!visitedEdges.contains(node * adj.size() + neighbor)) {
                flag = 1;
                return;
            }
        }
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        flag=0;
        int[] visited = new int[V];
        Set<Integer> visitedEdges = new HashSet<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0 && flag != 1) {
                dfs(visited, i, adj, visitedEdges);
            }
        }

        return flag == 1;
    }
}