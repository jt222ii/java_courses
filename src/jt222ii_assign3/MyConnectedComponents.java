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

    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
        Collection<Collection<Node<E>>> toReturn = new HashSet<>(); //main list that is return in the end of the function
        Map<Node<E>, Collection<Node<E>>> visited = new HashMap<>(); //map with all the visited nodes as keys and their collection as value. For easier mergin.
        Set<Node<E>> toVisit = new HashSet<>(); //set used to store all nodes that need to be visited
        MyDFS<E> dfs = new MyDFS<>(); //dfs
        dg.iterator().forEachRemaining(toVisit::add); //add all nodes to the toVisit set
        Iterator<Node<E>> itr = dg.heads(); //iterate through all the heads
        while(!toVisit.isEmpty() && itr.hasNext())
        {
            Node<E> head = itr.next();
            if(!visited.containsKey(head)) //if the node is not already added add the dfs from that node
            {
                HashSet<Node<E>> toAdd = new HashSet<>(); //list of all the nodes that need to be added
                boolean merge = false;//boolean to store if a merge happens instead of a normal add to the main list "toReturn"
                Node<E> tmpNode = null; //used to store a node to get the collection from that node later
                List<Node<E>> dfsList = dfs.dfs(dg, head); //dfs from the head
                Iterator<Node<E>> iterator = dfsList.iterator(); //iterate through the dfs result
                while(iterator.hasNext())
                {
                    Node<E> node = iterator.next();
                    if(!visited.containsKey(node)) //if it does not already exist add it to the temporary list "toAdd" also add it to the visited map
                    {
                        toAdd.add(node);
                        visited.put(node, toAdd);
                    }
                    else //else a merge is about to happen. Store the node as tmpNode to use when finding what collection to merge with
                    {
                        merge = true;
                        tmpNode = node;
                    }
                }
                if(merge)//if a merge is to happen get the collection and add the values of the tmpList to it
                {
                    visited.get(tmpNode).addAll(toAdd);
                }
                else//if no merge is to happen add the list to the main list.
                {
                    toReturn.add(toAdd);
                }
                toVisit.removeAll(dfsList);//remove all elements visited from the toVisit set.
            }
        }
        itr = toVisit.iterator(); //iterate through the nodes that are not already visited
        while(itr.hasNext())
        {
            Node<E> n = itr.next();
            if(!visited.containsKey(n))
            {
                List<Node<E>> dfsList = dfs.dfs(dg, n);//dfs from the node
                dfsList.iterator().forEachRemaining(node -> visited.put(node, dfsList)); //add all nodes of the dfs result to visited
                toReturn.add(dfsList);//add the list to the return list
            }
            itr.remove(); //remove the node from the toVisit set
        }
        return toReturn;
    }
}


