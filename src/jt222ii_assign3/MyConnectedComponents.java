package jt222ii_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

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
    private Set<Node<E>> visited = new HashSet<>();
    private LinkedList<Node<E>> nodes = new LinkedList<>();
    private MyDFS<E> dfs = new MyDFS<>();
    private Map<Node<E>, Collection<Node<E>>> map = new HashMap<>();
    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
        Collection<Collection<Node<E>>> mainList = new LinkedList<>();
        LinkedList<LinkedList<Node<E>>> tmpMainList = new LinkedList<>();
        visited.clear();
        nodes.clear();
        //dg.iterator().forEachRemaining(nodes::add); //for each node in the graph add it to the list of nodes

        Iterator<Node<E>> nodesItr = dg.iterator();
        while (nodesItr.hasNext()) //foreach node in the list of nodes
        {
            Node<E> n = nodesItr.next();
            if(!visited.contains(n)) {
                List<Node<E>> tmpList = dfs.dfs(dg, n); //add the result of the dfs

                LinkedList<Node<E>> nodesToAdd = new LinkedList<>(); //list of the nodes to add to the main list

                boolean merged = false;
                for (Node<E> node : tmpList) //for each node in the temporary list we got from the dfs
                {
                    if (!visited.contains(node)) {
                        visited.add(node); //add the node to the visited list
                        nodesToAdd.add(node);//add the node to the list that will be added to the main list
                        map.put(node, nodesToAdd);
                    } else if (node != n) {
                        merged = true;
                        tmpMainList.get(tmpMainList.indexOf(map.get(node))).addAll(nodesToAdd);
                    }

                }

                if (nodesToAdd.size() > 0 && !merged)//if the nodesToAdd list has anything to add... add it to the mainList
                {
                    tmpMainList.add(nodesToAdd);
                }
            }
        }
        mainList.addAll(tmpMainList);
        return mainList;
    }
}


