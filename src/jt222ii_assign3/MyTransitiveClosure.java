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
        Iterator<Node<E>> itr = dg.iterator();
        while (itr.hasNext())
        {
            Node<E> node = itr.next();
            map.put(node, dfs.dfs(dg, node));
        }
        return map;
    }
}
