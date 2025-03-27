
import java.util.*;
import java.lang.*;
import java.io.*;

// ------------------------------------------------------------------   time complexity is O(N+2M) ----------------------------------------------------------------------------------------------

class Pair{
    int node;
    int dist;
    
    Pair(int n,int d){
        this.node=n;
        this.dist=d;
    }
}

class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src){
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        Queue<Pair>pq=new LinkedList<>();
        
        int distance[]=new int[n];
        for(int i=0;i<n;i++){
            distance[i]=(int)1e9;
        }
        
        
        
        pq.add(new Pair(src,0));
        distance[src]=0;
        
        while(!pq.isEmpty()){
            Pair x=pq.poll();
            int nd=x.node;
            int dt=x.dist;
            
            for(int it:adj.get(nd)){
                if(distance[nd]+1<distance[it]){
                    distance[it]=distance[nd]+1;
                    pq.add(new Pair(it,distance[nd]+1));
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(distance[i]==(int)1e9){
                distance[i]=-1;
            }
        }
        
        
        return distance;
        
        
    }
}


public class Main
{
	public static void main(String[] args) {
	    int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
          
        Solution obj = new Solution();
        int res[] = obj.shortestPath(edge,n,m,0);
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
	}
}



