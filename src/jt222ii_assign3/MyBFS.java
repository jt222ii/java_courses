package jt222ii_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by jonastornfors on 2016-09-27.
 */
public class MyBFS<E> implements graphs.BFS<E> {

    private ArrayList<Node<E>> list = new ArrayList<>();
    private Set<Node<E>> visited = new HashSet<>();
    /**
     * Returns the nodes visited by a breadth-first search starting from
     * the given root node. Each visited node is also attached with
     * a breadth-first number.
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
        list.clear();
        visited.clear();
        Set<Node<E>> set = new LinkedHashSet<>();
        set.add(root);
        bfs(set);
        return list;
    }

    /**
     * Returns the nodes visited by a breadth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a breadth-first number.
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph) {
        list.clear();
        visited.clear();
        Set<Node<E>> set = new HashSet<>();
        if(graph.headCount() != 0)
        {
            Iterator<Node<E>> headItr = graph.heads();
            while(headItr.hasNext())
            {
                set.add(headItr.next());
            }
        }
        else
        {
            set.add(graph.getNodeFor(graph.allItems().get(0)));
        }
        bfs(set);
        return list;
    }

    public void bfs(Set<Node<E>> set)
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
            if(!visited.contains(node))
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
        bfs(set);
    }
}
