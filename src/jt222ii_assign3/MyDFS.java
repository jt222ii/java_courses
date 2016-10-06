package jt222ii_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

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
        LinkedList<Node<E>> list = new LinkedList<>();
        Set<Node<E>> visited = new HashSet<>();
        return dfs(root, list, visited);
    }

    /**
     * Returns the nodes visited by a depth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a depth-first number.
     */
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph)
    {
        //Outcommented code does not seem to work. It was added later. It works in the tests but not in the benchmark..
        /*if(graph.headCount() != 0)
        {
            Iterator<Node<E>> headItr = graph.heads();
            while(headItr.hasNext())
            {
                dfs(headItr.next());
            }
        }
        else
        {
            dfs(graph.getNodeFor(graph.allItems().get(0)));
        }*/
        LinkedList<Node<E>> list = new LinkedList<>();
        Set<Node<E>> visited = new HashSet<>();
        for (E item:graph.allItems()) {
            dfs(graph.getNodeFor(item), list, visited);
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

        //list.clear();
        //visited.clear();
        LinkedList<Node<E>> list = new LinkedList<>();
        Set<Node<E>> visited = new HashSet<>();
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
        LinkedList<Node<E>> list = new LinkedList<>();
        Set<Node<E>> visited = new HashSet<>();
        //list.clear();
        //visited.clear();
        if(g.headCount() != 0)
        {
            Iterator<Node<E>> headItr = g.heads();
            while(headItr.hasNext())
            {
                postOrder(headItr.next(), list, visited);
            }
        }
        else
        {
            postOrder(g.getNodeFor(g.allItems().get(0)), list, visited);
        }
        /*for (E item:g.allItems()) {
            postOrder(g.getNodeFor(item), list, visited);
        }*/
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
        for(Node<E> node : postOrder(graph))
        {
            Iterator<Node<E>> it = node.succsOf();
            while(it.hasNext())
            {
                if(node.num <= it.next().num)
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
        LinkedList<Node<E>> list = new LinkedList<>();
        Set<Node<E>> visited = new HashSet<>();
        //list.clear();
        //visited.clear();
        if(isCyclic(graph)) {
            return null;
        }
        for (E item:graph.allItems()) {
            topoSort(graph.getNodeFor(item), list, visited);
        }
        return list;
    }

    private List<Node<E>> dfs(Node<E> root, LinkedList<Node<E>> list, Set<Node<E>> visited)
    {
        if(!visited.contains(root)) {
            root.num = list.size();
            list.add(root);
            visited.add(root);
            Iterator<Node<E>> it = root.succsOf();
            while (it.hasNext()) {
                dfs(it.next(), list, visited);
            }
        }
        return list;
    }

    private List<Node<E>> postOrder(Node<E> root, LinkedList<Node<E>> list, Set<Node<E>> visited)
    {
        if(!visited.contains(root)) {
            visited.add(root);
            Iterator<Node<E>> it = root.succsOf();
            while (it.hasNext()) {
                postOrder(it.next(), list, visited);
            }
            root.num = list.size()+1;
            list.add(root);
        }
        return list;
    }

    private List<Node<E>> topoSort(Node<E> root, LinkedList<Node<E>> list, Set<Node<E>> visited) {
        postOrder(root, list, visited);
        int x = 0;
        int y = list.size()-1;
        while (x < y) {
            Node<E> temp = list.get(x);
            list.set( x, list.get(y));
            list.set( y, temp);
            x++; y--;
        }
        return list;
    }
}
