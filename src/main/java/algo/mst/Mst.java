package algo.mst;

import java.util.Enumeration;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;

public class Mst {

    static class Edge implements Comparable<Edge>{
        int a,b;
        int distance;
        Edge(int a,int b,int distance){
            this.a=a;
            this.b=b;
            this.distance=distance;
        }
        public int compareTo(Edge edge){
            return this.distance-edge.distance;

        }

        boolean contains(int i){
            return i==a||i==b;
        }
    }


    static boolean isCycle(int[] visited,Edge e){
        return visited[e.a]==1&&visited[e.b]==1;
    }

    static int find(int[] parent,int i){
        if(parent[i]!=i){
            return find(parent,parent[i]);
        }
        return i;
    }



    public static int minCostConnectPoints(int[][] points) {


        Queue<Edge> q = new PriorityQueue<>();
        int[] parent = new int[points.length];
        //setup
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                q.add(new Edge(i,j,Math.abs(points[i][0]-points[j][0])+
                        Math.abs(points[i][1]-points[j][1])));
            }
            parent[i]=i;

        }
        int count =0;
        int minDistance =0;
        while(!q.isEmpty()&&count<points.length-1){
            Edge e = q.poll();
            int setA=find(parent,e.a);
            int setB = find(parent,e.b);
            if(setA!=setB){
                parent[setA]=setB;
                count++;
                minDistance+=e.distance;
            }
        }
        if(count!=points.length-1)
            return -1;
        else
            return minDistance;

    }

    public static void main(String[] args) {
       int[][] points =new int[][]{{2,-3},{-17,-8},{13,8},{-17,-15}};

        int res = Stream.of(1,2,9).reduce(0, Integer::sum);
        System.out.println(res);
       // System.out.println(minCostConnectPoints(points));

    }
}
