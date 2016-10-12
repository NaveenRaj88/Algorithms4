package alg.common;

/**
 * Created by Naveen Kumar .A on 10/12/16.
 */
public class Node<Key extends Comparable<Key>, Value> {


    public Key key;
    public Value value;
    public int n;
    public Node<Key, Value> left;
    public Node<Key, Value> right;

    public Node(){

    }

    public Node(Key key, Value value){
        this.key = key;
        this.value = value;
    }

    public Node(Key key, Value value, int n) {
        this.key = key;
        this.value = value;
        this.n = n;
    }
}
