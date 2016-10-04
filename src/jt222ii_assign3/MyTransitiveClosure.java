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
        MyDFS dfs = new MyDFS();
        Map<Node<E>, Collection<Node<E>>> map = new HashMap<>();
        for (E item:dg.allItems())
        {
            Node<E> node = dg.getNodeFor(item);
            List<Node<E>> tempList = dfs.dfs(dg, node);
            map.put(node, tempList);
        }
        return map;
    }
}
