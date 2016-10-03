package jt222ii_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by jonastornfors on 2016-09-27.
 */
public class MyBFS<E> implements graphs.BFS<E> {
    /**
     * Returns the nodes visited by a breadth-first search starting from
     * the given root node. Each visited node is also attached with
     * a breadth-first number.
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
        ArrayList<Node<E>> visited = new ArrayList<>();
        ArrayList<Node<E>> list = new ArrayList<>();
        Set<Node<E>> set = new LinkedHashSet<>();
        set.add(root);
        bfs(set, list, visited);
        return list;
    }

    /**
     * Returns the nodes visited by a breadth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a breadth-first number.
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph) {
        ArrayList<Node<E>> visited = new ArrayList<>();
        ArrayList<Node<E>> list = new ArrayList<>();
        Set<Node<E>> set = new LinkedHashSet<>();
        for (E item:graph.allItems()) {
            set.add(graph.getNodeFor(item));
        }
        bfs(set, list, visited);
        return list;
    }

    public void bfs(Set<Node<E>> set, ArrayList<Node<E>> list, ArrayList<Node<E>> visited)
    {
        if(set.isEmpty())
        {
            return;
        }
        Iterator<Node<E>> itr = set.iterator();
        set = new LinkedHashSet<>();
        while (itr.hasNext())
        {
            Node<E> node = itr.next();
            if(!list.contains(node))
            {
                visited.add(node);
                node.num = list.size();
                list.add(node);
            }
            Iterator<Node<E>> successors = node.succsOf();
            while(successors.hasNext())
            {
                Node<E> n = successors.next();
                if(!visited.contains(n))
                {
                    set.add(n);
                }
            }
        }
        bfs(set, list, visited);
    }
}
