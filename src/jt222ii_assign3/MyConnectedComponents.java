package jt222ii_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by jonastornfors on 2016-09-27.
 */
public class MyConnectedComponents<E> implements graphs.ConnectedComponents<E> {
    /**
     * Two nodes a and b are directly connected if their exist an edge (a,b)
     * or an edge (b,a). Two nodes a and k are connected if there exist a sequence
     * of nodes [a,b,c,d, ... j,k] such that [a,b], [b,c], [c,d], [d,e], ..., [j,k]
     * are all directly connected.
     * <p/>
     * Problem: find a partitioning of the graph nodes such that two nodes belongs to the
     * same partitioning if and only if they are connected.
     * </p>
     * The result is a collection of node collections.
     *
     * @author jonasl
     *
     */
    /*private Set<Node<E>> visited = new HashSet<>();
    private LinkedList<Node<E>> nodes = new LinkedList<>();
    private Collection<Collection<Node<E>>> mainList = new LinkedList<>();
    private MyDFS<E> dfs = new MyDFS<>();*/
    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
        /*visited.clear();
        nodes.clear();
        mainList.clear();*/
        Set<Node<E>> visited = new HashSet<>();
        LinkedList<Node<E>> nodes = new LinkedList<>();
        Collection<Collection<Node<E>>> mainList = new LinkedList<>();
        MyDFS<E> dfs = new MyDFS<>();
        dg.iterator().forEachRemaining(nodes::add); //for each node in the graph add it to the list of nodes

        for (Node<E> n : nodes) //foreach node in the list of nodes
        {
            List<Node<E>> tmpList = dfs.dfs(dg, n); //add the result of the dfs

            List<Node<E>> nodesToAdd = new LinkedList<>(); //list of the nodes to add to the main list

            for(Node<E> node : tmpList) //for each node in the temporary list we got from the dfs
            {
                if(!visited.contains(node))
                {
                    visited.add(node); //add the node to the visited list
                    nodesToAdd.add(node);//add the node to the list that will be added to the main list
                    if(node.inDegree() > 0) // if the node has any predecessors
                    {
                        addPreds(nodesToAdd, node, visited); //add the predecessor to the nodesToAdd as well
                    }

                }
            }
            if(nodesToAdd.size() > 0)//if the nodesToAdd list has anything to add... add it to the mainList
            {
                mainList.add(nodesToAdd);
            }
        }
        return mainList;
    }

    /**
     * Recursive function that adds all the predecessors and predecessors of predecessors to the list
     * @param list
     * @param n
     * @return list
     */
    private List<Node<E>> addPreds(List<Node<E>> list, Node<E> n, Set<Node<E>> visited)
    {
        //Iterate through the predecessors
        Iterator<Node<E>> itr = n.predsOf();
        while(itr.hasNext())
        {
            Node<E> node = itr.next();
            if(!visited.contains(node)) {
                //add the node to the list and visited
                list.add(node);
                visited.add(node);
                //if the node has predecessors. Add them as well
                if (node.inDegree() > 0) {
                    list = addPreds(list, node, visited);
                }
            }
        }
        return list;
    }
}


