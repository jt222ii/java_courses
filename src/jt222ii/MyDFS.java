package jt222ii;

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
        LinkedList<Node<E>> list = new LinkedList<>();
        Set<Node<E>> visited = new HashSet<>();
        //If the graph has heads use them as root
        if(graph.headCount() != 0)
        {
            Iterator<Node<E>> headItr = graph.heads();
            while(headItr.hasNext())
            {
                dfs(headItr.next(), list, visited);
            }
        }
        else //if the graph has no heads use the first node in the graph list
        {
            dfs(graph.getNodeFor(graph.allItems().get(0)), list, visited);
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
        //If the graph has heads use them as root
        if(g.headCount() != 0)
        {
            Iterator<Node<E>> headItr = g.heads();
            while(headItr.hasNext())
            {
                postOrder(headItr.next(), list, visited);
            }
        }
        else//if the graph has no heads use the first node in the graph list
        {
            postOrder(g.getNodeFor(g.allItems().get(0)), list, visited);
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
    //Don't know what this is used for. Not used in test and Johan said there was no need to implement it
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
            while(it.hasNext())//If the graph contains any backwards edges the graph is cyclic
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
        if(isCyclic(graph)) {
            return null;
        }
        for (Node<E> n : graph) {
            topoSort(n, list, visited);
        }
        return list;
    }

    /**
     * Recursive function that returns a list containing the result of a depth first search
     * @param root
     * @param list
     * @param visited
     * @return
     */
    private List<Node<E>> dfs(Node<E> root, LinkedList<Node<E>> list, Set<Node<E>> visited)
    {
        if(!visited.contains(root)) {
            root.num = list.size();
            list.add(root);
            visited.add(root);
            // for each successor in of the root node make a recursive call for each successor
            Iterator<Node<E>> it = root.succsOf();
            while (it.hasNext()) {
                dfs(it.next(), list, visited);
            }
        }
        return list;
    }

    /**
     * Recursive function that returns a list containing the result of the postorder from the root
     * @param root
     * @param list
     * @param visited
     * @return
     */
    private List<Node<E>> postOrder(Node<E> root, LinkedList<Node<E>> list, Set<Node<E>> visited)
    {
        if(!visited.contains(root)) {
            visited.add(root);
            // for each successor in of the root node make a recursive call for each successor
            Iterator<Node<E>> it = root.succsOf();
            while (it.hasNext()) {
                postOrder(it.next(), list, visited);
            }
            root.num = list.size()+1;
            list.add(root);
        }
        return list;
    }

    /**
     * Recursive function that returns a list containing the result of a topological sort
     * @param root
     * @param list
     * @param visited
     * @return
     */
    private List<Node<E>> topoSort(Node<E> root, LinkedList<Node<E>> list, Set<Node<E>> visited) {
        //Topo sort is the reversed result of postorder
        postOrder(root, list, visited); //call the postorder to set list to the result of postorder

        //Reverse the list
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
