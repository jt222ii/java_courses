package jt222ii_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by jonastornfors on 2016-09-27.
 */
public class MyTransitiveClosure<E> implements graphs.TransitiveClosure<E> {


    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg)
    {
        MyDFS<E> dfs = new MyDFS<>();
        Map<Node<E>, Collection<Node<E>>> map = new HashMap<>();
        for (Node<E> node : dg) //foreach node in the graph..
        {
            map.put(node, dfs.dfs(dg, node));//...put the result of dfs, using the graph and node with node as key, to the map.
        }
        return map;//return the map
    }
}
