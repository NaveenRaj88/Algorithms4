package com.chap04.sec4_2;

import com.chap01.sec1_3.Queue;
import com.chap01.sec1_3.Stack;

/**
 * Created by Naveen Kumar .A on 8/20/16.
 */
public class DepthFirstOrder {

    private boolean[] marked;
    private Queue<Integer> preOrder;
    private Queue<Integer> postOrder;
    private Stack<Integer> reversePostOrder;

    public DepthFirstOrder(DiGraph g) {
        preOrder = new Queue<>();
        postOrder = new Queue<>();
        reversePostOrder = new Stack<>();
        marked = new boolean[g.v()];

        for (int i = 0; i < g.v(); i++) {
            if (!marked[i]) {
                dfs(g, i);
            }
        }
    }

    public void dfs(DiGraph g, int v) {
        preOrder.enqueue(v);

        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
        postOrder.enqueue(v);
        reversePostOrder.push(v);
    }

    public Iterable<Integer> pre() {
        return preOrder;
    }

    public Iterable<Integer> post() {
        return postOrder;
    }

    public Iterable<Integer> reversePost() {
        return reversePostOrder;
    }
}
