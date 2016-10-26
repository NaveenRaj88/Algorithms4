package com.chap04.sec4_1;

import com.chap01.sec1_3.Queue;
import com.util.In;

/**
 * Created by Naveen Kumar .A on 10/23/16.
 */
public class BreadthFirstSearch {

    private boolean[] marked;
    private int count;

    public BreadthFirstSearch(Graph g, int s){
        marked = new boolean[g.v()];
        bfs(g,s);
    }

    private void bfs(Graph g, int s){
        Queue<Integer> path = new Queue<>();
        path.enqueue(s);
        marked[s]=true;
        count++;
        while(!path.isEmpty()){
            int v = path.dequeue();
            for(int x : g.adj(v)){
                if(!marked[x]){
                    path.enqueue(x);
                    marked[x] = true;
                    count++;
                }
            }
        }
    }

    public int count(){
        return count;
    }

    public static void main(String[] args) {
        In in = new In("resources/tinyCG.txt");
        Graph g = new Graph(in);
        BreadthFirstSearch bfs = new BreadthFirstSearch(g, 0);
        System.out.println(bfs.count);
    }
}
