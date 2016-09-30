package jt222ii_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by jonastornfors on 2016-09-27.
 */
public class MyDFS<E> implements graphs.DFS<E> {

    /**
     * Returns the nodes visited by a depth first search starting from
     * the given root node. Each visited node is also attached with
     * a depth-first number.
     */
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root)
    {
        ArrayList<Node<E>> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    /**
     * Returns the nodes visited by a depth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a depth-first number.
     */
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph)
    {
        ArrayList<Node<E>> list = new ArrayList<>();
        for (E item:graph.allItems()) {
            dfs(graph.getNodeFor(item), list);
        }
        return list;
    }

    /**
     * Returns a list of nodes ordered as
     * post-order of the depth first tree resulting from a
     * depth first search starting at the given root node.
     * Notice, it only visits nodes reachable from given
     * root node.
     * </p>
     * The algorithm also attaches a post-order number
     * to each visited node.
     */
    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        ArrayList<Node<E>> list = new ArrayList<>();
        ArrayList<Node<E>> visited = new ArrayList<>();
        postOrder(root, list, visited);
        return list;
    }

    /**
     * Returns a list of ALL nodes in the graph ordered as
     * post-order of the depth first forest resulting from
     * depth first search starting at arbitrary start nodes.
     * </p>
     * The algorithm also attaches a post-order number
     * to each visited node.
     */
    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g) {
        ArrayList<Node<E>> list = new ArrayList<>();
        ArrayList<Node<E>> visited = new ArrayList<>();
        for (E item:g.allItems()) {
            postOrder(g.getNodeFor(item), list, visited);
        }
        return list;
    }

    /**
     * Returns a list of ALL nodes in the graph ordered as
     * post-order of the depth first forest resulting from
     * depth first search starting at arbitrary start nodes.
     * </p>
     * The algorithm attaches a depth-first number if <tt>attach_dfs_number</tt>
     * is <tt>true</tt>, otherwise it attaches a post-order number.
     */
    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number)
    {
        return null;
    }

    /**
     * Returns <tt>true</tt> if the graph contains one or more cycles,
     * otherwise <tt>false</tt>
     */
    @Override
    public boolean isCyclic(DirectedGraph<E> graph)
    {
        for(E item : graph.allItems())
        {
            Node<E> node = graph.getNodeFor(item);
            Iterator<Node<E>> it = node.succsOf();
            while(it.hasNext())
            {
                if(node == it.next())
                {
                    return true;
                }
            }
        }
        return false;

    }


    /**
     * Returns a list of all nodes in the graph ordered topological.
     * The algorithm assumes that the graph is acyclic. The result for
     * graphs with cycles are undefined.
     */
    @Override
    public List<Node<E>> topSort(DirectedGraph<E> graph) {
        if(isCyclic(graph)) {
            return null;
        }
        ArrayList<Node<E>> list = new ArrayList<>();
        ArrayList<Node<E>> visited = new ArrayList<>();
        for (E item:graph.allItems()) {
            topoSort(graph.getNodeFor(item), list, visited);
        }
        return list;
    }

    private void topoSort(Node<E> root, List<Node<E>> list, List<Node<E>> visited)
    {
        if(!visited.contains(root)) {
            visited.add(root);
            Iterator<Node<E>> it = root.predsOf();
            while (it.hasNext()) {
                topoSort(it.next(), list, visited);
            }
            root.num = list.size();
            list.add(root);
        }
    }

    private void dfs(Node<E> root, List<Node<E>> list)
    {
        if(!list.contains(root)) {
            root.num = list.size();
            list.add(root);
            Iterator<Node<E>> it = root.succsOf();
            while (it.hasNext()) {
                dfs(it.next(), list);
            }
        }
    }

    private void postOrder(Node<E> root, ArrayList<Node<E>> list, ArrayList<Node<E>> visited)
    {
        if(!visited.contains(root)) {
            visited.add(root);
            Iterator<Node<E>> it = root.succsOf();
            while (it.hasNext()) {
                postOrder(it.next(), list, visited);
            }
            root.num = list.size();
            list.add(root);
        }
    }
}
